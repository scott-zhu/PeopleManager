package service;

import java.sql.Connection;
import java.sql.ResultSet;

import Entity.TbEmployeeInfo;
import Entity.Users;
import dao.UserDaoImp;
import dao.IBaseDao;
import dao.IUserDao;

public class UserServiceImp implements IUserService {
	IUserDao dao;	

	@Override
	public ResultSet getResultSet(String sql) {
		// TODO Auto-generated method stub
		return dao.getResultSet(sql);
	}	

	@Override
	public boolean getPassword(String a, String b) {
		// TODO Auto-generated method stub
		return dao.getPassword(a, b);
	}
	

	
	public void setDao(IUserDao dao) {
		// TODO Auto-generated method stub
		this.dao=dao;
	}

	@Override
	public boolean login(String name, String password) {
		// TODO Auto-generated method stub
		return dao.login(name,password);
	}

	@Override
	public boolean login(Users user) {
		// TODO Auto-generated method stub
		return dao.login(user);
	}

	@Override
	public boolean register(Users user) {
		// TODO Auto-generated method stub
		return dao.register(user);
	}

	@Override
	public Users getUser(String name) {
		// TODO Auto-generated method stub
		return dao.getUser(name);
	}

	@Override
	public boolean deleteUser(String name) {
		// TODO Auto-generated method stub
		return dao.deleteUser(name);
	}	

}
