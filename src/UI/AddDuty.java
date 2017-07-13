package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.UserDaoImp;
import dao.EmployeeDaoImp;
import dao.IBaseDao;
import dao.IEmployeeDao;
import service.EmployeeServiceImp;
import service.IService;
import service.UserServiceImp;
import Entity.FrameInit;
public class AddDuty extends JFrame{
	IEmployeeDao dao;
	EmployeeServiceImp service;
	JFrame ad = new JFrame("职务添加");
	JPanel p = new JPanel();
	JLabel lblduty = new JLabel("职务名称:");
	JTextField txtduty = new JTextField(10);
	JButton btnduty = new JButton("添加职务");
	public AddDuty(){
		FrameInit.InitFrame(ad, p);
		ad.setSize(new Dimension(300, 203));
		ad.getContentPane().add(p,BorderLayout.CENTER);
		JPanel p2 = new JPanel();
		p2.setBounds(0, 32, 284, 33);
		JPanel p1 = new JPanel();
		p1.setBounds(0, 93, 284, 33);
		p.setLayout(null);
		p.add(p2);
		
		p.add(p1);
		p2.setLayout(null);
		lblduty.setBounds(47, 8, 81, 15);
		p2.add(lblduty);
		txtduty.setBounds(138, 5, 66, 21);
		p2.add(txtduty);
		
		p1.add(btnduty);
		btnduty.addActionListener(new ActionListener(){
			public vo id actionPerformed(ActionEvent e){
				String duty=txtduty.getText();
				if(duty.equals("")){
					JOptionPane.showMessageDialog(null, "请输入职务名称!","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
			
				service = new EmployeeServiceImp();
				dao = new EmployeeDaoImp();
				service.setDao(dao);			
				boolean flag = service.addduty(duty);
				if(flag){
					JOptionPane.showMessageDialog(null, "添加职务成功!","友情提示",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null, "添加职务失败!","发生错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
		});
		ad.setVisible(true);
	}
}
