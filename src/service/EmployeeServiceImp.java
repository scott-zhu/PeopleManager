package service;

import java.sql.ResultSet;

import Entity.TbEmployeeInfo;
import dao.IBaseDao;
import dao.IEmployeeDao;

public class EmployeeServiceImp implements IEmployeeService{
	IEmployeeDao dao;
	@Override
	public ResultSet getdeptno() {
		// TODO Auto-generated method stub
		return dao.getdeptno();
	}
	@Override
	public ResultSet getEmployee() {
		// TODO Auto-generated method stub
		return dao.getEmployee();
	}
	@Override
	public boolean updateSpeEmployee(TbEmployeeInfo info) {
		// TODO Auto-generated method stub
		return dao.updateSpeEmployee(info);
	}
	@Override
	public boolean addDept(int a, String b) {
		// TODO Auto-generated method stub
		return dao.addDept(a, b);
	}
	@Override
	public ResultSet getEmployeeName() {
		// TODO Auto-generated method stub
		return dao.getEmployeeName();
	}
	@Override
	public ResultSet getDutyName() {
		// TODO Auto-generated method stub
		return dao.getDutyName();
	}
	@Override
	public ResultSet getEmployeeAge() {
		// TODO Auto-generated method stub
		return dao.getEmployeeAge();
	}
	@Override
	public ResultSet getHiredate() {
		// TODO Auto-generated method stub
		return dao.getHiredate();
	}
	@Override
	public ResultSet getNation() {
		// TODO Auto-generated method stub
		return dao.getNation();
	}
	@Override
	public ResultSet getNativePlace() {
		// TODO Auto-generated method stub
		return dao.getNativePlace();
	}
	@Override
	public ResultSet getDegree() {
		// TODO Auto-generated method stub
		return dao.getDegree();
	}	
	public void setDao(IEmployeeDao dao) {
		// TODO Auto-generated method stub
		this.dao= dao;
	}
	@Override
	public boolean addEmployee(TbEmployeeInfo info) {
		// TODO Auto-generated method stub
		return dao.addEmployee(info);
	}
	@Override
	public boolean deleteEmployee(String name) {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(name);
	}
	@Override
	public boolean addDegree(String n) {
		// TODO Auto-generated method stub
		return dao.addDegree(n);
	}
	@Override
	public boolean addduty(String n) {
		// TODO Auto-generated method stub
		return dao.addduty(n);
	}
	@Override
	public boolean addNation(String n) {
		// TODO Auto-generated method stub
		return dao.addNation(n);
	}
	@Override
	public ResultSet getConditionEmp(String n, String a) {
		// TODO Auto-generated method stub
		return dao.getConditionEmp(n, a);
	}
	@Override
	public boolean addNP(String n) {
		// TODO Auto-generated method stub
		return dao.addNP(n);
	}	
	@Override
	public ResultSet getResultSet(String sql) {
		// TODO Auto-generated method stub
		return dao.getResultSet(sql);
	}
	@Override
	public ResultSet getdeptname() {
		// TODO Auto-generated method stub
		return dao.getdeptname();
	}
}
