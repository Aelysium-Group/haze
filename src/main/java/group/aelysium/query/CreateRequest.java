package group.aelysium.query;

import group.aelysium.Database;
import group.aelysium.lib.DataRequest;

public abstract class CreateRequest extends DataRequest {
    public CreateRequest(Database database) {
        super(database);
    }
}