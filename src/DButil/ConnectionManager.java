
package DButil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {

	/**
	 * ��������
	 * 
	 * @return Connection
	 */
	public static  Connection getConnection()
			throws DBAccessException {
		// ����������Ϣ
		String driverClassName = Env.getInstance().getProperty("DRIVER_CLASS");
		String url = Env.getInstance().getProperty("DATABASE_URL");
		String password = Env.getInstance().getProperty("DATABASE_PASSWORD");
		String user = Env.getInstance().getProperty("DATABASE_USRE");
		Connection con = null;
		try {
			// �������ݿ���������
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception ex) {
			throw new DBAccessException("����ȡ�����ݿ�����!");
		}
		return con;
	}

	/**
	 * �ر�����
	 * 
	 * @param con
	 */
	public static void closeConnection(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException ex1) {
			System.err.println("Could not close connection : "
					+ ex1.getMessage());
		}
	}

	/**
	 * �رս����
	 * 
	 * @param res
	 *            ResultSet
	 */
	public static void closeResultSet(ResultSet res) {
		try {
			if (res != null) {
				res.close();
				res = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �ر����
	 * 
	 * @param pStatement
	 *            PreparedStatement
	 */

	public static void closeStatement(PreparedStatement pStatement) {
		try {
			if (pStatement != null) {
				pStatement.close();
				pStatement = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
