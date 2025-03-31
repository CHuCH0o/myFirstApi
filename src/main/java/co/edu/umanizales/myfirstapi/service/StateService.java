package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.model.StateWithTownDTO;
import co.edu.umanizales.myfirstapi.model.Town;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para la gestión de departamentos y su municipio principal.
 */
@Service
public class StateService {

    private final TownService townService;

    public StateService(TownService townService) {
        this.townService = townService;
    }

    /**
     * Obtiene todos los departamentos con su municipio principal asociado
     *
     * Ejemplo de endpoint:
     * GET /davipola/states
     */
    public List<StateWithTownDTO> getStatesWithMainTown() {
        return townService.getAllTowns().stream()
                .collect(java.util.stream.Collectors.toMap(
                        Town::getStateCode,
                        t -> t,
                        (t1, t2) -> t1
                ))
                .values()
                .stream()
                .map(t -> new StateWithTownDTO(
                        t.getStateCode(),
                        t.getStateName(),
                        t.getTownCode(),
                        t.getTownName(),
                        t.getType(),
                        t.getLongitude(),
                        t.getLatitude()
                ))
                .sorted((s1, s2) -> s1.getStateCode().compareTo(s2.getStateCode()))
                .toList();
    }
}
