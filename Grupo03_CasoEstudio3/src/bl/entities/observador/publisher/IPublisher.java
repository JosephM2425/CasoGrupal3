package bl.entities.observador.publisher;

import bl.entities.observador.listener.IListener;

public interface IPublisher {
    void subscribe(IListener listener);
    void unSubscribe(IListener listener);
    void notifyListener();

}
