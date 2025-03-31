package co.edu.umanizales.myfirstapi.model;

/**
 * Modelo que representa un departamento.
 *
 * Ejemplo:
 * State s = new State("05", "Antioquia");
 */
public class State {
    private String stateCode;
    private String stateName;

    public State(String stateCode, String stateName) {
        this.stateCode = stateCode;
        this.stateName = stateName;
    }

    public String getStateCode() { return stateCode; }
    public String getStateName() { return stateName; }
}
