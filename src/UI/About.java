package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Entity.*;
public class About extends JFrame{
	JFrame a = new JFrame("�йر�ϵͳ");
	JPanel p = new JPanel();
	JLabel l = new JLabel();
	public About(){
		init();
	}
	public void init(){
		FrameInit.InitFrame(a, p);
		p.add(l,BorderLayout.CENTER);
		a.setSize(new Dimension(300,200));
		l.setText("<html><body><center><h1>��ӭʹ�ñ�ϵͳ</h1></center> "
				+ "<p align=left>��ϵͳΪְ����������ϵͳ<br></p>"
				+ "<p align=left>��ϵͳ����Ա��ֹʹ�ã�Υ��׷����������<br></p>"
				+ "<p align=left>Ĭ�Ϲ���Ա�˺�Ϊuser������Ϊuser<br></p>"
				+ "<p align=left><br></p>"
				+ "<p align=right>����������<br></p>"
				+ "</body></html>");
		a.setVisible(true);
	}
}
