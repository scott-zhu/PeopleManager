package dao;

import Entity.Users;

public interface IUserDao extends IBaseDao {
	public abstract boolean login(String a,String b);	
	public abstract boolean login(Users user);
	public abstract boolean getPassword(String a,String b);
	public abstract boolean register(Users user);
	public abstract Users getUser(String a);
	public abstract boolean deleteUser(String name);
}
