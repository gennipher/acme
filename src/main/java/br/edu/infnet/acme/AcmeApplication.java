package br.edu.infnet.acme;

import br.edu.infnet.acme.service.AmazonService;
import com.amazonaws.services.s3.model.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AcmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcmeApplication.class, args);
	}
}
