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
@RequestMapping("/davipola")
public class TownController {

    @Autowired
    private TownService townService;

    /**
     * GET /davipola/name/{name}
     * Buscar municipio por nombre
     */
    @GetMapping("/name/{name}")
    public List<Town> getByTownName(@PathVariable String name) {
        return townService.findByTownName(name);
    }

    /**
     * GET /davipola/code/{code}
     * Buscar municipio por código
     */
    @GetMapping("/code/{code}")
    public List<Town> getByTownCode(@PathVariable String code) {
        return townService.findByTownCode(code);
    }

    /**
     * GET /davipola/state/{stateCode}
     * Listar municipios por código de departamento
     */
    @GetMapping("/state/code/{stateCode}")
    public List<Town> getByStateCode(@PathVariable String stateCode) {
        return townService.findByStateCode(stateCode);
    }

    /**
     * GET /davipola/town/state/name/{name}
     * Buscar municipios por nombre de departamento
     */
    @GetMapping("/state/name/{name}")
    public List<Town> getByStateName(@PathVariable String name) {
        return townService.findByStateName(name);
    }


    @GetMapping("/towns")
    public List<Town> getAllTowns() {
        return townService.getAllTowns();
    }
}
