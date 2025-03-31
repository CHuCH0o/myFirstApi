package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.StateWithTownDTO;
import co.edu.umanizales.myfirstapi.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para departamentos
 */
@RestController
@RequestMapping("/davipola")
public class StateController {

    @Autowired
    private StateService stateService;

    /**
     * Obtiene todos los departamentos junto con su municipio principal
     */
    @GetMapping("/states")
    public List<StateWithTownDTO> getStatesWithMainTown() {
        return stateService.getStatesWithMainTown();
    }
}
