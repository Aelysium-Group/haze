package group.aelysium.query;

import group.aelysium.Database;
import group.aelysium.lib.DataRequest;

import java.util.function.Consumer;

public abstract class ProcedureRequest extends DataRequest {
    protected final String target;
    public ProcedureRequest(
            Database database,
            String target
    ) {
        super(database);
        this.target = target;
    }

    public void ifNotTabular(Consumer<Database> handle) {
        handle.accept(this.database);
    }
}
