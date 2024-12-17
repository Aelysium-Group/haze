package group.aelysium.lib;

import java.time.*;

public interface TabularQueryResult extends AutoCloseable {
    Object get(String columnName);
    boolean next() throws Exception;

    String getAsString(String columnName) throws ClassCastException;
    int getAsInteger(String columnName) throws ClassCastException;
    long getAsLong(String columnName) throws ClassCastException;
    float getAsFloat(String columnName) throws ClassCastException;
    double getAsDouble(String columnName) throws ClassCastException;
    boolean getAsBoolean(String columnName) throws ClassCastException;

    Instant getAsInstant() throws ClassCastException;
    LocalDate getAsDate() throws ClassCastException;
    LocalDateTime getAsDateTime() throws ClassCastException;
    ZonedDateTime getAsDateTimeZoned() throws ClassCastException;
    LocalTime getAsTime(String columnName) throws ClassCastException;

    boolean isNull(String columnName) throws ClassCastException;
    byte[] getAsBinary(String columnName) throws ClassCastException;
}
