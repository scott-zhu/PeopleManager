package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import Entity.TbEmployeeInfo;
import util.OracleHelper;
public class EmployeeDaoImp implements IEmployeeDao{
	private Connection conn;
	public EmployeeDaoImp(){
		conn=OracleHelper.getConnect();
	}	
	public ResultSet getdeptno(){		
		String sql="select deptno from tb_deptinfo";		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{			
			ps=conn.prepareStatement(sql);			
			rs=ps.executeQuery();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return rs;
	}	
	public ResultSet getEmployee(){		
		ResultSet rs = null;
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from tb_employee");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return rs;
	}
	public  boolean updateSpeEmployee(TbEmployeeInfo info){
		String sql = "update tb_employee set ename='"+info.getEname()+
		"',sex='"+info.getSex()+
		"',birthday='"+info.getBirthday()+
		"',npname='"+info.getNpname()+
		"',nation='"+info.getNation()+
		"',degree='"+info.getDegree()+
		"',school='"+info.getSchool()+
		"',dutyname='"+info.getDutyname()+
		"',hiredate='"+info.getHiredate()+
		"',phone='"+info.getPhone()+
		"',idcard='"+info.getIdcard()+
		"',deptno='"+info.getDeptno()+
		"' where ename='"+info.getEname()+"'";		
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
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
	public  boolean addDept(int x1,String x2){		
		PreparedStatement stmt = null;		
		String sql2="insert into tb_deptinfo(deptno,dname) values(?,?)";
		try{			
			stmt = conn.prepareStatement(sql2);		
			stmt.setInt(1, x1);
			stmt.setString(2, x2);			
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
	public ResultSet getEmployeeName(){
		String sql = "select ename from tb_employee";
		ResultSet rs = getResultSet(sql);
		return rs;
	}	
	public ResultSet getDutyName(){
		String sql = "select dutyname from tb_duty";
		ResultSet rs = getResultSet(sql);
		return rs;
	}	
	public ResultSet getEmployeeAge(){
		String sql = "select birthday from tb_employee";
		ResultSet rs = getResultSet(sql);
		return rs;
	}	
	public  ResultSet getHiredate(){
		String sql = "select hiredate from tb_employee";
		ResultSet rs = getResultSet(sql);
		return rs;
	}	
	public  ResultSet getNation(){
		String sql = "select nation from tb_nation";
		ResultSet rs = getResultSet(sql);
		return rs;
	}
	public  ResultSet getNativePlace(){
		String sql ="select npname from tb_nativeplace";
		ResultSet rs = getResultSet(sql);
		return rs;
	}
	public  ResultSet getDegree(){
		String sql ="select degree from tb_degree";
		ResultSet rs = getResultSet(sql);
		return rs;
	}
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
	public boolean addEmployee(TbEmployeeInfo info){		
		PreparedStatement stmt = null;		
		String sql1 = "insert into tb_employee(ENAME,SEX,BIRTHDAY,NPNAME,NATION,DEGREE,SCHOOL,DUTYNAME,HIREDATE,PHONE,IDCARD,DEPTNO) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			stmt = conn.prepareStatement(sql1);
			stmt.setString(1, info.getEname());
			stmt.setString(2, info.getSex());
			stmt.setString(3, info.getBirthday());
			stmt.setString(4, info.getNpname());
			stmt.setString(5, info.getNation());
			stmt.setString(6, info.getDegree());
			stmt.setString(7, info.getSchool());
			stmt.setString(8, info.getDutyname());
			stmt.setString(9, info.getHiredate());
			stmt.setString(10, info.getPhone());
			stmt.setString(11, info.getIdcard());
			stmt.setString(12, info.getDeptno()+"");
			int count = stmt.executeUpdate();
			if(count > 0)
				return true;
			else 
				return false;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	public   boolean deleteEmployee(String name){		
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
			int count = stmt.executeUpdate("delete from tb_employee where ename='"+name+"'");
			if(count>0)
				return true;
			else 
				return false;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	public  boolean addDegree(String xl){		
		PreparedStatement stmt = null;	
		String sql2="insert into tb_degree values(?)";
		System.out.println(sql2);
		try{			
			stmt = conn.prepareStatement(sql2);		
			stmt.setString(1, xl);				
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
	public  boolean addduty(String xl){		
		PreparedStatement stmt = null;
		String sql2="insert into tb_duty values(?)";
		System.out.println(sql2);
		try{			
			stmt = conn.prepareStatement(sql2);		
			stmt.setString(1, xl);			
			
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
	public  boolean addNation(String xl) {		
		PreparedStatement stmt = null;	
		String sql2="insert into tb_nation values(?)";
		System.out.println(sql2);		
		try{			
			stmt = conn.prepareStatement(sql2);		
			stmt.setString(1, xl);						
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
	public  ResultSet getConditionEmp(String col,String val){
		String sql ="select * from tb_employee where ";
		if(col.equals("姓名")){
			sql = sql + "ename='"+val+"'";
		}else if(col.equals("职务")){
			sql = sql+"dutyname='"+val+"'";
		}else if(col.equals("出生日期")){
			sql = sql+"birthday='"+val+"'";
		}else if(col.equals("受聘日期")){
			sql = sql+"hiredate='"+val+"'";
		}else if(col.equals("籍贯")){
			sql = sql+"npname='"+val+"'";
		}else if(col.equals("学位")){
			sql = sql+"degree='"+val+"'";
		}else if(col.equals("性别")){
			sql = sql+"sex='"+val+"'";
		}else if(col.equals("部门")){
			sql = sql+"deptno='"+val+"'";
		}
		ResultSet rs = getResultSet(sql);
		return rs;
	}
	public  boolean addNP(String xl) {		
		PreparedStatement stmt = null;
		String sql2="insert into tb_nativeplace values(?)";
		System.out.println(sql2);
		try{			
			stmt = conn.prepareStatement(sql2);		
			stmt.setString(1, xl);			
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
	public ResultSet getdeptname() {
		// TODO Auto-generated method stub
		String sql="select dname from tb_deptinfo";
		ResultSet rs=getResultSet(sql);
		return rs;
	}
}
