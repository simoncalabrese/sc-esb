package baseObjects;

import exceptions.BodyCastException;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public abstract class ScRequest extends AbstractScope {
    private Object body;

    public Object getBody() {
        return body;
    }

    public <T> T getBody(final Class<T> caster) throws BodyCastException {
        try {
            final T dest = caster.newInstance();
            BeanUtils.copyProperties(dest, body);
            return dest;
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new BodyCastException();
        }
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
