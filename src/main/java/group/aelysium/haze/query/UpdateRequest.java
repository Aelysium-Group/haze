package group.aelysium.haze.query;

import group.aelysium.haze.Database;
import group.aelysium.haze.exceptions.HazeCastingException;
import group.aelysium.haze.exceptions.HazeException;
import group.aelysium.haze.lib.Filterable;
import group.aelysium.haze.lib.DataRequest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public abstract class UpdateRequest extends DataRequest {
    protected final Map<String, Object> parameters = new HashMap<>();
    protected Filterable filters = new Filterable();

    public UpdateRequest(
            @NotNull Database database,
            @NotNull String target
    ) {
        super(database, target);
    }
    public void parameter(@NotNull String key, @Nullable Object value) {
        this.parameters.put(key, value);
    }

    public Filterable filters() {
        return this.filters;
    }

    /**
     * Inserts the provided {@link #parameters} into the table for any and all entries that match {@link #filters}.
     * @return The number of updated entries.
     * @throws HazeException If there was an issue interacting with the database.
     * @throws HazeCastingException If there was an issue converting the response into the type <T>.
     * @throws Exception For any other issues encountered.
     */
    public abstract long execute() throws Exception;
}