package co.edu.umanizales.myfirstapi.model;

/**
 * Clase que representa una fila del archivo CSV de municipios.
 * Contiene la información de cada municipio y departamento.
 */
public class Municipio {
    private String codigoDepartamento;     // Código del departamento
    private String nombreDepartamento;     // Nombre del departamento
    private String codigoMunicipio;        // Código del municipio
    private String nombreMunicipio;        // Nombre del municipio
    private String tipo;                   // Tipo: Municipio, Isla...
    private String longitud;               // Coordenada geográfica
    private String latitud;                // Coordenada geográfica

    // Constructor que recibe todos los valores de la fila CSV
    public Municipio(String codigoDepartamento, String nombreDepartamento,
                     String codigoMunicipio, String nombreMunicipio,
                     String tipo, String longitud, String latitud) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.codigoMunicipio = codigoMunicipio;
        this.nombreMunicipio = nombreMunicipio;
        this.tipo = tipo;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    // Getters para exponer los datos al serializar en JSON
    public String getCodigoDepartamento() { return codigoDepartamento; }
    public String getNombreDepartamento() { return nombreDepartamento; }
    public String getCodigoMunicipio() { return codigoMunicipio; }
    public String getNombreMunicipio() { return nombreMunicipio; }
    public String getTipo() { return tipo; }
    public String getLongitud() { return longitud; }
    public String getLatitud() { return latitud; }
}
