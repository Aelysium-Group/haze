package group.aelysium.haze.requests;

import group.aelysium.haze.Database;
import group.aelysium.haze.exceptions.HazeCastingException;
import group.aelysium.haze.exceptions.HazeException;
import group.aelysium.haze.lib.Filter;
import group.aelysium.haze.lib.DataRequest;
import group.aelysium.haze.lib.Filterable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class DeleteRequest extends DataRequest implements Filterable<DeleteRequest> {
    protected Filter filter = null;

    public DeleteRequest(
            @NotNull Database database,
            @NotNull String target
    ) {
        super(database, target);
    }
    
    @Override
    public DeleteRequest withFilter(@NotNull Filter filter) {
        this.filter = filter;
        return this;
    }

    /**
     * Deletes any entries that satisfy the provided filters.
     * @throws HazeException If there was an issue interacting with the database.
     * @throws HazeCastingException If there was an issue converting the response into the type <T>.
     * @throws Exception For any other issues encountered.
     */
    public abstract void execute() throws Exception;
}
