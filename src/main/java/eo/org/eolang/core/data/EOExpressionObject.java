package eo.org.eolang.core.data;

import eo.org.eolang.core.EOObject;
import eo.org.eolang.core.data.EOData;

public abstract class EOExpressionObject extends EOObject {
    protected EOData _data;
    public boolean _isCalculable(){return _data!=null;}
}
