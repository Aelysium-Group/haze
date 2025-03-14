package group.aelysium.haze.requests;

import group.aelysium.haze.Database;
import group.aelysium.haze.exceptions.HazeCastingException;
import group.aelysium.haze.exceptions.HazeException;
import group.aelysium.haze.lib.DataRequest;
import group.aelysium.haze.lib.Filter;
import group.aelysium.haze.lib.Filterable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public abstract class UpsertRequest extends DataRequest implements Filterable<UpsertRequest> {
    protected final Map<String, Object> parameters = new HashMap<>();
    protected Filter filter = null;

    public UpsertRequest(
            @NotNull Database database,
            @NotNull String target
    ) {
        super(database, target);
    }
    public UpsertRequest parameter(@NotNull String key, @Nullable Object value) {
        this.parameters.put(key, value);
        return this;
    }
    
    @Override
    public UpsertRequest withFilter(@NotNull Filter filter) {
        this.filter = filter;
        return this;
    }

    /**
     * Inserts the provided {@link #parameters} into the data holder for any and all entries that match the provided filters.
     * @return The number of updated entries.
     * @throws HazeException If there was an issue interacting with the database.
     * @throws HazeCastingException If there was an issue converting the response into the type <T>.
     * @throws Exception For any other issues encountered.
     */
    public abstract long execute() throws Exception;
}