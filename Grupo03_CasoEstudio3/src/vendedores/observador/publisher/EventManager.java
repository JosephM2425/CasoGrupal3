package vendedores.observador.publisher;


import vendedores.observador.listener.IListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    Map<String, List<IListener>> listeners = new HashMap<>();

    public EventManager(String... operations){
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }
    public void subscribe(String eventType, IListener listener) {
        List<IListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, IListener listener) {
        List<IListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType) {
        List<IListener> users = listeners.get(eventType);
        for (IListener listener : users) {
            listener.update(eventType);
        }
    }

}
