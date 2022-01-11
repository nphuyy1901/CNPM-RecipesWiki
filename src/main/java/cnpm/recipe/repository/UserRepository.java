package cnpm.recipe.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import cnpm.recipe.db.DbConst;
import cnpm.recipe.db.MySQLConnection;
import cnpm.recipe.model.User;

public class UserRepository {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;
	
	
	public User getUserById(int id) {
		try {
			connection = MySQLConnection.getConnection();
			String query = DbConst.GET_USERS;
			statement = connection.prepareStatement(query);
			statement.setInt(1,id);
			rs = statement.executeQuery();
	
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("u.id"));
				user.setIdaccount(rs.getInt("u.idaccount"));
				user.setFullname(rs.getString("u.fullname"));
				user.setDOB(rs.getDate("u.DOB"));
				user.setAvatar(rs.getString("u.avatar"));
				return user;
			}
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
				rs.close();
			} catch (SQLException e) {
				System.out.println("Lỗi đóng kết nối");
				e.printStackTrace();
			}
		}
		return null;
		
	}
	
	public int inserUser(User user) {
		try {
			connection = MySQLConnection.getConnection();
			String query = DbConst.INSERT_USER;

			statement = connection.prepareStatement(query);

			statement.setInt(1, user.getIdaccount());
			statement.setString(2, user.getFullname());
			statement.setDate(3, (Date) user.getDOB());
			statement.setString(4, user.getAvatar());
		
			return statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				System.out.println("Lỗi đóng kết nối");
				e.printStackTrace();
			}
		}
		return 0;
	}
}
