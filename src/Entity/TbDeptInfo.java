package Entity;

import java.io.Serializable;
public class TbDeptInfo implements Serializable {
	public TbDeptInfo() {
	}
	private int deptid;
	private String dname;
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
}
