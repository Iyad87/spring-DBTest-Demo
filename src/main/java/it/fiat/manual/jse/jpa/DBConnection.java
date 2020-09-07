package it.fiat.manual.jse.jpa;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:persistence.properties")
public class DBConnection {


	@Value("${db.url}")
	private String jdbcUrl;
	@Value("${db.username}")
	private String jdbcUsername;
	@Value("${db.password}")
	private String jdbcPassword;

	private DataSource jdbcDataSource;

	@Bean
	public DataSource fiatDataSource() {
		if (jdbcDataSource == null) {
			jdbcDataSource = createDatasource(jdbcUrl, jdbcUsername, jdbcPassword);
		}
		return jdbcDataSource;
	}

	private DataSource createDatasource(String url, String user, String pass) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(pass);
		return dataSource;
	}

}
