package co.edu.umanizales.myfirstapi.service;
import co.edu.umanizales.myfirstapi.model.State;
import co.edu.umanizales.myfirstapi.model.Town;
import org.springframework.stereotype.Service;
import java.text.Normalizer;
import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase se encarga de leer el archivo CSV al iniciar la aplicación
 * y de ofrecer métodos para buscar towns por nombre o código.
 */
@Service
public class TownService {

    private final List<Town> towns = new ArrayList<>();

    /* Este metodo se ejecuta automáticamente cuando se inicia la aplicación
     * lee linea a linea el archivo CSV y almacena los datos en la lista Town
     */


    // Función para normalizar texto (eliminar tildes y pasar a minúsculas)
    private String normalizeText(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase();
    }

    // --- Métodos de búsqueda usando normalizeText ---

    public List<Town> findByTownName(String name) {
        String normalizedInput = normalizeText(name);
        return towns.stream()
                .filter(t -> normalizeText(t.getTownName()).contains(normalizedInput))
                .toList();
    }

    public List<Town> findByStateName(String name) {
        String normalizedInput = normalizeText(name);
        return towns.stream()
                .filter(t -> normalizeText(t.getStateName()).contains(normalizedInput))
                .toList();
    }

    @PostConstruct
    public void loadCsv() {
        // Ruta del archivo CSV en la carpeta del paquete myfirstapi
        String path = Paths.get(System.getProperty("user.dir"),
                "src", "main", "java", "co", "edu", "umanizales", "myfirstapi",
                "DIVIPOLA-_C_digos_municipios_20250326.csv"
        ).toString();

        try (BufferedReader reader = new BufferedReader(new FileReader(path, StandardCharsets.UTF_8))) {
            reader.readLine(); // Saltar el encabezado
            String line;

            while ((line = reader.readLine()) != null) {
                // Separación por comas con soporte para comillas
                String[] parts = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (parts.length >= 7) {
                    towns.add(new Town(
                            parts[0].trim(), // Código estado
                            parts[1].trim(), // Nombre estado
                            parts[2].trim(), // Código municipio
                            parts[3].trim(), // Nombre municipio
                            parts[4].trim(), // Tipo
                            parts[5].trim(), // Longitud
                            parts[6].trim()  // Latitud
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    Métodos para consultar por diferentes criterios
     */


    //Metodo para consultar municipio por codigo
    public List<Town> findByTownCode(String code) {
        return towns.stream()
                .filter(t -> t.getTownCode().equals(code))
                .toList();
    }

    //Metodo para consultar departamento por codigo
    public List<Town> findByStateCode(String code) {
        return towns.stream()
                .filter(t -> t.getStateCode().equals(code))
                .toList();
    }

    // Listar todos los departamentos (states) con su información

    public List<State> getAllStates() {
        return towns.stream()
                .collect(java.util.stream.Collectors.toMap(
                        Town::getStateCode,
                        Town::getStateName,
                        (name1, name2) -> name1 // en caso de duplicados
                ))
                .entrySet()
                .stream()
                .map(e -> new State(e.getKey(), e.getValue()))
                .sorted((s1, s2) -> s1.getStateCode().compareTo(s2.getStateCode()))
                .toList();
    }

}
