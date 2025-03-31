package co.edu.umanizales.myfirstapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.Normalizer;

/**
 * Clase principal para iniciar la API REST con Spring Boot.
 * También contiene una función utilitaria para normalizar textos,
 * eliminando tildes y volviendo todo a minúsculas.
 */
@SpringBootApplication
public class MyFirstApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFirstApiApplication.class, args);
    }

    /**
     * Normaliza un texto eliminando tildes y convirtiendo a minúsculas
     * @param text texto original
     * @return texto normalizado
     */
    public static String normalizeText(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase();
    }
}
