package group.aelysium.lib;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * DataHolder is an abstraction of tables and collections.
 */
public class DataHolder {
    private final String name;
    private final Set<DataKey> keys = new HashSet<>();

    public DataHolder(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
    public void addKey(DataKey key) {
        this.keys.add(key);
    }

    public Set<DataKey> keys() {
        return Collections.unmodifiableSet(keys);
    }
}