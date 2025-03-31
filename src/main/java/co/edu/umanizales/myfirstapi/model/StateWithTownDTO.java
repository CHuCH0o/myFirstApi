package co.edu.umanizales.myfirstapi.model;

/**
 * DTO para listar un departamento junto con su municipio principal.
 *
 * Ejemplo de respuesta:
 * {
 *   "stateCode": "05",
 *   "stateName": "Antioquia",
 *   "townCode": "05001",
 *   "townName": "Medellín",
 *   "type": "Municipio",
 *   "longitude": "-75.58",
 *   "latitude": "6.24"
 * }
 */
public class StateWithTownDTO {

    private String stateCode;
    private String stateName;
    private String townCode;
    private String townName;
    private String type;
    private String longitude;
    private String latitude;

    public StateWithTownDTO(String stateCode, String stateName, String townCode, String townName,
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
