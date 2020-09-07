package it.fiat.manual.jse.jpa;

import java.sql.*;
import java.util.ArrayList;

public class FiatDao {

	private Connection jdbcConnection;

	public FiatDao(Connection connection)
	{
		jdbcConnection = connection;
	}

	public FiatDocModel getBook(int id) {
		FiatDocModel fiatDocModel = null;
		String sql = "SELECT * FROM fiatDocModel WHERE id = ?";

		try {
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String brandCode = resultSet.getString("brandCode");
				String description = resultSet.getString("description");

				 fiatDocModel = new FiatDocModel(id, brandCode, description);
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fiatDocModel;
	}

	public ArrayList<FiatDocModel> listAllBooks() {
		ArrayList<FiatDocModel> listBook = new ArrayList<>();

		String sql = "SELECT * FROM fiatDocModel";

		try {
			Statement statement = jdbcConnection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String brandCode = resultSet.getString("brandCode");
				String description = resultSet.getString("description");

				FiatDocModel fiatDocModel = new FiatDocModel(id, brandCode, description);
				listBook.add(fiatDocModel);
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBook;
	}

	public boolean insertBook(FiatDocModel fiatDocModel)  {
		String sql = "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";

		try {
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, fiatDocModel.getBrandCode());
			statement.setString(2, fiatDocModel.getDescription());

			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			return rowInserted;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void updateBook(FiatDocModel fiatDocModel){
		String sql = "UPDATE book SET title = ?, author = ?, price = ? WHERE id = ?";

		try {
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, fiatDocModel.getBrandCode());
			statement.setString(2, fiatDocModel.getDescription());
			statement.setInt(4, fiatDocModel.getId());

			int result = statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBook(int id) {
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
