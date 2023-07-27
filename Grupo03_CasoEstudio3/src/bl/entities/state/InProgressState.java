package bl.entities.state;

import bl.entities.composite.components.Proforma;

public class InProgressState extends State{

    public InProgressState(Proforma proforma) {
        super(proforma);
    }

    @Override
    public String pending() {
        return "En Progreso";
    }

    @Override
    public String inProgress() {
        return "En Progreso";
    }

    @Override
    public String finished() {
        proforma.changeState(new FinishedState(proforma), "Finalizado");
        return "Finalizado";
    }
}
