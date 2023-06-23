package simpleCrud.model.dao;

import simpleCrud.db.DB;
import simpleCrud.model.dao.impl.UserDaoJDBC;

public class DaoFactory {

	public static UserDao createUserDao() {
		return new UserDaoJDBC(DB.getConnection());
	}
}
