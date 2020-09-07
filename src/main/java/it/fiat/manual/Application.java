package it.fiat.manual;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.fiat.manual.jse.jpa.FiatDocMake;
import it.fiat.manual.jse.jpa.service.FiatMakeRepo;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);



	@Autowired
	private FiatMakeRepo fiatMakeRepo;



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Did it wire by repo? {}", fiatMakeRepo);
		FiatDocMake fiatDocMake = new FiatDocMake(1,"090909090","FiatDescription");

		fiatMakeRepo.getAll();

	}

}
