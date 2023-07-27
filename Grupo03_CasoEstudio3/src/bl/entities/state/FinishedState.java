package bl.entities.state;

import bl.entities.composite.components.Proforma;

public class FinishedState extends State{

    public FinishedState(Proforma proforma) {
        super(proforma);
    }

    @Override
    public String pending() {
        proforma.changeState(new InProgressState(proforma), "En Progreso");
        return "En Progreso";
    }

    @Override
    public String inProgress() {
        proforma.changeState(new InProgressState(proforma), "En Progreso");
        return "En Progreso";
    }

    @Override
    public String finished() {
        return "Finalizado";
    }
}
