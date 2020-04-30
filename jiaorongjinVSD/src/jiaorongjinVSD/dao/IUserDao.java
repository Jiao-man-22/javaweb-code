package jiaorongjinVSD.dao;
import java.util.List;

import jiaorongjinVSD.entity.User;

public interface IUserDao {
	public User queryUser(User user);

	public boolean addUser(User user);

	public User queryUser(int id);

	public boolean updateUserById(int id, User user);

	public List<User> queryAllUsers();
	
	public boolean deleteUserById( int id);

}
