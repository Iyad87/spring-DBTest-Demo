package it.fiat.manual.jse.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import it.fiat.manual.jse.model.FiatDocMake;

@Repository
public class FiatRepository {


	@Autowired
	private JdbcTemplate jdbcTemplate;


	public void saveFiatMake(FiatDocMake fiatDocMake) throws SQLException {


		String sql = "INSERT INTO  make (brandCode, description) VALUES (?,?)";
		Object[] params = new Object[]{fiatDocMake.getBrandCode(), fiatDocMake.getDescription()};

		jdbcTemplate.update(sql, params);
	}

	public List<FiatDocMake> getAll() throws SQLException {

		List<FiatDocMake> result = new ArrayList<>();

		String sql = "SELECT * FROM make";

		List<FiatDocMake> fiatDocMakes = jdbcTemplate.query(sql, new FiatRowMapper());

		return fiatDocMakes;
	}


	public boolean insertFiatMode(FiatDocMake fiatDocMake) throws SQLException {

		String sql = "INSERT INTO make ( ID, NAME , RT_ID) VALUES (?, ? ,?)";
		return false;

	}

	public void updateFiatMode(FiatDocMake fiatDocMake) {

		String sql = "UPDATE make SET ID = ?, description = ?,  WHERE ID = ?";


	}

	public void deleteFiatMode(String brandCode) {

		String sql = "DELETE FROM make WHERE brandCode = ?";

	}

}
