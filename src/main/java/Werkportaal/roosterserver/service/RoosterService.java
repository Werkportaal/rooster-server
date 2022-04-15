package Werkportaal.roosterserver.service;


import Werkportaal.roosterserver.model.Rooster;
import Werkportaal.roosterserver.repository.RoosterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoosterService {

    private final RoosterRepository roosterRepository;

    public RoosterService(RoosterRepository roosterRepository) {
        this.roosterRepository = roosterRepository;
    }

    public List<Rooster> findAll() {
        return roosterRepository.findAll();
    }

}
