package rafamattia.liwproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import rafamattia.liwproject.models.Client;
import rafamattia.liwproject.repository.ClientRepo;

import java.util.List;

@RestController
public class ClientController {
    private ClientRepo clients = new ClientRepo();
    @GetMapping(path = "/api/lista")
    public Client getList(){
        return clients.findByName("Rafael");
    }

}
