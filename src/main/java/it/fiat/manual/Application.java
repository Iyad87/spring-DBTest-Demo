package it.fiat.manual;


import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import it.fiat.manual.jse.jpa.FiatDao;
import it.fiat.manual.jse.jpa.FiatDocMake;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	private FiatDao fiatDao;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {

		jdbcTemplate.execute("CREATE TABLE fiatDocMake(" +
				"brandCode  VARCHAR(255), description VARCHAR(255))");

		FiatDocMake fiatDocMake = new FiatDocMake("1", "Fiat");
		fiatDao.insertFiatMode(fiatDocMake);
		List<FiatDocMake> fiatDocMakes = fiatDao.getAll();
		LOG.info(fiatDocMakes.toString());
	}
}
