package group.aelysium.haze.query;

import group.aelysium.haze.Database;
import group.aelysium.haze.exceptions.HazeCastingException;
import group.aelysium.haze.exceptions.HazeException;
import group.aelysium.haze.lib.Filterable;
import group.aelysium.haze.lib.DataRequest;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public abstract class ReadRequest extends DataRequest {
    protected Filterable filters = new Filterable();

    public ReadRequest(
            @NotNull Database database,
            @NotNull String target
    ) {
        super(database, target);
    }

    public Filterable filters() {
        return this.filters;
    }

    /**
     * Fetches all entries that satisfies {@link #filters}.
     * @return A set containing all matching rows.
     * @throws HazeException If there was an issue interacting with the database.
     * @throws HazeCastingException If there was an issue converting the response into the type <T>.
     * @throws Exception For any other issues encountered.
     * @param <T> The type of object that each entry represents.
     *           Assuming the provided type contains fields with the correct name and type
     *           as the corresponding keys or columns in the entry;
     *           the caller can assume that the deserialization should succeed.
     */
    public abstract <T> @NotNull Set<T> execute(Class<T> clazz) throws Exception;
}
