package co.edu.umanizales.myfirstapi.controller;
import co.edu.umanizales.myfirstapi.model.State;
import co.edu.umanizales.myfirstapi.model.Town;
import co.edu.umanizales.myfirstapi.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Esta clase expone los endpoints para que podamos
 * hacer peticiones HTTP y consultar la información
 * mediante el localhost:8080/davipola
 */
@RestController
@RequestMapping("/davipola")    //GETTER inicial, punto de partida
public class TownController {

    @Autowired
    private TownService townService;

    // GETTERS que nos proporcionan la informacion(JSON) a travez de los ENDPOINTS


    // GET http://localhost:8080/davipola/town/name/(TownName)

    // GET http://localhost:8080/davipola/town/name/manizales

    @GetMapping("/town/name/{name}")
    public List<Town> getByTownName(@PathVariable String name) {
        return townService.findByTownName(name);
    }

    // GET http://localhost:8080/davipola/town/code/(Code)

    // GET http://localhost:8080/davipola/town/code/5002

    @GetMapping("/town/code/{code}")
    public List<Town> getByTownCode(@PathVariable String code) {
        return townService.findByTownCode(code);
    }

    // GET http://localhost:8080/davipola/state/name/(StateName)

    // GET http://localhost:8080/davipola/state/name/antioquia

    @GetMapping("/state/name/{name}")
    public List<Town> getByStateName(@PathVariable String name) {
        return townService.findByStateName(name);
    }

    // GET http://localhost:8080/davipola/state/code/(Code)

    // GET http://localhost:8080/davipola/state/code/5
    @GetMapping("/state/code/{code}")
    public List<Town> getByStateCode(@PathVariable String code) {
        return townService.findByStateCode(code);
    }


    @GetMapping("/states")
    public List<State> getAllStates() {
        return townService.getAllStates();
    }

}


