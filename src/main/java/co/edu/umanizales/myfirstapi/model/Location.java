package co.edu.umanizales.myfirstapi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Location {
    @Getter
    @Setter
    private String code;
    private String description;

    public Location(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
