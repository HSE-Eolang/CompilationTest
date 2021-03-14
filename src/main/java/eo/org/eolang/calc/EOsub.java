package eo.org.eolang.calc;

import eo.org.eolang.core.EOData;
import eo.org.eolang.core.EODataObject;
import eo.org.eolang.core.EOObject;

public class EOsub extends EODataObject {

    //TODO add float support
    public EOsub(EOObject val1, EOObject val2){
        super(val1._getData().toInt() - val2._getData().toInt());
    }
}
