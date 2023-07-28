package bl.entities.state.concreto;

import bl.entities.composite.components.Proforma;
import bl.entities.state.abstracto.State;

public class PendingState extends State {
    @Override
    public String obtenerEstado() {
        return "Pendiente";
    }
}
