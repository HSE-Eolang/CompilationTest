package eo.org.eolang.calc;

import eo.org.eolang.core.EOData;
import eo.org.eolang.core.EOObject;

public class EOif extends EOObject {
    private EOObject cond;
    private EOObject obj1;
    private EOObject obj2;

    public EOif( EOObject cond, EOObject obj1, EOObject obj2){
        this.cond = cond._setParent(this);
        this.obj1 = obj1._setParent(this);
        this.obj2 = obj2._setParent(this);
    }

    @Override
    public EOData _getData() {
        Boolean boolCond = cond._getData().toBoolean();
        if(boolCond){
            return obj1._getData();
        }else {
            return obj2._getData();
        }
    }
}
