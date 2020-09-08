package it.fiat.manual;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import it.fiat.manual.jse.jpa.FiatDao;
import it.fiat.manual.jse.jpa.FiatDocMake;
import static org.junit.Assert.assertEquals;

//import it.fiat.manual.jse.jpa.DBConnection;

@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest
@TestExecutionListeners({
		SpringBootDependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class
})
public class ITFiatMakeServiceTest {


	@Autowired
	private FiatDao fiatDao;

	@Test
	@DatabaseSetup("make.xml")
	public void testFind() throws Exception {

		List<FiatDocMake> aList = fiatDao.getAll();
		assertEquals(3, aList.size());
		assertEquals("FIAT                                    ", aList.get(0).getDescription());
	}
}