package jiaorongjinVSD.service;

import java.util.List;

import jiaorongjinVSD.dao.UserDao;
import jiaorongjinVSD.entity.User;

public class UserService {
	public boolean flag = false;
	UserDao userDao = new UserDao();
	User user2 = new User();
	List<User> list=null; 
	 

	// 注册
	public boolean addUser(User user) {
		flag = userDao.addUser(user);
		if (flag) {
			System.out.println("插入成功");
		}
		return flag;
	}

	// 登陆查询
	public boolean checkUser(User user) {
		user2 = userDao.queryUser(user);
		if (user.getName().equals(user2.getName()) && user.getPwd().equals(user2.getPwd())) {
			return true;
		}
		return false;
	}
	//查询用户反回用户信息
	public User  queryUserById(int id) {
		user2=userDao.queryUser(id);
		return user2;
	}
	//update user return true /false
	public  boolean updateUserById( int id , User user) {
		 userDao.updateUserById(id, user);
		return true;
		 
	 }
	//删除
	public boolean deleteUserById( int id) {
		userDao.deleteUserById(id);
		return true;
	}
	//查询所有
	public List<User >  queryAllUsers() {
		list = userDao.queryAllUsers();
		return list;
		
	}
}
	//

