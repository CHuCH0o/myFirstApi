package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.MyFirstApiApplication;
import co.edu.umanizales.myfirstapi.model.Town;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio para gestionar la información de municipios (towns)
 */
@Service
public class TownService {

    private final List<Town> towns = new ArrayList<>();

    /**
     * Carga el archivo CSV al iniciar la aplicación
     */
    @PostConstruct
    public void loadCsv() {
        String path = Paths.get(System.getProperty("user.dir"),
                "src", "main", "java", "co", "edu", "umanizales", "myfirstapi",
                "DIVIPOLA-_C_digos_municipios_20250326.csv").toString();

        try (BufferedReader reader = new BufferedReader(new FileReader(path, StandardCharsets.UTF_8))) {
            reader.readLine(); // Saltar encabezado
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (parts.length >= 7) {
                    towns.add(new Town(
                            parts[0].trim(),
                            parts[1].trim(),
                            parts[2].trim(),
                            parts[3].trim(),
                            parts[4].trim(),
                            parts[5].trim(),
                            parts[6].trim()
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Buscar municipios por nombre (ignora tildes)
     */
    public List<Town> findByTownName(String name) {
        String normalizedInput = MyFirstApiApplication.normalizeText(name);
        return towns.stream()
                .filter(t -> MyFirstApiApplication.normalizeText(t.getTownName()).contains(normalizedInput))
                .toList();
    }

    /**
     * Buscar municipios por código exacto
     */
    public List<Town> findByTownCode(String code) {
        return towns.stream()
                .filter(t -> t.getTownCode().equals(code))
                .toList();
    }

    /**
     * Buscar municipios que pertenezcan a un state (por código)
     */
    public List<Town> findByStateCode(String code) {
        return towns.stream()
                .filter(t -> t.getStateCode().equals(code))
                .toList();
    }

    /**
     * Retorna todos los municipios cargados
     */
    public List<Town> getAllTowns() {
        return towns;
    }
}
