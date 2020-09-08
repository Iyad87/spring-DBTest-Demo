package it.fiat.manual;


import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

import javax.sql.DataSource;

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
	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}



	@Override
	public void run(String... args) throws Exception {

		Connection connection = dataSource.getConnection();
		fiatDao = new FiatDao(connection);

		FiatDocMake fiatDocMake = new FiatDocMake("1", "Fiat");
		fiatDao.insertFiatMode(fiatDocMake);
		List<FiatDocMake> fiatDocMakes = fiatDao.getAll();
		LOG.info(fiatDocMakes.toString());
	}
}
