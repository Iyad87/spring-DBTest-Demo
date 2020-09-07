package it.fiat.manual;


import java.sql.Connection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.fiat.manual.jse.jpa.DBConnection;
import it.fiat.manual.jse.jpa.FiatDao;
import it.fiat.manual.jse.jpa.FiatDocMake;
import it.fiat.manual.jse.jpa.service.FiatMakeRepo;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);



	@Autowired
	private FiatMakeRepo fiatMakeRepo;

	@Autowired
	DBConnection dbConnection;

	Connection connection;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Did it wire by repo? {}", fiatMakeRepo);
		FiatDocMake fiatDocMake = new FiatDocMake(1,"090909090","FiatDescription");
		dbConnection.fiatDataSource();
		List<FiatDocMake> fiatDocMakes =  fiatMakeRepo.getAll();
//		String sql = "SELECT * FROM fiatDocModel";
//		connection.prepareStatement(sql);
//		FiatDao fiatDao = new FiatDao(connection);
//		fiatDao.insertFiatMode(fiatDocMake);

		System.out.println(fiatDocMakes);
	}
}
