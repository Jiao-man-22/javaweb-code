package jiaorongjinVSD.service;

import java.util.List;

import jiaorongjinVSD.entity.User;

public interface IUserService {
	//增加用户
	public boolean addUser(User user);
	// 登陆查询
	public boolean checkUser(User user);
	//查询用户反回用户信息
	public User  queryUserById(int id);
	//update user return true /false
	public  boolean updateUserById( int id , User user);
	//删除
	public boolean deleteUserById( int id);
	//查询所有
	public List<User>  queryAllUsers();

}
