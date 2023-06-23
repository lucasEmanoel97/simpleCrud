package simpleCrud.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import simpleCrud.db.DB;
import simpleCrud.db.DBException;
import simpleCrud.entities.User;
import simpleCrud.model.dao.UserDao;

public class UserDaoJDBC implements UserDao{

	private Connection conn;
	
	public UserDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(User user) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("insert into users (nameUser, email, birthDate) values (?, ?, ?)");
			st.setString(1, user.getName());
			st.setString(2, user.getEmail());
			st.setDate(3, java.sql.Date.valueOf(LocalDate.of(user.getBirthDate().getYear(), user.getBirthDate().getMonth(), user.getBirthDate().getDayOfMonth())));
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DBException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(User user) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("update users set nameUser = ?, email = ?, birthDate = ? where id = ? ");
			st.setString(1, user.getName());
			st.setString(2, user.getEmail());
			st.setDate(3, java.sql.Date.valueOf(LocalDate.of(user.getBirthDate().getYear(), user.getBirthDate().getMonth(), user.getBirthDate().getDayOfMonth())));
			st.setInt(4, user.getId());
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DBException("Error to update user: " + e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement("delete from users where id = ?");
			st.setInt(1, id);
			st.executeUpdate();
		}catch(SQLException e) {
			throw new DBException("Error to delete user: " + e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public User findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from users where users.id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("nameUser"));
				u.setEmail(rs.getString("email"));
				u.setBirthDate(rs.getDate("birthDate").toLocalDate());
				
				return u;
			}
			
			return null;
		}catch(SQLException e) {
			throw new DBException("Error to search user: " + e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<User> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		List<User> listUsers = new ArrayList<>();
		
		try {
			st = conn.prepareStatement("select * from users");
			rs = st.executeQuery();
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("nameUser"));
				u.setEmail(rs.getString("email"));
				u.setBirthDate(rs.getDate("birthDate").toLocalDate());
				
				listUsers.add(u);
			}
		}catch(SQLException e) {
			throw new DBException("Error to list all users: " + e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return listUsers;
	}
}
