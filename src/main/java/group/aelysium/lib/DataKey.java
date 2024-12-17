package group.aelysium.lib;

import java.util.Objects;

public class DataKey {
    private final String name;
    private final DataType type;
    private boolean nullable = false;
    private int length = 0;
    private boolean unique = false;

    public DataKey(String name, DataType type) {
        this.name = name;
        this.type = type;
    }

    public String name() {
        return name;
    }
    public DataType type() {
        return type;
    }

    public DataKey unique(boolean unique) {
        this.unique = unique;
        return this;
    }
    public boolean unique() {
        return this.unique;
    }

    public DataKey length(int length) {
        this.length = length;
        return this;
    }
    public int length() {
        return this.length;
    }

    public DataKey nullable(boolean nullable) {
        this.nullable = nullable;
        return this;
    }
    public boolean nullable() {
        return this.nullable;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DataKey dataKey = (DataKey) o;
        return Objects.equals(name, dataKey.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public enum DataType {
        STRING,
        INTEGER,
        DECIMAL,
        BOOLEAN,
        DATE,
        DATETIME,
        TIME,
        NULL,
        BINARY,
        ARRAY,
        OBJECT
    }
}