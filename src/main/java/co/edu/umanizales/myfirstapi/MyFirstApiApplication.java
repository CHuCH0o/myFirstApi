package co.edu.umanizales.myfirstapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.text.Normalizer;


@SpringBootApplication
public class MyFirstApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(MyFirstApiApplication.class, args);
    }

    /**
     * Método utilitario para normalizar textos eliminando tildes y convirtiendo a minúsculas.
     */
    public static String normalizeText(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase();
    }
}