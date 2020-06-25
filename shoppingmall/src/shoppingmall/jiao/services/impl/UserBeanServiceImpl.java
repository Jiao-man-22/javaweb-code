package shoppingmall.jiao.services.impl;

import java.util.List;

import org.junit.Test;

import shoppingmall.jiao.DBUtils.Paged;
import shoppingmall.jiao.dao.IUserBeanOrders;
import shoppingmall.jiao.dao.impl.UserBeanOrdersImpl;
import shoppingmall.jiao.entity.UserBean;
import shoppingmall.jiao.services.UserBeanService;

public class UserBeanServiceImpl implements UserBeanService {
	IUserBeanOrders ius = new UserBeanOrdersImpl();
	UserBean ub = null;
	boolean flag = false;
	List<UserBean> list = null;
	Paged paged = null;

	@Override
	public boolean addUser(UserBean user) {
		flag = ius.addUser(user.getUsername(), user.getPasswd(), user.getGrade());
		if (flag) {
			return flag;
		}
		return false;
	}

	@Override
	public boolean deleteUser(UserBean user) {
		flag = ius.deleteUser(user.getUsername());
		if (flag) {
			return flag;
		}
		return false;
	}

	@Override
	public boolean updateUser(UserBean user, String oldername) {
		flag = ius.updateUser(user.getUsername(), user.getPasswd(), user.getGrade(), oldername);
		if (flag) {
			return flag;
		}
		return false;
	}

	@Override
	public UserBean queryUserByName(UserBean user) {
		ub = ius.queryUserByName(user.getUsername());
		if (ub != null) {
			return ub;
		}
		return ub;
	}

	@Override
	public List<UserBean> queryUser() {
		List<UserBean> list = ius.queryUser();
		return list;
	}

	@Override
	public boolean checkUser(UserBean user) {
		ub = ius.queryUserByName(user.getUsername());
		if (ub != null) {
			if (ub.getPasswd().equals(user.getPasswd())) {
				flag = true;
				return flag;
			}
		}
		return flag;
	}

	@Override
	public List<UserBean> adminLogin(UserBean user, int pageNow, int pageSize) {
		paged = new Paged();
		if(this.isAdmin(user)) {
			list = paged.getPagedData(pageNow, pageSize);
			if(list!=null) {
				return list;
			}
		}
		return list;
	}

	@Override
	public boolean isAdmin(UserBean user) {
		// TODO Auto-generated method stub
		ub = ius.queryUserByName(user.getUsername());
		if(ub!=null) {
			if(ub.getGrade()==0) {
			flag=true;
			System.out.println("恭喜您是管理员");
			return flag;
		}
			}
		return flag;
	}
	@Test
	public void add() {
		UserBean user=new UserBean(); 
		user.setUsername("jiao");
		user.setPasswd("123");
		user.setGrade(0);
		user.setEmail("1366845865@qq.com");
		user.setAddress("中南海");
		//this.queryUserByName(user);
		//this.addUser(user);
		//this.checkUser(user);
		//this.isAdmin(user);
		//this.adminLogin(user, 1, 5);
		//this.deleteUser(user);
	}

}
