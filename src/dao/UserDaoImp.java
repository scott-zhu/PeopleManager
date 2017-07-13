package dao;

import java.sql.*;
import java.util.Random;

import Entity.TbEmployeeInfo;
import Entity.Users;
import UI.*;
import util.OracleHelper;
public class UserDaoImp implements IUserDao {
	private Connection conn;
	public UserDaoImp(){
		conn=OracleHelper.getConnect();
	}	
	public boolean login(String name,String password){
		PreparedStatement stmt=null;
		String sql="select * from users where name=? and password=?";
		try{
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, password);
			int count=stmt.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}	
	public  boolean getPassword(String name,String password){
		String sql="select * from users where name='"+name+"'and password='"+password+"'";		
		try{
			Statement stmt = conn.createStatement();			
			int count = stmt.executeUpdate(sql);
			if(count>0)
				return true;
			else
				return false;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}		
	}
	@Override
	public boolean login(Users user) {
		// TODO Auto-generated method stub
		PreparedStatement stmt=null;
		String sql="select * from users where name=? and password=?";
		try{
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPassword());
			int count=stmt.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	@Override
	public boolean register(Users user) {	
		PreparedStatement stmt = null;	
		String sql2="insert into users values(?,?)";		
		try{			
			stmt = conn.prepareStatement(sql2);		
			stmt.setString(1, user.getName());	
			stmt.setString(2, user.getPassword());			
			int count = stmt.executeUpdate();
			if(count>0)
				return true;
			else 
				return false;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}		
	}
	@Override
	public  ResultSet getResultSet(String sql){
		ResultSet rs = null;
		Statement stmt = null;
		
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		return rs;
	}
	@Override
	public Users getUser(String a) {
		// TODO Auto-generated method stub
		ResultSet rs;
		String sql="select * from users where name='"+a+"'";
		rs=getResultSet(sql);
		Users user=null;
		try {
			if(rs.next()){
				user=new Users(rs.getString("name"),rs.getString("password"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return user;		
	}
	@Override
	public boolean deleteUser(String name) {
		// TODO Auto-generated method stub
		String sql="delete from users where name='"+name+"'";
		PreparedStatement ps =null;
		int flag;
		try {
			ps=conn.prepareStatement(sql);
			flag=ps.executeUpdate();
			if(flag>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}	
}
