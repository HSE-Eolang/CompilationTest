package eo.test;

import eo.org.eolang.calc.EOequal;
import eo.org.eolang.calc.EOif;
import eo.org.eolang.core.EOData;
import eo.org.eolang.core.EODataObject;
import eo.org.eolang.core.EOObject;

public class EOfibonacci$EOsmall extends EOObject {
    private EOObject n;

    public EOfibonacci$EOsmall(EOObject n) {
        this.n = n._setParent(this);
    }

    @Override
    public EOData _getData() {
        return new EOif(
                new EOequal(n, new EODataObject(2)),
                new EODataObject(1L),
                n
        )._setParent(this)._getData();
    }
}
