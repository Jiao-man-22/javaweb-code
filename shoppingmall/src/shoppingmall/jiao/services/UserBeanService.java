package shoppingmall.jiao.services;

import java.util.List;

import shoppingmall.jiao.entity.UserBean;

public interface UserBeanService {
	//�����û�
		public boolean addUser(UserBean user);
		//ɾ���û�
		public boolean deleteUser(UserBean user);
		//�޸��û�
		public boolean updateUser(UserBean user,String oldername);
		//��ѯ�����û� 
		public UserBean queryUserByName(UserBean user);
		//��ѯ�����û� 
		public List<UserBean> queryUser();	
		//��ʵ�û���½
		public boolean checkUser(UserBean user);
		//����Ա��½
		public List<UserBean> adminLogin(UserBean user,int pageNow,int pageSize);
		//�ж��Ƿ�Ϊ����Ա
		public boolean isAdmin(UserBean user);

}
