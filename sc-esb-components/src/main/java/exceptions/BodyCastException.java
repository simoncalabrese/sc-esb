package exceptions;

import baseObjects.ScExceptionBody;

/**
 * Created by simon.calabrese on 03/10/2017.
 */
public class BodyCastException extends ScException {

    public BodyCastException() {
    }

    public BodyCastException(ScExceptionBody scExceptionBody) {
        super(scExceptionBody);
    }
}
