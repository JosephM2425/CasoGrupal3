package bl.entities.state;

import bl.entities.composite.components.Proforma;

public class PendingState extends State{

    public PendingState(Proforma proforma) {
        super(proforma);
    }

    @Override
    public String pending() {
        return "Pendiente";
    }

    @Override
    public String inProgress() {
        proforma.changeState(new InProgressState(proforma), "En Progreso");
        return "En Progreso";
    }

    @Override
    public String finished() {
        proforma.changeState(new FinishedState(proforma), "Finalizado");
        return "Finalizado";
    }
}
