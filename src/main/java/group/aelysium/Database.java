package group.aelysium;

import group.aelysium.lib.DataHolder;
import group.aelysium.query.*;

import java.util.function.Consumer;

/**
 * Represents a database connection.
 * This class has no connect method because the connection is done in the constructor.
 */
public interface Database extends AutoCloseable {
    /**
     * @return The type of database.
     */
    Type type();

    /**
     * @param target The target table or collection that this request is for.
     *               To prevent over complicating the API, Haze only allows you to target a single table or collection per request.
     * @return A new request which will create a database entry when executed.
     */
    CreateRequest newCreateRequest(String target);

    /**
     * @param target The target table or collection that this request is for.
     *               To prevent over complicating the API, Haze only allows you to target a single table or collection per request.
     * @return A new request which will read database entries when executed.
     */
    ReadRequest newReadRequest(String target);

    /**
     * @param target The target table or collection that this request is for.
     *               To prevent over complicating the API, Haze only allows you to target a single table or collection per request.
     * @return A new request which will update database entries when executed.
     */
    UpdateRequest newUpdateRequest(String target);

    /**
     * @param target The target table or collection that this request is for.
     *               To prevent over complicating the API, Haze only allows you to target a single table or collection per request.
     * @return A new request which will delete database entries when executed.
     */
    DeleteRequest newDeleteRequest(String target);

    /**
     * @param target The target table or collection that this request is for.
     *               To prevent over complicating the API, Haze only allows you to target a single table or collection per request.
     * @return A new request which will replace database entries when executed.
     */
    ReplaceRequest newReplaceRequest(String target);

    /**
     * @param target The target procedure that this request is for.
     * @param ifProceduresNotSupported The consumer to run if the backing database doesn't support procedures.
     *                                 You can choose to throw an exception, or use other Haze requests to handle the request instead.
     * @return A new request which execute a procedure when executed.
     */
    ProcedureRequest newProcedureRequest(String target, Consumer<Database> ifProceduresNotSupported);

    /**
     * Creates a data holder based on the provided object.
     * In tabular databases a data holder will become a table.
     * In document databases a data holder will become a collection or some table equivalent.
     * @param holder The holder to create
     */
    void createDataHolder(DataHolder holder);

    /**
     * Deletes a data holder based on the provided name.
     * In tabular databases this would equate to dropping a table.
     * In document databases this would equate to dropping a collection.
     * @param name The name of the data holder to delete.
     */
    void deleteDataHolder(String name);

    enum Type {
        /**
         * Represents a tabular database such as SQL.
         */
        TABULAR,

        /**
         * Represents a document database such as MongoDB.
         */
        DOCUMENT
    }
}