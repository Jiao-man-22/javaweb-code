package jiaorongjinVSD.service.Impl;

import java.util.List;

import jiaorongjinVSD.dao.IUserDao;
import jiaorongjinVSD.dao.Impl.UserDaoImpl;
import jiaorongjinVSD.entity.User;
import jiaorongjinVSD.service.IUserService;

public class UserServiceImpl  implements IUserService{
	public boolean flag = false;
	//ʹ�ö�̬
	IUserDao userDao = new UserDaoImpl();
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
		System.out.println("service�� ��ѯ����ִ�����");
		return user2;
	}
	//update user return true /false
	public  boolean updateUserById( int id , User user) {
		 userDao.updateUserById(id, user);
		 System.out.println("service�� ����ִ�����");
		return true;
		 
	 }
	//ɾ��
	public boolean deleteUserById( int id) {
		userDao.deleteUserById(id);
		System.out.println("service�� ɾ��ִ�����");
		return true;
	}
	//��ѯ����
	public List<User >  queryAllUsers() {
		list = userDao.queryAllUsers();
		System.out.println("service�� ��ѯ����ִ�����");
		return list;
		
	}
}
	//

