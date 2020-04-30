package jiaorongjinVSD.service;

import java.util.List;

import jiaorongjinVSD.entity.User;

public interface IUserService {
	//�����û�
	public boolean addUser(User user);
	// ��½��ѯ
	public boolean checkUser(User user);
	//��ѯ�û������û���Ϣ
	public User  queryUserById(int id);
	//update user return true /false
	public  boolean updateUserById( int id , User user);
	//ɾ��
	public boolean deleteUserById( int id);
	//��ѯ����
	public List<User>  queryAllUsers();

}
