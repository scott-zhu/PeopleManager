package service;
import java.sql.Connection;
import java.sql.ResultSet;
import Entity.TbEmployeeInfo;
import Entity.Users;
import dao.UserDaoImp;
import dao.IBaseDao;

public interface IService {	
	public abstract ResultSet getResultSet(String sql);			
}
