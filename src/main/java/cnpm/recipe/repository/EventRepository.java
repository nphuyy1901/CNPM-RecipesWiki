package cnpm.recipe.repository;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cnpm.recipe.db.DbConst;
import cnpm.recipe.db.MySQLConnection;
import cnpm.recipe.model.Event;
import cnpm.recipe.model.User;

public class EventRepository {

	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet rs = null;
	
	public List<Event> getEvent() {
		List<Event> events = new LinkedList<Event>();
		try {
			connection = MySQLConnection.getConnection();
			String query = DbConst.GET_EVENT;
			statement = connection.prepareStatement(query);
			rs = statement.executeQuery();
	
			while (rs.next()) {
				Event event = new Event();
				event.setId(rs.getInt("e.id"));				
				event.setId_user(rs.getInt("e.iduser"));
				event.setTenuser(rs.getString("e.tenuser"));
				event.setTen(rs.getString("e.ten"));
				event.setMota(rs.getString("e.mota"));			
				event.setTgbatdau(rs.getDate("e.tgbatdau"));
				event.setTgketthuc(rs.getDate("e.tgbatdau"));
				event.setSoluong(rs.getInt("e.soluong"));
				event.setHinhanh(rs.getString("e.hinhanh"));
				event.setHinhanhquangcao(rs.getString("e.hinhquangcao"));
				event.setGiaithuong(rs.getString("e.giaithuong"));
					
				events.add(event);
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
		return events;
	}
	
	public int insertEvent(Event event) {
		try {
			connection = MySQLConnection.getConnection();
			String query = DbConst.INSERT_EVENT;

			statement = connection.prepareStatement(query);

			statement.setInt(1, event.getId_user());
			statement.setString(2, event.getTenuser());
			statement.setString(3, event.getTen());
			statement.setString(4, event.getMota());
			statement.setDate(5, (Date) event.getTgbatdau());
			statement.setDate(6, (Date) event.getTgketthuc());
			statement.setInt(7, event.getSoluong());
			statement.setString(8, event.getHinhanh());
			statement.setString(9, event.getHinhanhquangcao());
			statement.setString(10, event.getGiaithuong());
		
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
	
	public Event getEventById(int id) {
		Event event = new Event();
		try {
			connection = MySQLConnection.getConnection();
			String query = DbConst.GET_EVENT_BY_ID;
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			
			while (rs.next()) {				
				event.setId(rs.getInt("e.id"));
				event.setId_user(rs.getInt("e.iduser"));
				event.setTenuser(rs.getString("e.tenuser"));
				event.setTen(rs.getString("e.ten"));
				event.setMota(rs.getString("e.mota"));			
				event.setTgbatdau(rs.getDate("e.tgbatdau"));
				event.setTgketthuc(rs.getDate("e.tgbatdau"));
				event.setSoluong(rs.getInt("e.soluong"));
				event.setHinhanh(rs.getString("e.hinhanh"));
				event.setHinhanhquangcao(rs.getString("e.hinhquangcao"));
				event.setGiaithuong(rs.getString("e.giaithuong"));
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
		return event;
	}
	
	public List<Event> getEventByIDUser(int iduser) {
		List<Event> events = new LinkedList<Event>();
		try {
			connection = MySQLConnection.getConnection();
			String query = DbConst.GET_EVENT_BY_IDUSEr;
			statement = connection.prepareStatement(query);
			statement.setInt(1, iduser);
			rs = statement.executeQuery();
	
			while (rs.next()) {
				Event event = new Event();
				event.setId(rs.getInt("e.id"));				
				event.setId_user(rs.getInt("e.iduser"));
				event.setTenuser(rs.getString("e.tenuser"));
				event.setTen(rs.getString("e.ten"));
				event.setMota(rs.getString("e.mota"));			
				event.setTgbatdau(rs.getDate("e.tgbatdau"));
				event.setTgketthuc(rs.getDate("e.tgbatdau"));
				event.setSoluong(rs.getInt("e.soluong"));
				event.setHinhanh(rs.getString("e.hinhanh"));
				event.setHinhanhquangcao(rs.getString("e.hinhquangcao"));
				event.setGiaithuong(rs.getString("e.giaithuong"));
					
				events.add(event);
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
		return events;
	}
	
	
	public int deleteTGEvent(int id) {
		try {
			connection = MySQLConnection.getConnection();
			String query = DbConst.DELETE_TGEVENT;

			statement = connection.prepareStatement(query);

		
			statement.setInt(1, id);
			
			
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
	
	public int deleteEvent(int id) {
		try {
			connection = MySQLConnection.getConnection();
			String query = DbConst.DELETE_EVENT;

			statement = connection.prepareStatement(query);

		
			statement.setInt(1, id);
			
			
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
