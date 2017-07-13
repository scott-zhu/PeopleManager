package Entity;

import java.io.Serializable;
public class TbDutyInfo implements Serializable {
	public TbDutyInfo() {		
	}
	private int dutyid;
	private String dutyname;
	
	public int getDutyid() {
		return dutyid;
	}
	public void setDutyid(int dutyid) {
		this.dutyid = dutyid;
	}
	public String getDutyname() {
		return dutyname;
	}
	public void setDutyname(String dutyname) {
		this.dutyname = dutyname;
	}
}
