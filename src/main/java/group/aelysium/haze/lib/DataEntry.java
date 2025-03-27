package group.aelysium.haze.lib;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

public class DataEntry implements AutoCloseable {
    private final Map<String, Object> entries;
    private boolean closed = false;

    private DataEntry() {
        this.entries = Map.of();
    }

    protected DataEntry(@NotNull Map<String, Object> entries) {
        this.entries = entries;
    }

    public int countKeys() {
        return this.entries.size();
    }

    public boolean isEmpty(@NotNull String name) {
        return this.entries.get(name) == null;
    }
    public boolean isPresent(@NotNull String name) {
        return !this.isEmpty(name);
    }

    public boolean isString(@NotNull String name) {
        this.checkClosed();
        return this.entries.get(name) instanceof String;
    }
    public String getString(@NotNull String name) {
        return this.get(name);
    }

    public boolean isByte(@NotNull String name) {
        this.checkClosed();
        return this.entries.get(name) instanceof Byte;
    }
    public byte getByte(@NotNull String name) {
        return this.get(name);
    }

    public boolean isShort(@NotNull String name) {
        this.checkClosed();
        return this.entries.get(name) instanceof Short;
    }
    public short getShort(@NotNull String name) {
        return this.get(name);
    }

    public boolean isInt(@NotNull String name) {
        this.checkClosed();
        return this.entries.get(name) instanceof Integer;
    }
    public int getInt(@NotNull String name) {
        return this.get(name);
    }

    public boolean isLong(@NotNull String name) {
        this.checkClosed();
        return this.entries.get(name) instanceof Long;
    }
    public long getLong(@NotNull String name) {
        return this.get(name);
    }

    public boolean isFloat(@NotNull String name) {
        this.checkClosed();
        return this.entries.get(name) instanceof Float;
    }
    public float getFloat(@NotNull String name) {
        return this.get(name);
    }

    public boolean isDouble(@NotNull String name) {
        this.checkClosed();
        return this.entries.get(name) instanceof Double;
    }
    public double getDouble(@NotNull String name) {
        return this.get(name);
    }

    public boolean isBoolean(@NotNull String name) {
        this.checkClosed();
        return this.entries.get(name) instanceof Boolean;
    }
    public boolean getBoolean(@NotNull String name) {
        return this.get(name);
    }

    public boolean isDate(@NotNull String name) {
        return this.entries.get(name) instanceof LocalDate;
    }
    public LocalDate getDate(@NotNull String name) {
        return this.get(name);
    }

    public boolean isDateTime(@NotNull String name) {
        this.checkClosed();
        return this.entries.get(name) instanceof LocalDateTime;
    }
    public LocalDateTime getDateTime(@NotNull String name) {
        return this.get(name);
    }

    public boolean isTime(@NotNull String name) {
        this.checkClosed();
        return this.entries.get(name) instanceof LocalTime;
    }
    public LocalTime getTime(@NotNull String name) {
        return this.get(name);
    }

    public boolean isBinary(@NotNull String name) {
        this.checkClosed();
        return this.entries.get(name) instanceof byte[];
    }
    public byte[] getBinary(@NotNull String name) {
        return this.get(name);
    }

    public boolean isBinaryStream(@NotNull String name) {
        this.checkClosed();
        return this.entries.get(name) instanceof InputStream;
    }
    public InputStream getBinaryStream(@NotNull String name) {
        return this.get(name);
    }

    public <T> T get(@NotNull String name) {
        this.checkClosed();
        return (T) this.entries.get(name);
    }

    private void checkClosed() throws UnsupportedOperationException {
        if(this.closed) throw new UnsupportedOperationException("This FuzyEntry has been closed, you aren't allowed to access it anymore!");
    }

    @Override
    public void close() throws Exception {
        this.closed = true;
    }

    public static DataEntry wrap(Map<String, Object> map) {
        return new DataEntry(map);
    }
}