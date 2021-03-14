package eo.org.eolang.calc;

import eo.org.eolang.core.EODataObject;
import eo.org.eolang.core.EOObject;

public class EOequal extends EODataObject {
    //TODO add float support
    public EOequal( EOObject val1, EOObject val2){
        super( val1._getData().toInt() == val2._getData().toInt());
    }
}
