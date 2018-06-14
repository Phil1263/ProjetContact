package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContactApplication {
	
	   public static void main(String[] args) {
	        SpringApplication.run(ContactApplication.class, args);
	    }
	   
	   @Bean
		public CommandLineRunner demo(ContactRepository repository) {
			return (args) -> {
				// save a couple of contact(insert into)
				repository.save(new Contact("Philippe", "R", "0678912345", "philippe@rallier.fr"));
			};
		}
}
