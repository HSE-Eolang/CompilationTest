package eo.org.eolang.core.data;

/**
 * Объект представляющий данные - результат датаризации в EO.
 */
public class EOData {
    /**
     * Данные
     */
    private Object _data;

    public EOData(Object _data){
        this._data = _data;
    }

    /**
     * Приведение типа данных к строке
     */
    @Override
    public String toString() {
        if(_data.getClass().equals(String.class) ){
            return (String)_data;
        }
        if(_data.getClass().equals(Long.class) ){
            return _data.toString();
        }
        if(_data.getClass().equals(Integer.class) ){
            return _data.toString();
        }
        return "";
    }

    public Object toObject() {
        return _data;
    }

    /**
     * Приведение типа данных к целому числу
     */
    public Long toInt() {
        if(_data.getClass().equals(Long.class)){
            return (Long)_data;
        }
        if(_data.getClass().equals(Integer.class) ){
            return Long.valueOf((Integer)_data);
        }
        return 0L;
    }

    /**
     * Приведение типа данных к логическому значению
     */
    public Boolean toBoolean(){
        if(_data.getClass().equals(Boolean.class) ){
            return (Boolean)_data;
        }
        if(_data.getClass().equals(Long.class)){
            return (Long)_data != 0L;
        }
        if(_data.getClass().equals(Integer.class) ){
            return (Integer)_data != 0;
        }

        return false;
    }
}
