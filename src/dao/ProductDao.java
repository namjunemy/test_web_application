package dao;

import vo.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Product> selectList() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT *" + " FROM product" + " ORDER BY p_no ASC");
			ArrayList<Product> values = new ArrayList<>();

			while (rs.next()) {
				values.add(new Product().setNo(rs.getInt("p_no")).setName(rs.getString("p_name"))
						.setSize(rs.getString("p_size")).setPrice(rs.getInt("p_price"))
						.setQuantity(rs.getInt("p_quantity")).setDescription(rs.getString("p_description")));
			}
			return values;
		} catch (Exception e) {
			throw e;

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
		}
	}
}
