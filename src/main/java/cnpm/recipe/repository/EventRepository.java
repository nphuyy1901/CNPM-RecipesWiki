package cnpm.recipe.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cnpm.recipe.db.DbConst;
import cnpm.recipe.db.MySQLConnection;
import cnpm.recipe.model.Event;

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
				event.setTen(rs.getString("e.ten"));
				event.setMota(rs.getString("e.mota"));			
				event.setTgbatdau(rs.getDate("e.tgbatdau"));
				event.setTgketthuc(rs.getDate("e.tgbatdau"));
				event.setSoluong(rs.getInt("e.soluong"));
				event.setHinhanh(rs.getString("e.hinhanh"));
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
}