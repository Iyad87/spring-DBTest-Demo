package it.fiat.manual.jse.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.fiat.manual.jse.model.FiatDocMake;

public class FiatRowMapper implements RowMapper<FiatDocMake> {

	@Override
	public FiatDocMake mapRow(ResultSet rs, int rowNum) throws SQLException{
		FiatDocMake fiatDocMake = new FiatDocMake();
		fiatDocMake.setBrandCode(rs.getString("ID"));
		fiatDocMake.setDescription(rs.getString("NAMe"));

		return fiatDocMake;
	}

}
