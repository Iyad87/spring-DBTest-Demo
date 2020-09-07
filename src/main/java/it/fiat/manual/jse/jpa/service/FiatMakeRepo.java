package it.fiat.manual.jse.jpa.service;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import it.fiat.manual.jse.jpa.FiatDocMake;
@Service
public class FiatMakeRepo extends AbstractRepo<FiatDocMake> {


	/**
	 * Get all Fiat makes.
	 *
	 * @return all Fiat makes (never null).
	 */
	public List<FiatDocMake> getAll() {
		return execute(
				" SELECT " +
						"    ID as brandCode, " +
						"    RTRIM(NAME) as description " +
						" FROM MAKE where ID is not null",
				BeanPropertyRowMapper.newInstance(FiatDocMake.class));
	}

}
