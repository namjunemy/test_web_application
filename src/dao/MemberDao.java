package dao;

import vo.Member;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public int update(Member member) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.prepareStatement("UPDATE member SET m_name=?,m_email=?,m_phone=?" + " WHERE m_no=?");
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getEmail());
			stmt.setString(3, member.getPhone());
			stmt.setInt(4, member.getNo());
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

	public Member selectOne(int no) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery(
					"SELECT *" + " FROM member JOIN level" + " ON member.l_no = level.l_no and member.m_no = " + no);

			if (rs.next()) {
				return new Member().setNo(rs.getInt("m_no")).setId(rs.getString("m_id")).setLevel(rs.getString("l_name"))
						.setName(rs.getString("m_name")).setEmail(rs.getString("m_email")).setPhone(rs.getString("m_phone"))
						.setRegist(simpleDateFormat.format(rs.getTimestamp("m_regist")));
			} else {
				throw new Exception("해당 소방관을 찾을 수 없습니다.");
			}
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

	public List<Member> selectList() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT *" + " FROM member JOIN level" + " ON member.l_no = level.l_no");
			ArrayList<Member> values = new ArrayList<>();

			while (rs.next()) {
				values.add(new Member().setNo(rs.getInt("m_no")).setId(rs.getString("m_id")).setName(rs.getString("m_id"))
						.setLevel(rs.getString("l_name")).setPasswd(rs.getString("m_passwd")).setEmail(rs.getString("m_email"))
						.setPhone(rs.getString("m_phone")).setRegist(simpleDateFormat.format(rs.getTimestamp("m_regist"))));
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

	public Member exist(String id, String passwd) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			stmt = connection.prepareStatement("SELECT m_no,m_id,m_passwd FROM member" + " WHERE m_id=? AND m_passwd=?");
			stmt.setString(1, id);
			stmt.setString(2, passwd);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return new Member().setNo(Integer.parseInt(rs.getString("m_no"))).setId(rs.getString("m_id"))
						.setPasswd(rs.getString("m_passwd"));
			} else {
				return null;
			}
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
