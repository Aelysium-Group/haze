package group.aelysium.haze.lib;

import java.util.Objects;

/**
 * Indicates a key/value pair.
 * Calling this.equals(other) will return as long as the two key instances are equal.
 * @param key The key.
 * @param value The value.
 */
public record KeyValue<K, V>(K key, V value) {
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        KeyValue<?, ?> keyValue = (KeyValue<?, ?>) o;
        return Objects.equals(key, keyValue.key);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }
}