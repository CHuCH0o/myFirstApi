package co.edu.umanizales.myfirstapi.model;

/**
 * Clase que representa un municipio
 * Contiene información geográfica y administrativa
 */
public class Town {
    private String stateCode;    // Código del departamento
    private String stateName;    // Nombre del departamento
    private String townCode;     // Código del municipio
    private String townName;     // Nombre del municipio
    private String type;         // Tipo: Municipio, Isla, etc.
    private String longitude;    // Longitud geográfica
    private String latitude;     // Latitud geográfica

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
