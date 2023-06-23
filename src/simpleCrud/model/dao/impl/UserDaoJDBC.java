package simpleCrud.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
