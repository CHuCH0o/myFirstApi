package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Town;
import co.edu.umanizales.myfirstapi.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operaciones sobre municipios (towns)
 */
@RestController
@RequestMapping("/davipola/town")
public class TownController {

    @Autowired
    private TownService townService;

    /**
     * Buscar por nombre de municipio
     * GET /davipola/town/name/{name}
     */
    @GetMapping("/name/{name}")
    public List<Town> getByTownName(@PathVariable String name) {
        return townService.findByTownName(name);
    }

    /**
     * Buscar por código de municipio
     * GET /davipola/town/code/{code}
     */
    @GetMapping("/code/{code}")
    public List<Town> getByTownCode(@PathVariable String code) {
        return townService.findByTownCode(code);
    }

    /**
     * Listar municipios de un departamento por código de departamento
     * GET /davipola/town/state/{stateCode}
     */
    @GetMapping("/state/{stateCode}")
    public List<Town> getByStateCode(@PathVariable String stateCode) {
        return townService.findByStateCode(stateCode);
    }
}
