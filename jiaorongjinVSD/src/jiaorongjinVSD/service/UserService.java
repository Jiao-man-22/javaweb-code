package jiaorongjinVSD.service;

import java.util.List;

import jiaorongjinVSD.dao.UserDao;
import jiaorongjinVSD.entity.User;

public class UserService {
	public boolean flag = false;
	UserDao userDao = new UserDao();
	User user2 = new User();
	List<User> list=null; 
	 

	// ע��
	public boolean addUser(User user) {
		flag = userDao.addUser(user);
		if (flag) {
			System.out.println("����ɹ�");
		}
		return flag;
	}

	// ��½��ѯ
	public boolean checkUser(User user) {
		user2 = userDao.queryUser(user);
		if (user.getName().equals(user2.getName()) && user.getPwd().equals(user2.getPwd())) {
			return true;
		}
		return false;
	}
	//��ѯ�û������û���Ϣ
	public User  queryUserById(int id) {
		user2=userDao.queryUser(id);
		return user2;
	}
	//update user return true /false
	public  boolean updateUserById( int id , User user) {
		 userDao.updateUserById(id, user);
		return true;
		 
	 }
	//ɾ��
	public boolean deleteUserById( int id) {
		userDao.deleteUserById(id);
		return true;
	}
	//��ѯ����
	public List<User >  queryAllUsers() {
		list = userDao.queryAllUsers();
		return list;
		
	}
}
	//

