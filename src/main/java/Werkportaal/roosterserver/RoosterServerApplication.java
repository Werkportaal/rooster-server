package Werkportaal.roosterserver;

import Werkportaal.roosterserver.repository.RoosterRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

@SpringBootApplication
@ComponentScan({"com"})
@EnableJpaRepositories()
public class RoosterServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoosterServerApplication.class, args);
	}

	// This is so that SimpleMessageConverter only String, byte[] and Serializable payloads supports.
	@Bean
	public Jackson2JsonMessageConverter jsonConverter(ObjectMapper mapper) {
		return new Jackson2JsonMessageConverter(mapper);
	}

	// This is the Amqp template
	@Bean
	public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		ObjectMapper mapper =
				new ObjectMapper()
						.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		rabbitTemplate.setMessageConverter(jsonConverter(mapper));

		return rabbitTemplate;
	}
}
