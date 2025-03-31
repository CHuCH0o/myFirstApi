package co.edu.umanizales.myfirstapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.Normalizer;

/**
 * Clase principal de arranque de Spring Boot
 * Además contiene la función utilitaria normalizeText()
 * para eliminar tildes y normalizar texto.
 */
@SpringBootApplication
public class MyFirstApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstApiApplication.class, args);
    }

    /**
     * Método utilitario para normalizar texto
     * - elimina tildes
     * - convierte a minúsculas
     * - deja listo para búsquedas insensibles
     */
    public static String normalizeText(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase();
    }
}
