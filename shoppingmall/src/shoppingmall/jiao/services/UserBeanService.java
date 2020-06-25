package shoppingmall.jiao.services;

import java.util.List;

import shoppingmall.jiao.entity.UserBean;

public interface UserBeanService {
	//增加用户
		public boolean addUser(UserBean user);
		//删除用户
		public boolean deleteUser(UserBean user);
		//修改用户
		public boolean updateUser(UserBean user,String oldername);
		//查询单个用户 
		public UserBean queryUserByName(UserBean user);
		//查询所有用户 
		public List<UserBean> queryUser();	
		//核实用户登陆
		public boolean checkUser(UserBean user);
		//管理员登陆
		public List<UserBean> adminLogin(UserBean user,int pageNow,int pageSize);
		//判断是否为管理员
		public boolean isAdmin(UserBean user);

}
