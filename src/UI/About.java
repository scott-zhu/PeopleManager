package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entity.*;
public class About extends JFrame{
	JFrame a = new JFrame("有关本系统");
	JPanel p = new JPanel();
	JLabel l = new JLabel();
	public About(){
		init();
	}
	public void init(){
		FrameInit.InitFrame(a, p);
		p.add(l,BorderLayout.CENTER);
		a.setSize(new Dimension(300,200));
		l.setText("<html><body><center><h1>欢迎使用本系统</h1></center> "
				+ "<p align=left>本系统为职工档案管理系统<br></p>"
				+ "<p align=left>非系统管理员禁止使用，违者追究法律责任<br></p>"
				+ "<p align=left>默认管理员账号为user，密码为user<br></p>"
				+ "<p align=left><br></p>"
				+ "<p align=right>开发者宣言<br></p>"
				+ "</body></html>");
		a.setVisible(true);
	}
}
