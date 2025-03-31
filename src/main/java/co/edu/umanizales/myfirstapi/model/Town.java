package co.edu.umanizales.myfirstapi.model;

/**
 * Modelo que representa un municipio de Colombia.
 *
 * Ejemplo de uso:
 * Town t = new Town("05", "Antioquia", "05001", "Medellín", "Municipio", "-75.58", "6.24");
 */
public class Town {
    private String stateCode;
    private String stateName;
    private String townCode;
    private String townName;
    private String type;
    private String longitude;
    private String latitude;

    public Town(String stateCode, String stateName, String townCode, String townName,
                String type, String longitude, String latitude) {
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.townCode = townCode;
        this.townName = townName;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getStateCode() { return stateCode; }
    public String getStateName() { return stateName; }
    public String getTownCode() { return townCode; }
    public String getTownName() { return townName; }
    public String getType() { return type; }
    public String getLongitude() { return longitude; }
    public String getLatitude() { return latitude; }
}
