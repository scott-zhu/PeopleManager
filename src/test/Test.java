package test;

import Entity.Users;
import dao.UserDaoImp;
import dao.IBaseDao;
import dao.IUserDao;
import service.IUserService;
import service.UserServiceImp;

public class Test {
	private static boolean result;

	public static void main(String[] args) {
		UserServiceImp service = new UserServiceImp();
		IUserDao dao = new UserDaoImp();
		service.setDao(dao);		
		
		//用户提供一个User对象
		Users u1 = new Users("user","user");
		boolean flag=service.login(u1);		
		
		System.out.println("用户user登录" + 
						(flag?"成功":"失败") + "!");
		if(flag) {
			Users u2 = new Users("user1","user1") ;			
			result = service.login(u2);
			System.out.println("用户" + u2.getName() + 
						 "登录" + (result?"成功":"失败") + "!");			
						
		}
		
		//使用数据库的示例
		//1.添加用户
		IUserDao dao2 = new UserDaoImp();		
		service.setDao(dao2);
		Users u3 = new Users("user2","user2");
		if(service.register(u3)) {
			System.out.println("用户注册成功！");
		}else{
			System.out.println("注册失败");
		}
		//2.查询用户		
		u3=service.getUser("user2");
		System.out.println("查询的用户：" + u3.getName());
		
		//3.删除用户		
		if(u3 != null) {
			if(service.deleteUser(u3.getName())) {
				System.out.println("删除成功！");
			}else{
				System.out.println("删除失败！");
			}
		}		
		//4.再查询
		u3=service.getUser("user2");
		System.out.println("查询的用户：" + u3.getName());
	
	}
}
