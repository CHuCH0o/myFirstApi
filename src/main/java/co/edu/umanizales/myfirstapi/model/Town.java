package co.edu.umanizales.myfirstapi.model;

/**
 * Representa un municipio (town) con toda su información,
 * incluyendo su estado (departamento), tipo, longitud y latitud.
 */
public class Town {
    private String stateCode;
    private String stateName;
    private String townCode;
    private String townName;
    private String type;
    private String longitude;
    private String latitude;

    /**
     * Constructor que inicializa todos los campos de la clase Town como objetos
     * (son las variables creadas para almacenar la informacion de los campos del archivo CSV).
     */
    public Town(String stateCode, String stateName,
                String townCode, String townName,
                String type, String longitude, String latitude) {
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.townCode = townCode;
        this.townName = townName;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    // Getters (permite la lectura por parte de la clase controller para los EndPoints)

    public String getStateCode() { return stateCode; }
    public String getStateName() { return stateName; }
    public String getTownCode() { return townCode; }
    public String getTownName() { return townName; }
    public String getType() { return type; }
    public String getLongitude() { return longitude; }
    public String getLatitude() { return latitude; }
}
