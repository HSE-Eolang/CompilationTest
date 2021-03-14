package eo.org.eolang.core;

import eo.org.eolang.core.data.EOData;

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
