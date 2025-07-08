package be.seeseemelk.mockbukkit.plugin;

import org.bukkit.event.Event;
import org.bukkit.event.EventException;

import java.lang.reflect.InvocationTargetException;

public interface AbstractListenerEntry {
    void invoke(Event event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, EventException;

    void invokeUnsafe(Event event);

    boolean isCompatibleFor(Event event);
}
