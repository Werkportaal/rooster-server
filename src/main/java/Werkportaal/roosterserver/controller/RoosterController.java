package Werkportaal.roosterserver.controller;


import Werkportaal.roosterserver.model.Rooster;
import Werkportaal.roosterserver.service.RoosterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rooster", method = { RequestMethod.GET, RequestMethod.POST })
public class RoosterController {

    RoosterService roosterService;

    public RoosterController(RoosterService roosterService){
        this.roosterService = roosterService;
    }

    @GetMapping
    public List<Rooster> findAll() {
        return roosterService.findAll();
    }

    @PostMapping("/test")
    public void test(@RequestBody String text){
        System.out.println(text);
        roosterService.testRabitMQ(text);
    }

}
