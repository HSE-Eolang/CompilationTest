package eo.org.eolang.io;

import eo.org.eolang.core.data.EOData;
import eo.org.eolang.core.EOObject;

public class EOstdout extends EOObject {

    private EOObject out;

    public EOstdout(EOObject out){
        this.out = out._setParent(this);
    }

    @Override
    public EOData _getData() {
        EOData res = out._getData();
        System.out.println(res);
        _freeAttributes();
        return res;
    }
}
