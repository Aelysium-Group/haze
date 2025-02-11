package group.aelysium.haze.lib;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

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

    public Type unique() {
        this.unique = true;
        return this;
    }
    public boolean isUnique() {
        return this.unique;
    }

    public Type length(int length) {
        this.length = length;
        return this;
    }
    public int length() {
        return this.length;
    }

    public Type nullable() {
        this.nullable = true;
        return this;
    }
    public boolean isNullable() {
        return this.nullable;
    }

    public Type primaryKey() {
        this.primaryKey = true;
        return this;
    }
    public boolean isPrimaryKey() {
        return this.primaryKey;
    }

    public static Type STRING() {
        return new Type(DataType.STRING);
    }
    public static Type STRING(int length) {
        return new Type(DataType.STRING).length(length);
    }
    public static Type INTEGER() {
        return new Type(DataType.INTEGER);
    }
    public static Type INTEGER(int size) {
        return new Type(DataType.INTEGER).length(size);
    }
    public static Type DECIMAL() {
        return new Type(DataType.DECIMAL);
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
        DECIMAL,
        BOOLEAN,
        DATE,
        DATETIME,
        TIME,
        BINARY,
        ARRAY,
        OBJECT
    }
}