package group.aelysium.haze.requests;

import group.aelysium.haze.Database;
import group.aelysium.haze.exceptions.HazeCastingException;
import group.aelysium.haze.exceptions.HazeException;
import group.aelysium.haze.lib.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public abstract class ReadRequest extends DataRequest implements Orderable<ReadRequest>, Limitable<ReadRequest>, Filterable<ReadRequest> {
    protected Filter filter = null;
    protected List<KeyValue<String, Orderable.Ordering>> orderBy = null;
    protected int startAt = -1;
    protected int endAt = -1;

    public ReadRequest(
            @NotNull Database database,
            @NotNull String target
    ) {
        super(database, target);
    }
    
    @Override
    public ReadRequest orderBy(@NotNull String key, @NotNull Orderable.Ordering value) {
        if(this.orderBy == null) this.orderBy = new ArrayList<>();
        
        KeyValue<String, Orderable.Ordering> entry = new KeyValue<>(key, value);
        int i = this.orderBy.indexOf(entry);
        if(i == -1) this.orderBy.add(entry);
        else this.orderBy.set(i, entry);
        return this;
    }
    
    @Override
    public ReadRequest startAt(int index) {
        this.startAt = index;
        return this;
    }
    
    @Override
    public ReadRequest endAt(int index) {
        this.endAt = index;
        return this;
    }
    
    @Override
    public ReadRequest limit(int index) {
        return this.endAt(index);
    }
    
    @Override
    public ReadRequest withFilter(@NotNull Filter filter) {
        this.filter = filter;
        return this;
    }

    /**
     * Fetches all entries that satisfies the provided filters.
     * @param clazz The class to deserialize the returned rows into.
     *              You can implement custom Gson (de)serializer to ensure that the provided class will deserialize.
     * @return A set containing all matching rows, deserialized into the specified type.
     * @throws HazeException If there was an issue interacting with the database.
     * @throws HazeCastingException If there was an issue converting the response into the type <T>.
     * @throws Exception For any other issues encountered.
     * @param <T> The type of object that each entry represents.
     *           The caller can assume that the deserialization should succeed as long as the provided type
     *           contains fields with the same name and type as the corresponding keys in the entry.
     */
    public abstract <T> @NotNull Set<T> execute(Class<T> clazz) throws Exception;

    /**
     * Runs the "filter" function for all entries in the result and aggregates any entries where the caller returned "true" into a set which is returned.
     * @param clazz The class to deserialize the returned rows into.
     *              You can implement custom Gson (de)serializer to ensure that the provided class will deserialize.
     * @param filter A function which takes in the current entry and returns `true` if the entry should be kept, and `false if the entry should be ignored.
     *               The caller must make sure they do not attempt to interact with the function's parameter outside the function.
     *               The parameter is a mutable instance that's reused, attempting to access it outside the function will result in undefined behaviour.
     * @return A set containing all entries where the filter returned "true"
     * @throws HazeException If there was an issue interacting with the database.
     * @throws HazeCastingException If there was an issue converting the response into the type <T>.
     * @throws Exception For any other issues encountered.
     * @param <T> The type of object that each entry represents.
     *           The caller can assume that the deserialization should succeed as long as the provided type
     *           contains fields with the same name and type as the corresponding keys in the entry.
     */
    public abstract <T> @NotNull Set<T> executeAndFilter(
            @NotNull Class<T> clazz,
            @NotNull Function<@NotNull T, @NotNull Boolean> filter
    ) throws Exception;
}
