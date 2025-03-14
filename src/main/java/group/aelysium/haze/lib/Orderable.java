package group.aelysium.haze.lib;

import org.jetbrains.annotations.NotNull;

public interface Orderable<T extends DataRequest> {
    /**
     * Lets the caller order by certain keys.
     * Orderings will be in the same order that they were added.
     * @param key The key to order by.
     * @param value The ordering to enforce.
     */
    T orderBy(@NotNull String key, @NotNull Ordering value);
    
    enum Ordering {
        ASCENDING,
        DESCENDING
    }
}
