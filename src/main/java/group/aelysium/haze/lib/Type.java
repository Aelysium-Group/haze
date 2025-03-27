package group.aelysium.haze.lib;

import org.jetbrains.annotations.NotNull;

public class Type {
    private final DataType type;
    private boolean nullable = false;
    private int length = 0;
    private boolean unique = false;
    private boolean primaryKey = false;

    public Type(@NotNull DataType type) {
        this.type = type;
    }

    public DataType type() {
        return type;
    }

    public Type unique(boolean unique) {
        this.unique = unique;
        return this;
    }
    public boolean unique() {
        return this.unique;
    }

    public Type length(int length) {
        this.length = length;
        return this;
    }
    public int length() {
        return this.length;
    }

    public Type nullable(boolean nullable) {
        this.nullable = nullable;
        return this;
    }
    public boolean nullable() {
        return this.nullable;
    }

    public Type primaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
        return this;
    }
    public boolean primaryKey() {
        return this.primaryKey;
    }

    public static Type STRING() {
        return new Type(DataType.STRING).length(1000);
    }
    public static Type STRING(int length) {
        return new Type(DataType.STRING).length(length);
    }
    public static Type INTEGER() {
        return new Type(DataType.INTEGER).length(4);
    }
    public static Type INTEGER(int size) {
        return new Type(DataType.INTEGER).length(size);
    }
    public static Type UNSIGNED_INTEGER() {
        return new Type(DataType.UNSIGNED_INTEGER).length(4);
    }
    public static Type UNSIGNED_INTEGER(int size) {
        return new Type(DataType.UNSIGNED_INTEGER).length(size);
    }
    public static Type DECIMAL() {
        return new Type(DataType.DECIMAL).length(4);
    }
    public static Type DECIMAL(int size) {
        return new Type(DataType.DECIMAL).length(size);
    }
    public static Type UNSIGNED_DECIMAL() {
        return new Type(DataType.UNSIGNED_DECIMAL).length(4);
    }
    public static Type UNSIGNED_DECIMAL(int size) {
        return new Type(DataType.UNSIGNED_DECIMAL).length(size);
    }
    public static Type BOOLEAN() {
        return new Type(DataType.BOOLEAN);
    }
    public static Type DATE() {
        return new Type(DataType.DATE);
    }
    public static Type DATETIME() {
        return new Type(DataType.DATETIME);
    }
    public static Type TIME() {
        return new Type(DataType.TIME);
    }
    public static Type BINARY(int size) {
        return new Type(DataType.BINARY).length(size);
    }
    public static Type ARRAY() {
        return new Type(DataType.ARRAY);
    }
    public static Type OBJECT() {
        return new Type(DataType.OBJECT);
    }

    public enum DataType {
        STRING,
        INTEGER,
        UNSIGNED_INTEGER,
        DECIMAL,
        UNSIGNED_DECIMAL,
        BOOLEAN,
        DATE,
        DATETIME,
        TIME,
        BINARY,
        ARRAY,
        OBJECT
    }
}