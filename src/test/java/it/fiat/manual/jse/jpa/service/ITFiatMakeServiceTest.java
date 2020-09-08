package it.fiat.manual.jse.jpa.service;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;


import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

//import it.fiat.manual.jse.jpa.DBConnection;
import it.fiat.manual.Application;
import it.fiat.manual.jse.jpa.FiatDao;
import it.fiat.manual.jse.jpa.FiatDocMake;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest
@TestExecutionListeners({
		SpringBootDependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class
})
public class ITFiatMakeServiceTest {

	@Autowired
	private FiatDao fiatDao;

	@Autowired
	DataSource dataSource;

	@Bean
	public DataSource dataSource() {
		return Mockito.mock(DataSource.class);
	}

	@Test
	@DatabaseSetup("make.xml")
	public void testFind() throws Exception {

		List<FiatDocMake> aList = this.fiatDao.getAll();
		assertEquals(3, aList.size());
		assertEquals("FIAT", aList.get(0).getDescription());
	}
}