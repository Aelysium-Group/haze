package group.aelysium.query;

import group.aelysium.Database;
import group.aelysium.lib.Filterable;
import group.aelysium.lib.DataRequest;

public abstract class ReadRequest extends DataRequest {
    protected Filterable filters = new Filterable();

    public ReadRequest(Database database) {
        super(database);
    }

    public Filterable filters() {
        return this.filters;
    }
}
