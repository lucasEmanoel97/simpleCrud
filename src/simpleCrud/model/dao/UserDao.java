package simpleCrud.model.dao;

import java.util.List;

import simpleCrud.entities.User;

public interface UserDao {

	void insert(User user);
	void update(User user);
	void deleteById(Integer id);
	User findById(Integer id);
	List<User> findAll();
	
}
