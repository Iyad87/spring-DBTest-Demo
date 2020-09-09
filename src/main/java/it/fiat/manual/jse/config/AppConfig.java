package it.fiat.manual.jse.config;


import java.beans.ConstructorProperties;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class AppConfig {

	@Bean
	@ConfigurationProperties(prefix = "mssql.datasource")

	public DataSource dataSource(){
		return DataSourceBuilder.create().build();
	}
}
