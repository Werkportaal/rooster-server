package Werkportaal.roosterserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com"})
public class RoosterServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoosterServerApplication.class, args);
	}

}
