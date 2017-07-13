package dao;

import java.sql.ResultSet;

import Entity.TbEmployeeInfo;

public interface IEmployeeDao extends IBaseDao {
	public abstract ResultSet getdeptno();
	public abstract ResultSet getdeptname();
	public abstract ResultSet getEmployee();	
	public abstract ResultSet getEmployeeName();
	public abstract ResultSet getDutyName();
	public abstract ResultSet getEmployeeAge();
	public abstract ResultSet getHiredate();
	public abstract ResultSet getNation();
	public abstract ResultSet getNativePlace();
	public abstract ResultSet getDegree();	
	public abstract ResultSet getConditionEmp(String n,String a);
	
	public abstract boolean addEmployee(TbEmployeeInfo  info);	
	public abstract boolean addDegree(String n);
	public abstract boolean addduty(String n);
	public abstract boolean addNation(String n);
	public abstract boolean addDept(int a,String b);	
	public abstract boolean addNP(String n);
	
	public abstract boolean deleteEmployee(String name);
	public abstract boolean updateSpeEmployee(TbEmployeeInfo info);	
	
}
