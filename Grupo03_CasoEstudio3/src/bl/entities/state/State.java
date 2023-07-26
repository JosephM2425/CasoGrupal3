package bl.entities.state;

import bl.entities.composite.components.Proforma;

public abstract class State {
    Proforma proforma;
    State(Proforma proforma) {this.proforma = proforma;}

    public abstract String pending();
    public abstract String inProgress();
    public abstract String finished();
}
