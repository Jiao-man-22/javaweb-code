package shoppingmall.jiao.dao;

import java.util.List;

import shoppingmall.jiao.entity.UserBean;

public interface IUserBeanOrders {
	
	//增加用户
	public boolean addUser(String name ,String password,int grade);
	//删除用户
	public boolean deleteUser(String  name);
	//修改用户
	public boolean updateUser(String name ,String password,int grade,String oldername);
	//查询单个用户 
	public UserBean queryUserByName(String name);
	//查询所有用户 
	public List<UserBean> queryUser();	

	

}
