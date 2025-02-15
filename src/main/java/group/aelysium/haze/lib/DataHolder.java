package group.aelysium.haze.lib;

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * DataHolder is an abstraction of tables and collections.
 */
public class DataHolder {
    private final String name;
    private final Map<String, Type> keys = new HashMap<>();
    private String primaryKey;

    public DataHolder(@NotNull String name) {
        this.name = name;
    }

    public @NotNull String name() {
        return name;
    }
    public void addKey(@NotNull String name, @NotNull Type type) {
        this.keys.put(name, type);
        if(type.primaryKey()) {
            if(primaryKey == null) primaryKey = name;
            else throw new RuntimeException("You can't specify more than a single primary key per DataHolder. Caused by: "+this.name+" - "+name);
        }
    }

    public Map<String, Type> keys() {
        return this.keys;
    }
}