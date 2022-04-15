package Werkportaal.roosterserver.controller;


import Werkportaal.roosterserver.model.Rooster;
import Werkportaal.roosterserver.service.RoosterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooster")
public class RoosterController {

    RoosterService roosterService;

    public RoosterController(RoosterService roosterService){
        this.roosterService = roosterService;
    }

    @GetMapping
    public List<Rooster> findAll() {
        return roosterService.findAll();
    }
}
