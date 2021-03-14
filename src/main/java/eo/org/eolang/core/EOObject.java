package eo.org.eolang.core;

public abstract class EOObject {
    protected EOObject _parent;
    public EOObject _setParent(EOObject _parent){
        this._parent = _parent;
        return this;
    }
    public EOData _getData(){
        return new EOData("");
    }
}
