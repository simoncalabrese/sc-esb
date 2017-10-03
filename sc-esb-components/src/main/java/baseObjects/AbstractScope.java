package baseObjects;

import enums.ScopeLevel;
import exceptions.ScopeNotFoundException;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

/**
 * Created by simon.calabrese on 03/10/2017.
 */
public abstract class AbstractScope {
    private ConcurrentHashMap<String, Object> scopeVars;
    private AbstractScope parentScope;
    private ScopeLevel scopeLevel;

    @SuppressWarnings("unchecked")
    public <T> T getScopeVar(final String key) {
        return this.scopeVars.containsKey(key) ? (T) this.scopeVars.get(key) : null;
    }

    public void setScopeVar(final String key, Object value) {
        scopeVars.put(key, value);
    }

    public void setScopeVar(final String key, final Object value, final ScopeLevel scopeLevel) throws ScopeNotFoundException {
        flatScope().filter(e -> e.scopeLevel == scopeLevel).findFirst().map(e -> {
            e.setScopeVar(key,value);
            return e;
        }).orElseThrow(ScopeNotFoundException::new);
    }

    @SuppressWarnings("unchecked")
    public <T> T getScopeVar(final String key, final ScopeLevel scopeLevel) throws ScopeNotFoundException {
        return flatScope().filter(e -> e.scopeLevel == scopeLevel).findFirst().map(e -> (T) e.getScopeVar(key)).orElseThrow(ScopeNotFoundException::new);
    }

    private Stream<AbstractScope> flatScope() {
        return Stream.concat(Stream.of(this),
                Optional.ofNullable(parentScope).map(AbstractScope::flatScope).orElse(Stream.empty()));
    }

    private AbstractScope getParentScope() {
        return parentScope;
    }

    private void setParentScope(AbstractScope parentScope) {
        this.parentScope = parentScope;
    }

    private ScopeLevel getScopeLevel() {
        return scopeLevel;
    }

    private void setScopeLevel(ScopeLevel scopeLevel) {
        this.scopeLevel = scopeLevel;
    }
}
