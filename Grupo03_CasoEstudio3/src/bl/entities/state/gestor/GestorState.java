package bl.entities.state.gestor;

import bl.entities.builder.objects.Cliente;
import bl.entities.builder.objects.Nave;
import bl.entities.builder.objects.Vendedor;
import bl.entities.composite.components.Proforma;
import bl.entities.state.abstracto.State;
import bl.entities.state.concreto.FinishedState;
import bl.entities.state.concreto.InProgressState;
import bl.entities.state.concreto.PendingState;

public class GestorState {

    public Proforma cambiarEstado(Proforma proforma, int pID){
        Proforma newProforma = proforma;
        State state = null;
        switch (pID) {
            case 1:
                state = new PendingState();
                break;
            case 2:
                state = new InProgressState();
                break;
            case 3:
                state = new FinishedState();
                break;
        }
        newProforma.setState(state);
        newProforma.setEstado(state.obtenerEstado());
        return proforma;
    }

    public String getState(Proforma proforma) {
        return proforma.getState();
    }
}
