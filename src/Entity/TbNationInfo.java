package Entity;

import java.io.Serializable;
public class TbNationInfo implements Serializable {

	private int id;
	private String nation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
}
