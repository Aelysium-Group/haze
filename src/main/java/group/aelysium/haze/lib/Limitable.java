package group.aelysium.haze.lib;

public interface Limitable<T extends DataRequest> {
    /**
     * Determines what index to start returning entries from.
     * The index value provided here will be the starting point.
     * If this value is not set, entries will start being returned starting at index 0.
     */
    T startAt(int index);
    
    /**
     * Determines what index to stop returning entries from.
     * The index value provided here will be the final entry returned.
     * If there aren't enough entries to reach this number, then as many entries as possible will be returned.
     * If this value is not set, entries keep being returned until there are no more entries to return.
     */
    T endAt(int index);
    
    /**
     * This method is the same as {@link #endAt(int)}.
     */
    T limit(int index);
}
