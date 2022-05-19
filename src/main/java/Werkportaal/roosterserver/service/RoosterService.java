package Werkportaal.roosterserver.service;


import Werkportaal.roosterserver.model.Rooster;
import Werkportaal.roosterserver.repository.RoosterRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoosterService {

    @Autowired
    private final RoosterRepository roosterRepository;

    private final AmqpTemplate amqpTemplate;

    @Value("${spring.rabbitmq.template.exchange}")
    private String exchangeName;

    public RoosterService(RoosterRepository roosterRepository, AmqpTemplate amqpTemplate) {
        this.roosterRepository = roosterRepository;
        this.amqpTemplate = amqpTemplate;
    }

    public List<Rooster> findAll() {
        return roosterRepository.findAll();
    }

    public void testRabitMQ(String text){
        amqpTemplate.convertAndSend(exchangeName, "rooster.test", text);
    }

}
