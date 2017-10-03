package exceptions;

import baseObjects.ScExceptionBody;

/**
 * Created by simon.calabrese on 03/10/2017.
 */
public class ScException extends Exception {

    public ScException() {
        super();
    }

    public ScException(ScExceptionBody scExceptionBody) {
        super(scExceptionBody.getException());
    }
}
