package exceptions;

import baseObjects.ScExceptionBody;

/**
 * Created by simon.calabrese on 03/10/2017.
 */
public class ScopeNotFoundException extends ScException {

    public ScopeNotFoundException() {
    }

    public ScopeNotFoundException(ScExceptionBody scExceptionBody) {
        super(scExceptionBody);
    }
}
