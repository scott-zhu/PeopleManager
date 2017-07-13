package Entity;

import java.io.Serializable;
public class TbNpnameInfo implements Serializable {

	public TbNpnameInfo() {
		// TODO Auto-generated constructor stub
	}
	private int id;
	private String npname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNpname() {
		return npname;
	}
	public void setNpname(String npname) {
		this.npname = npname;
	}
}
