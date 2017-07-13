package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import Entity.TbEmployeeInfo;
import Entity.Users;

public interface IBaseDao {		
	public abstract ResultSet getResultSet(String sql);	
}
