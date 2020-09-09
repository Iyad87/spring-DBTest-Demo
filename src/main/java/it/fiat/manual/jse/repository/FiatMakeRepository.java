package it.fiat.manual.jse.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import it.fiat.manual.jse.mapper.FiatRowMapper;
import it.fiat.manual.jse.model.FiatDocMake;

@Repository
public class FiatMakeRepository {


	@Autowired
	private JdbcTemplate jdbcTemplate;


	public void saveFiatMake(FiatDocMake fiatDocMake) {


		String sql = "INSERT INTO  make (brandCode, description) VALUES (?,?)";
		Object[] params = new Object[]{fiatDocMake.getBrandCode(), fiatDocMake.getDescription()};

		jdbcTemplate.update(sql, params);
	}

	public List<FiatDocMake> getAll() {
		
		String sql = "SELECT * FROM make";

		List<FiatDocMake> fiatDocMakes = jdbcTemplate.query(sql, new FiatRowMapper());

		return fiatDocMakes;
	}


	public void insertFiatMode(FiatDocMake fiatDocMake) {

		String sql = "INSERT INTO make ( ID, NAME , RT_ID) VALUES (?, ? ,?)";
		jdbcTemplate.update(sql, new Object[]{fiatDocMake.getBrandCode(), fiatDocMake.getDescription()});

	}

	public void updateFiatMode(FiatDocMake fiatDocMake) {

		FiatDocMake fiatDocMake1 = new FiatDocMake(fiatDocMake.getBrandCode(), fiatDocMake.getDescription());
		String sql = "UPDATE make SET ID = ?, NAME = ?,  WHERE ID = ?";
		jdbcTemplate.update(sql, fiatDocMake.getBrandCode(), fiatDocMake.getDescription());


	}

	public void deleteFiatMode(String brandCode) {

		String sql = "DELETE FROM make WHERE brandCode = ?";
		jdbcTemplate.update(sql, brandCode);

	}

}
