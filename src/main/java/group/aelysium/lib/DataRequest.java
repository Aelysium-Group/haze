package group.aelysium.lib;

import group.aelysium.Database;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public abstract class DataRequest implements AutoCloseable {
    protected final Database database;
    protected final Map<String, Object> parameters = new HashMap<>();
    public DataRequest(Database database) {
        this.database = database;
    }

    public void parameter(String key, Object value) {
        this.parameters.put(key, value);
    }

    /**
     * <h1></h1>
     * Executes the DataQuery and accepts a response.
     * <h2>As The Caller</h2>
     * It is your responsibility to handle instances where the database in question may be a tabbular based database (i.e. MySQL) or a document based database (i.e. MongoDB).
     * You are expected to provide a consumer to properly handle the expected output from both types of databases.
     * <h2>As The Provider</h2>
     * Depending on which type of database you are implementing, you can return data to one of the two provided consumers.
     * You must ensure that you only ever call one of the two consumers and never both!
     * @param tabular A consumer to handle data in tabular formats.
     * @param document A consumer to handle data in document formats.
     * @throws Exception For any errors encountered during the execution or handling process. Errors thrown from within the consumers will be passed to the caller.
     */
    public abstract void execute(Consumer<TabularQueryResult> tabular, Consumer<DocumentQueryResult> document) throws Exception;

    @Override
    public void close() throws Exception {
        this.database.close();
    }
}