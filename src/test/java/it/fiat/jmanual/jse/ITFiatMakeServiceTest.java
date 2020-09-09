package it.fiat.jmanual.jse;

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

import it.fiat.manual.jse.repository.FiatRepository;
import it.fiat.manual.jse.model.FiatDocMake;
import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)

@SpringBootTest
@TestExecutionListeners({
		SpringBootDependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class
})
public class ITFiatMakeServiceTest {


	@Autowired
	private FiatRepository fiatRepository;

	@Test
	@DatabaseSetup("make.xml")
	public void testFind() throws Exception {

		List<FiatDocMake> aList = fiatRepository.getAll();
		assertEquals(3, aList.size());
		assertEquals("FIAT                                    ", aList.get(0).getDescription());
	}
}