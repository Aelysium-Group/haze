package group.aelysium.haze;

import group.aelysium.haze.exceptions.HazeException;
import group.aelysium.haze.lib.DataHolder;
import group.aelysium.haze.query.*;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a database connection.
 * This class has no connect method because the connection is done in the constructor.
 */
public abstract class Database implements AutoCloseable {
    protected final Type type;
    protected final String name;

    public Database(
        @NotNull String name,
        @NotNull Type type
    ) {
        this.type = type;
        this.name = name;
    }

    /**
     * @return The name of the database.
     */
    public String name() {
        return this.name;
    }

    /**
     * @return The type of database.
     */
    public Type type() {
        return this.type;
    }

    /**
     * @param target The target table or collection that this request is for.
     *               To prevent over complicating the API, Haze only allows you to target a single table or collection per request.
     * @return A new request which will create a database entry when executed.
     */
    public abstract CreateRequest newCreateRequest(@NotNull String target);

    /**
     * @param target The target table or collection that this request is for.
     *               To prevent over complicating the API, Haze only allows you to target a single table or collection per request.
     * @return A new request which will read database entries when executed.
     */
    public abstract ReadRequest newReadRequest(@NotNull String target);

    /**
     * @param target The target table or collection that this request is for.
     *               To prevent over complicating the API, Haze only allows you to target a single table or collection per request.
     * @return A new request which will update database entries when executed.
     */
    public abstract UpdateRequest newUpdateRequest(@NotNull String target);

    /**
     * @param target The target table or collection that this request is for.
     *               To prevent over complicating the API, Haze only allows you to target a single table or collection per request.
     * @return A new request which will delete database entries when executed.
     */
    public abstract DeleteRequest newDeleteRequest(@NotNull String target);

    /**
     * Creates a data holder based on the provided object.
     * In tabular databases a data holder will become a table.
     * In document databases a data holder will become a collection or some table equivalent.
     * @param holder The holder to create
     */
    public abstract void createDataHolder(@NotNull DataHolder holder) throws Exception;

    /**
     * Checks if the specific data holder exists.
     * @param name The name of the holder to check for.
     */
    public abstract boolean doesDataHolderExist(@NotNull String name) throws Exception;

    /**
     * Deletes a data holder based on the provided name.
     * In tabular databases this would equate to dropping a table.
     * In document databases this would equate to dropping a collection.
     * @param name The name of the data holder to delete.
     */
    public abstract void deleteDataHolder(@NotNull String name) throws Exception;

    public enum Type {
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