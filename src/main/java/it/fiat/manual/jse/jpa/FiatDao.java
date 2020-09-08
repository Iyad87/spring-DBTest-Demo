package it.fiat.manual.jse.jpa;

import java.sql.*;
import java.util.ArrayList;

public class FiatDao {

	private Connection jdbcConnection;

	public FiatDao(Connection connection)
	{
		jdbcConnection = connection;
	}

	public FiatDocMake getFiatMode(int id) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fiatDocMake;
	}

	public ArrayList<FiatDocMake> getAll() {
		ArrayList<FiatDocMake> listFiatMake = new ArrayList<>();

		String sql = "SELECT * FROM fiatDocModel";

		try {
			Statement statement = jdbcConnection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String brandCode = resultSet.getString("brandCode");
				String description = resultSet.getString("description");

				FiatDocMake fiatDocMake = new FiatDocMake(brandCode, description);
				listFiatMake.add(fiatDocMake);
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listFiatMake;
	}

	public boolean insertFiatMode(FiatDocMake fiatDocMake)  {
		String sql = "INSERT INTO fiatDocMake (brandCode, description) VALUES (?, ?)";

		try {
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, fiatDocMake.getBrandCode());
			statement.setString(2, fiatDocMake.getDescription());

			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			return rowInserted;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void updateFiatMode(FiatDocMake fiatDocMake){
		String sql = "UPDATE fiatDocMake SET brandCode = ?, description = ?,  WHERE id = ?";

		try {
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, fiatDocMake.getBrandCode());
			statement.setString(2, fiatDocMake.getDescription());

			int result = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteFiatMode(int id) {
		String sql = "DELETE FROM fiatDocModel WHERE id = ?";
		try {
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
