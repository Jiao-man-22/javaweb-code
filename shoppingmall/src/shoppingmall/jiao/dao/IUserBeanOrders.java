package shoppingmall.jiao.dao;

import java.util.List;

import shoppingmall.jiao.entity.UserBean;

public interface IUserBeanOrders {
	
	//�����û�
	public boolean addUser(String name ,String password,int grade);
	//ɾ���û�
	public boolean deleteUser(String  name);
	//�޸��û�
	public boolean updateUser(String name ,String password,int grade,String oldername);
	//��ѯ�����û� 
	public UserBean queryUserByName(String name);
	//��ѯ�����û� 
	public List<UserBean> queryUser();	

	

}
