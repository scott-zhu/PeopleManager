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
		
		//�û��ṩһ��User����
		Users u1 = new Users("user","user");
		boolean flag=service.login(u1);		
		
		System.out.println("�û�user��¼" + 
						(flag?"�ɹ�":"ʧ��") + "!");
		if(flag) {
			Users u2 = new Users("user1","user1") ;			
			result = service.login(u2);
			System.out.println("�û�" + u2.getName() + 
						 "��¼" + (result?"�ɹ�":"ʧ��") + "!");			
						
		}
		
		//ʹ�����ݿ��ʾ��
		//1.����û�
		IUserDao dao2 = new UserDaoImp();		
		service.setDao(dao2);
		Users u3 = new Users("user2","user2");
		if(service.register(u3)) {
			System.out.println("�û�ע��ɹ���");
		}else{
			System.out.println("ע��ʧ��");
		}
		//2.��ѯ�û�		
		u3=service.getUser("user2");
		System.out.println("��ѯ���û���" + u3.getName());
		
		//3.ɾ���û�		
		if(u3 != null) {
			if(service.deleteUser(u3.getName())) {
				System.out.println("ɾ���ɹ���");
			}else{
				System.out.println("ɾ��ʧ�ܣ�");
			}
		}		
		//4.�ٲ�ѯ
		u3=service.getUser("user2");
		System.out.println("��ѯ���û���" + u3.getName());
	
	}
}
