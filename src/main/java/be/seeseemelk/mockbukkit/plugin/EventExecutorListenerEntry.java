package be.seeseemelk.mockbukkit.plugin;

import org.bukkit.event.Event;
import org.bukkit.event.EventException;
import org.bukkit.event.Listener;
import org.bukkit.plugin.EventExecutor;

import java.lang.reflect.InvocationTargetException;

public class EventExecutorListenerEntry  implements AbstractListenerEntry{
    private final Class<? extends Event> eventClass;
    private final EventExecutor executor;
    private final Listener listener;

    public EventExecutorListenerEntry(Class<? extends Event> eventClass, EventExecutor executor, Listener listener) {
        this.eventClass = eventClass;
        this.executor = executor;
        this.listener = listener;
    }

    @Override
    public void invoke(Event event) throws EventException {
        executor.execute(listener, event);
    }

    @Override
    public void invokeUnsafe(Event event) {
        try {
            executor.execute(listener, event);
        } catch (EventException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isCompatibleFor(Event event) {
        return eventClass.isInstance(event);
    }
}
