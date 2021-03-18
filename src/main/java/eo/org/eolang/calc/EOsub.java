package eo.org.eolang.calc;

import eo.org.eolang.core.data.EOData;
import eo.org.eolang.core.data.EODataObject;
import eo.org.eolang.core.EOObject;
import eo.org.eolang.core.data.EOExpressionObject;

public class EOsub extends EOExpressionObject {
    private EOObject val1;
    private EOObject val2;
    //TODO add float support
    public EOsub( EOObject val1, EOObject val2){
        this.val1 = val1._setParent(this);
        this.val2 = val2._setParent(this);
        if(val1._isCalculable() && val2._isCalculable()){
            _data = new EOData(val1._getData().toInt() - val2._getData().toInt());
        }

    }

    @Override
    public EOData _getData() {
        if(_isCalculable()){
            return _data;
        }else {
            return new EOData(val1._getData().toInt() - val2._getData().toInt());
        }
    }
}
