package jiaorongjinVSD.service.Impl;

import java.util.List;

import jiaorongjinVSD.dao.IUserDao;
import jiaorongjinVSD.dao.Impl.UserDaoImpl;
import jiaorongjinVSD.entity.User;
import jiaorongjinVSD.service.IUserService;

public class UserServiceImpl  implements IUserService{
	public boolean flag = false;
	//使用多态
	IUserDao userDao = new UserDaoImpl();
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
		System.out.println("service层 查询单个执行完毕");
		return user2;
	}
	//update user return true /false
	public  boolean updateUserById( int id , User user) {
		 userDao.updateUserById(id, user);
		 System.out.println("service层 更改执行完毕");
		return true;
		 
	 }
	//删除
	public boolean deleteUserById( int id) {
		userDao.deleteUserById(id);
		System.out.println("service层 删除执行完毕");
		return true;
	}
	//查询所有
	public List<User >  queryAllUsers() {
		list = userDao.queryAllUsers();
		System.out.println("service层 查询所有执行完毕");
		return list;
		
	}
}
	//

