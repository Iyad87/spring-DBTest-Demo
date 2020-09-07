package it.fiat.manual.jse.jpa.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;


import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import it.fiat.manual.jse.jpa.DBConnection;
import it.fiat.manual.jse.jpa.FiatDocMake;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DBConnection.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
		TransactionalTestExecutionListener.class,
		DbUnitTestExecutionListener.class})
@DatabaseSetup("classpath:/fixtures/make.xml")
public class ITFiatMakeServiceTest {


	@Autowired
	FiatMakeRepo fiatDocMakeRepository;


	@Test
	public void testGetAll() {

		List<FiatDocMake> makes = fiatDocMakeRepository.getAll();

		assertThat(makes.size(), is(3));

		assertThat(
				makes.get(0),
				allOf(hasProperty("brandCode", is("1")),
						hasProperty("description", is("FIAT"))));

	}

}