package group.aelysium.haze.query;

import group.aelysium.haze.Database;
import group.aelysium.haze.exceptions.HazeCastingException;
import group.aelysium.haze.exceptions.HazeException;
import group.aelysium.haze.lib.Filterable;
import group.aelysium.haze.lib.DataRequest;
import org.jetbrains.annotations.NotNull;

public abstract class DeleteRequest extends DataRequest {
    protected Filterable filters = new Filterable();

    public DeleteRequest(
            @NotNull Database database,
            @NotNull String target
    ) {
        super(database, target);
    }

    public Filterable filters() {
        return this.filters;
    }

    /**
     * Deletes any entries that satisfy {@link #filters}.
     * @throws HazeException If there was an issue interacting with the database.
     * @throws HazeCastingException If there was an issue converting the response into the type <T>.
     * @throws Exception For any other issues encountered.
     */
    public abstract void execute() throws Exception;
}
