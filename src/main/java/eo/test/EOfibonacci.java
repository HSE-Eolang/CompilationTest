package eo.test;

import eo.org.eolang.calc.*;
import eo.org.eolang.core.data.EOData;
import eo.org.eolang.core.data.EODataObject;
import eo.org.eolang.core.EOObject;

public class EOfibonacci extends EOObject{
    private EOObject n;

    public EOfibonacci(EOObject n){
        this.n = n._setParent(this);
    }

    @Override
    public EOData _getData() {
        return  new EOif(
                new EOless(n, new EODataObject(3)),
                new EOfibonacci$EOsmall(n),
                new EOfibonacci$EOrec(n, new EODataObject(1L), new EODataObject(1L))
        )._setParent(this)._getData();
    }

}
