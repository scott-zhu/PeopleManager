package service;
import Entity.Users;
import dao.IUserDao;
public interface IUserService extends IService {
	public abstract boolean login(String name,String password);	
	public abstract boolean login(Users user);	
	public abstract boolean getPassword(String a,String b);	
	public abstract boolean register(Users user);	
	public abstract Users getUser(String name);
	public abstract boolean deleteUser(String name);
}
