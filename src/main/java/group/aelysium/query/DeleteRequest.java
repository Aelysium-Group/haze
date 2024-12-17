package group.aelysium.query;

import group.aelysium.Database;
import group.aelysium.lib.Filterable;
import group.aelysium.lib.DataRequest;

public abstract class DeleteRequest extends DataRequest {
    protected Filterable filters = new Filterable();

    public DeleteRequest(Database database) {
        super(database);
    }

    public Filterable filters() {
        return this.filters;
    }
}
