package vendedores.observador.publisher;

import vendedores.observador.listener.IListener;

import java.util.*;

public class EventManager {
    Map<String, List<IListener>> listeners = new HashMap<>();

    public EventManager(String... operations){
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

}
