package baseObjects;

import java.io.Serializable;

public class ScVars implements Serializable {
    private Object attribute;

    public Object getAttribute() {
        return attribute;
    }

    public void setAttribute(Object attribute) {
        this.attribute = attribute;
    }
}
