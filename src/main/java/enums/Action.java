package enums;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Action {
    PING("!ping");
    public final String label;

    private static final Map<String,Action> ENUM_MAP;

    private Action(String label) {
        this.label = label;
    }
    static {
        Map<String,Action> map = new ConcurrentHashMap<String, Action>();
        for (Action instance : Action.values()) {
            map.put(instance.label,instance);
        }
        ENUM_MAP = Collections.unmodifiableMap(map);
    }

    public static Action get (String name) {
        return ENUM_MAP.get(name);
    }
}
