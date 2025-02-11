package group.aelysium.haze.lib;

import group.aelysium.haze.Database;
import group.aelysium.haze.exceptions.HazeException;
import group.aelysium.haze.exceptions.HazeCastingException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public abstract class DataRequest implements AutoCloseable {
    protected final Database database;
    protected final String target;
    public DataRequest(@NotNull Database database, @NotNull String target) {
        this.database = database;
        this.target = target;
    }

    @Override
    public void close() throws Exception {
        this.database.close();
    }
}