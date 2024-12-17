package group.aelysium.lib;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.time.*;
import java.util.Set;

public interface DocumentQueryResult extends AutoCloseable {
    boolean next() throws Exception;
    Set<String> keys();

    String getAsString(String columnName) throws ClassCastException;
    int getAsInteger(String columnName) throws ClassCastException;
    long getAsLong(String columnName) throws ClassCastException;
    float getAsFloat(String columnName) throws ClassCastException;
    double getAsDouble(String columnName) throws ClassCastException;
    boolean getAsBoolean(String columnName) throws ClassCastException;

    Instant getAsInstant(String columnName) throws ClassCastException;
    LocalDate getAsDate(String columnName) throws ClassCastException;
    LocalDateTime getAsDateTime(String columnName) throws ClassCastException;
    ZonedDateTime getAsDateTimeZoned(String columnName) throws ClassCastException;
    LocalTime getAsTime(String columnName) throws ClassCastException;

    boolean isNull(String columnName) throws ClassCastException;
    byte[] getAsBinary(String columnName) throws ClassCastException;
    JsonArray getAsArray(String columnName) throws ClassCastException;
    JsonObject getAsObject(String columnName) throws ClassCastException;

    JsonObject toJson();
}