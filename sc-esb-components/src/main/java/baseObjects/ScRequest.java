package baseObjects;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ScRequest {
    private ConcurrentHashMap<String,Object> scopeVars;

    public<T> T getRequestProperty(final String name) {
        return scopeVars.containsKey(name) ? (T) scopeVars.get(name) : null;
    }
}
