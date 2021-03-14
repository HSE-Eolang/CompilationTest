package eo.org.eolang.core.data;

public class EOData {
    private Object _data;

    public EOData(Object _data){
        this._data = _data;
    }

    @Override
    public String toString() {
        if(_data.getClass().equals(String.class) ){
            return (String)_data;
        }
        return "";
    }
    public Object toObject() {
        return _data;
    }

    public Long toInt() {
        if(_data.getClass().equals(Long.class)){
            return (Long)_data;
        }
        if(_data.getClass().equals(Integer.class) ){
            return Long.valueOf((Integer)_data);
        }
        return 0L;
    }

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
