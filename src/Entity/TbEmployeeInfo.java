package Entity;
import java.io.Serializable;
public class TbEmployeeInfo implements Serializable{
	//无参构造
	public TbEmployeeInfo(){		
	}
	//属性
	private String ename;		
	private String sex;
	private String birthday;
	private String npname;
	private String nation;
	private String degree;
	private String school;	
	private String dutyname;
	private String hiredate;
	private String phone;
	private String idcard;
	private int deptno;
	//get和set方法
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNpname() {
		return npname;
	}
	public void setNpname(String npname) {
		this.npname = npname;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	public String getDutyname() {
		return dutyname;
	}
	public void setDutyname(String dutyname) {
		this.dutyname = dutyname;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	@Override
	public String toString() {
		return "TbEmployeeInfo [ename=" + ename + ", sex=" + sex + ", birthday=" + birthday + ", npname=" + npname
				+ ", nation=" + nation + ", degree=" + degree + ", school=" + school + ", dutyname=" + dutyname
				+ ", hiredate=" + hiredate + ", phone=" + phone + ", idcard=" + idcard + ", deptno=" + deptno + "]";
	}
}
