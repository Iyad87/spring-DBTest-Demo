package it.fiat.manual;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.fiat.manual.jse.repository.FiatMakeDao;
import it.fiat.manual.jse.model.FiatDocMake;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	@Autowired
	private FiatMakeDao fiatMakeDao;


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


		List<FiatDocMake> fiatDocMakes = fiatMakeDao.getAll();
	    LOG.info(fiatDocMakes.toString());

	}
}
