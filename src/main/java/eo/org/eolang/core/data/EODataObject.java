package eo.org.eolang.core.data;

import eo.org.eolang.core.EOObject;
import eo.org.eolang.core.data.EOData;

public class EODataObject extends EOObject {

    protected EOData _data;

    public EODataObject(Object _data) {
        this._data = new EOData(_data);
    }

    public EOData _getData() {
        return _data;
    }
}
