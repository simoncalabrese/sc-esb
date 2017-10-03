package baseObjects;

import exceptions.ScException;

/**
 * Created by simon.calabrese on 03/10/2017.
 */
public abstract class ScExceptionBody {
    private Exception exception;

    public void setException(final Exception exception) {
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public void setExceptionAndThrow(final Exception exception) throws ScException {
        setException(exception);
        throw new ScException(this);
    }
}
