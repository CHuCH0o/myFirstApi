package co.edu.umanizales.myfirstapi.model;

/**
 * Clase simple que representa un Departamento (State)
 */
public class State {
    private String stateCode;    // Código del departamento
    private String stateName;    // Nombre del departamento

    public State(String stateCode, String stateName) {
        this.stateCode = stateCode;
        this.stateName = stateName;
    }

    public String getStateCode() { return stateCode; }
    public String getStateName() { return stateName; }
}
