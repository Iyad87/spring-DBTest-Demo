package it.fiat.manual.jse.jpa.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractRepo <T>{


	/** The data source. */
	@Autowired
	@Qualifier("fiatDataSource")
	private DataSource dataSource;

	/**
	 * Execute an SQL query, expect 0 or more results.
	 *
	 * @param sql
	 *            the sql to execute.
	 * @param mapper
	 *            the mapper to map resultset rows to beans.
	 * @return a list of the generic type (never null).
	 */
	public List<T> execute(String sql, RowMapper<T> mapper) {

		Connection con = DataSourceUtils.getConnection(dataSource);
		try {

			System.out.println("Execute [" + sql + "]");

			List<T> result = new ArrayList<T>();

			ResultSet rs = con.createStatement().executeQuery(sql);

			while(rs.next()){
				T res = mapper.mapRow(rs, rs.getRow());
				result.add(res);
			}

			return result;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DataSourceUtils.releaseConnection(con, dataSource);
		}
	}

	/**
	 * Execute an SQL query, expect only one result.
	 *
	 * @param sql
	 *            the sql to execute.
	 * @param mapper
	 *            the mapper to map resultset rows to beans.
	 * @return A item of the generic type (null if not found).
	 */
	public T executeSingle(String sql, RowMapper<T> mapper) {

		List<T> results = execute(sql, mapper);

		if (results.size()>1) {
			System.out.println("Multiple rows found, expected zero or one");
		}

		return results.isEmpty() ? null : results.get(0);
	}
}
