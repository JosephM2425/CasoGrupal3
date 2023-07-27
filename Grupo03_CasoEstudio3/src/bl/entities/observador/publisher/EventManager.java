package bl.entities.observador.publisher;


import bl.entities.observador.listener.IListener;

import java.util.ArrayList;

public class EventManager implements IPublisher{

    ArrayList<IListener> listOfListeners = new ArrayList<>();
    @Override
    public void subscribe(IListener listener) {
        this.listOfListeners.add(listener);
    }

    @Override
    public void unSubscribe(IListener listener) {
        this.listOfListeners.remove(listener);
    }

    @Override
    public void notifyListener() {
        for (IListener tempListener : listOfListeners) {
            tempListener.update();
        }
    }
}
