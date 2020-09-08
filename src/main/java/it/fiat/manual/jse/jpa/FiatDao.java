package it.fiat.manual.jse.jpa;

import java.sql.*;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class FiatDao {

	@Autowired
	private DataSource dataSource;


	public FiatDao(DataSource dataSource) throws SQLException {
		this.dataSource = dataSource;
	}

	public FiatDocMake getFiatMode(int id) throws SQLException {
		Connection jdbcConnection = dataSource.getConnection();
		FiatDocMake fiatDocMake = null;
		String sql = "SELECT * FROM fiatDocModel WHERE id = ?";
		try {
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String brandCode = resultSet.getString("brandCode");
				String description = resultSet.getString("description");

				fiatDocMake = new FiatDocMake(brandCode, description);
			}

			resultSet.close();
			statement.close();
			jdbcConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fiatDocMake;
	}

	public ArrayList<FiatDocMake> getAll() throws SQLException {
		Connection jdbcConnection = dataSource.getConnection();

		ArrayList<FiatDocMake> listFiatMake = new ArrayList<>();

		String sql = "SELECT * FROM make";

		try {

			Statement statement = jdbcConnection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int rt_id = resultSet.getInt("RT_ID");
				String brandCode = resultSet.getString("ID");
				String description = resultSet.getString("NAME");

				FiatDocMake fiatDocMake = new FiatDocMake(brandCode, description);
				listFiatMake.add(fiatDocMake);
			}

			resultSet.close();
			statement.close();
			jdbcConnection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listFiatMake;
	}

	public boolean insertFiatMode(FiatDocMake fiatDocMake) throws SQLException {
		Connection jdbcConnection = dataSource.getConnection();

		String sql = "INSERT INTO make ( ID, NAME , RT_ID) VALUES (?, ? ,?)";

		try {
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, fiatDocMake.getBrandCode());
			statement.setString(2, fiatDocMake.getDescription());
			statement.setInt(3, 50);
			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			jdbcConnection.close();

			return rowInserted;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void updateFiatMode(FiatDocMake fiatDocMake) throws SQLException {
		Connection jdbcConnection = dataSource.getConnection();

		String sql = "UPDATE make SET ID = ?, description = ?,  WHERE ID = ?";

		try {
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, fiatDocMake.getBrandCode());
			statement.setString(2, fiatDocMake.getDescription());

			int result = statement.executeUpdate();
			statement.close();
			jdbcConnection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteFiatMode(String brandCode) throws SQLException {
		Connection jdbcConnection = dataSource.getConnection();

		String sql = "DELETE FROM make WHERE brandCode = ?";
		try {
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, brandCode);
			statement.executeUpdate();
			statement.close();
			jdbcConnection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
