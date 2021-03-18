package eo.org.eolang.calc;

import eo.org.eolang.core.data.EOData;
import eo.org.eolang.core.data.EODataObject;
import eo.org.eolang.core.EOObject;
import eo.org.eolang.core.data.EOExpressionObject;

/**
 * Объект, при датаризации которого выполняется арифметическое сложение результатов датаризации свободных атрибутов.
 */
public class EOadd extends EOExpressionObject {
    private EOObject val1;
    private EOObject val2;

    //TODO add float support
    public EOadd( EOObject val1, EOObject val2){
        this.val1 = val1._setParent(this);
        this.val2 = val2._setParent(this);
        if(val1._isCalculable() && val2._isCalculable()){
            _data = new EOData(val1._getData().toInt() + val2._getData().toInt());
        }
    }

    @Override
    public EOData _getData() {
        if(_isCalculable()){
            return _data;
        }
        return new EOData(val1._getData().toInt() + val2._getData().toInt());
    }
}
