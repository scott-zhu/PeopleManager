package Entity;

import java.io.Serializable;
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;
	//��������
	private String name;
	private String password;
	//���췽��
	public Users() {
	}
	public Users(String string, String string2) {
		this.name=string;
		this.password=string2;
	}
	//get��set����
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
