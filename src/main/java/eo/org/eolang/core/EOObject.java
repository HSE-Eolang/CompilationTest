package eo.org.eolang.core;

import eo.org.eolang.core.data.EOData;
import eo.org.eolang.core.data.EODataObject;
import eo.org.eolang.core.data.EONoData;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public abstract class EOObject implements Cloneable{
    protected EOObject _parent;
    public EOObject _setParent(EOObject _parent){
        this._parent = _parent;
        return this;
    }
    public EOData _getData(){
        _freeAttributes();
        return new EOData("");
    }

    public EOObject _clone() {
        try{
            EOObject res  = (EOObject)this.clone();
            for (Field field : this.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                EOObject value = (EOObject)field.get(this);
                field.set(this, value._clone());
            }
            return res;
        }catch (CloneNotSupportedException cnsException){
            cnsException.printStackTrace();
        }catch (IllegalAccessException iaException){
            iaException.printStackTrace();
        }
        return new EODataObject();

    }

    public void _freeAttributes(){
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                field.set(this, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

    public EOObject _getAttribute(String name) {
        try{
            for (Field field : this.getClass().getDeclaredFields()) {
                if (field.getName().equals(name)) {
                    field.setAccessible(true);
                    EOObject value = (EOObject) field.get(this);
                    return value._clone();
                }

            }
        }catch (IllegalAccessException iaException){
            iaException.printStackTrace();
        }
        try{
            Class<?> attClasss = Class.forName(this.getClass().getName()+"$EO"+name);
            Constructor<?> attConstructor = attClasss.getConstructor();
            return (EOObject)attConstructor.newInstance();
        } catch (Exception e) {}
        try{
            Class<?> attClasss = Class.forName("EO"+name);
            Constructor<?> attConstructor = attClasss.getConstructor();
            return (EOObject)attConstructor.newInstance();
        } catch (Exception e) {}
        return new EODataObject();
    }

    public EOObject _getAttribute(String name, EOObject... freeAtt) {
        try {
            Class<?> attClasss = _findAttClassByName(this, name);
            Constructor<?> attConstructor = Arrays.stream(attClasss.getConstructors())
                    .filter(constructor -> constructor.getParameterTypes().length == freeAtt.length)
                    .findFirst().get();
            return (EOObject)attConstructor.newInstance((Object[])freeAtt);
        } catch (Exception e) {}
        return new EODataObject();
    }

    private Class<?> _findAttClassByName(EOObject obj, String name){
        while(obj!=null){
            String className = obj.getClass().getName()+"$EO"+name;
            try {
                return Class.forName(className);
            } catch (ClassNotFoundException e) {}
            obj = obj._parent;
        }
        try {
            return Class.forName("EO"+name);
        } catch (ClassNotFoundException e) {}
        return null;
    }
}
