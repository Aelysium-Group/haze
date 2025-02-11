package group.aelysium.haze.lib;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class Filterable {
    private final List<KeyValue<String, FilterValue>> filters = new ArrayList<>();
    private final Set<String> groupBy = new HashSet<>();
    private final List<KeyValue<String, Ordering>> orderBy = new ArrayList<>();
    private Integer limit = null;

    /**
     * Lets the caller filter their request based on typical filtering options.
     * Filters will be made in the same order they were added.
     * @param key The key to filter for.
     * @param value The {@link FilterValue} to filter with.
     */
    public void filterBy(@NotNull String key, @NotNull FilterValue value) {
        this.filters.add(new KeyValue<>(key, value));
    }
    public @NotNull List<KeyValue<String, FilterValue>> filterBy() {
        return Collections.unmodifiableList(this.filters);
    }

    /**
     * Lets the caller group the request by certain keys.
     * Groupings will be ordered in the order they are added.
     * @param key The key to group by.
     */
    public void groupBy(@NotNull String key) {
        this.groupBy.add(key);
    }
    public @NotNull Set<String> groupBy() {
        return Collections.unmodifiableSet(this.groupBy);
    }

    /**
     * Lets the caller limit the number of entries that are returned.
     * @param limit The limit to use.
     */
    public void limit(Integer limit) {
        this.limit = limit;
    }
    public @Nullable Integer limit() {
        return this.limit;
    }

    /**
     * Lets the caller order by certain keys.
     * Orderings will be in the same order that they were added.
     * @param key The key to order by.
     * @param value The ordering to enforce.
     */
    public void orderBy(@NotNull String key, @NotNull Ordering value) {
        this.orderBy.add(new KeyValue<>(key, value));
    }
    public @NotNull List<KeyValue<String, Ordering>> orderBy() {
        return Collections.unmodifiableList(this.orderBy);
    }

    public enum Ordering {
        ASCENDING,
        DESCENDING
    }
    public record KeyValue<K, V>(K key, V value) {}
    public record FilterValue(Object value, Qualifier equality) {}
    public enum Qualifier {
        /**
         * Validates that the two values are equal.
         */
        EQUALS,

        /**
         * Validates that the two values are not equal.
         */
        NOT_EQUALS,

        /**
         * Validates that the original value contains the passed value.
         * In instances such as numbers, the actual output is unpredictable and not supported.
         * In instances such as strings, this option will search to original string to find a version of the substring within it.
         */
        CONTAINS,

        /**
         * Validates that the original value does not contain the passed value.
         * In instances such as numbers, the actual output is unpredictable and not supported.
         * In instances such as strings, this option will search to original string to ensure a version of the substring isn't within it.
         */
        NOT_CONTAINS,

        /**
         * Validates that the passed value is greater than the original value.
         */
        GREATER_THAN,

        /**
         * Validates that the passed value is less than the original value.
         */
        LESS_THAN,

        /**
         * Validates that the passed value is greater than or equal to the original value.
         */
        GREATER_THAN_OR_EQUAL,

        /**
         * Validates that the passed value is less than or equal the original value.
         */
        LESS_THAN_OR_EQUAL,

        /**
         * Validates that the passed value is null.
         */
        IS_NULL,

        /**
         * Validates that the passed value is not null.
         */
        IS_NOT_NULL
    }
}