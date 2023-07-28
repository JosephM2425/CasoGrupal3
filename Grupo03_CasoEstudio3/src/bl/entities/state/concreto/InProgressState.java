package bl.entities.state.concreto;

import bl.entities.composite.components.Proforma;
import bl.entities.state.abstracto.State;

public class InProgressState extends State {
    @Override
    public  String obtenerEstado() {
        return "En Progreso";
    }
}
