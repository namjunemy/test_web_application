package dao;

import vo.Receipt;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReceiptDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int insert(Receipt receipt) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = dataSource.getConnection();
			stmt = connection.prepareStatement("INSERT INTO receipt(m_no,p_no,r_date)" + " VALUES (?,?,now())");
			stmt.setInt(1, receipt.getmNo());
			stmt.setInt(2, receipt.getpNo());
			return stmt.executeUpdate();

		} catch (Exception e) {
			throw e;

		} finally {
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

	public List<Receipt> selectList(int no) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT r_no,r_date,m_id,m_name,p_name,p_size,p_price,p_description"
					+ " FROM member JOIN receipt" + " ON member.m_no = receipt.m_no and member.m_no = " + no
					+ " JOIN product" + " ON receipt.p_no = product.p_no;");

			ArrayList<Receipt> values = new ArrayList<>();

			while (rs.next()) {
				values.add(new Receipt().setrNo(rs.getInt("r_no"))
						.setrDate(simpleDateFormat.format(rs.getTimestamp("r_date"))).setmId(rs.getString("m_id"))
						.setmName(rs.getString("m_name")).setpName(rs.getString("p_name"))
						.setpSize(rs.getString("p_size")).setpPrice(rs.getInt("p_price"))
						.setpDescription(rs.getString("p_description")));
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

	public int delete(int no) throws Exception {
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			return stmt.executeUpdate("DELETE FROM receipt WHERE r_no=" + no);

		} catch (Exception e) {
			throw e;

		} finally {
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
