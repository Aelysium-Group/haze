package group.aelysium.haze.requests;

import group.aelysium.haze.Database;
import group.aelysium.haze.exceptions.HazeCastingException;
import group.aelysium.haze.exceptions.HazeException;
import group.aelysium.haze.lib.DataRequest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public abstract class CreateRequest extends DataRequest {
    protected final Map<String, Object> parameters = new HashMap<>();

    public CreateRequest(
            @NotNull Database database,
            @NotNull String target
    ) {
        super(database, target);
    }

    public void parameter(@NotNull String key, @Nullable Object value) {
        this.parameters.put(key, value);
    }

    /**
     * Inserts the provided {@link #parameters} into the table.
     * @return The ID of the newly created entry.
     * @throws HazeException If there was an issue interacting with the database.
     * @throws HazeCastingException If there was an issue converting the response into the type <T>.
     * @throws Exception For any other issues encountered.
     */
    public abstract long execute() throws Exception;
}