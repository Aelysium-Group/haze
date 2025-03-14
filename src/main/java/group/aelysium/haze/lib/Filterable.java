package group.aelysium.haze.lib;

import org.jetbrains.annotations.NotNull;

public interface Filterable<T extends DataRequest> {
    T withFilter(@NotNull Filter filter);
}