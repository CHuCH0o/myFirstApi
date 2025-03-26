package co.edu.umanizales.myfirstapi.controller;

import co.edu.umanizales.myfirstapi.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/seller")
public class SellerController {

    @GetMapping
    public List<Seller> getSellers() {
        List<Seller> sellers = Arrays.asList(
                new Seller(1, "Roberto Carlos"),
                new Seller(2, "María Fernanda"),
                new Seller(3, "Luis Miguel"),
                new Seller(4, "Ana Sofía"),
                new Seller(5, "Carlos Alberto")
        );
        return sellers;
    }
}
