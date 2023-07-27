package bl.entities.observador.listener;

import bl.entities.observador.publisher.EventManager;

public class InProgressListener implements IListener{
    private EventManager observar;

    public InProgressListener(EventManager observar) {
        this.observar = observar;
    }

    @Override
    public void update() {

    }
}
