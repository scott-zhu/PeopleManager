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

import Entity.FrameInit;
import dao.UserDaoImp;
import dao.EmployeeDaoImp;
import dao.IBaseDao;
import dao.IEmployeeDao;
import service.EmployeeServiceImp;
import service.IService;
import service.UserServiceImp;
public class Addnation extends JFrame{
	IEmployeeDao dao;
	EmployeeServiceImp service;
	
	JFrame ad = new JFrame("�������");
	JPanel p = new JPanel();
	JLabel lblduty = new JLabel("��������:");
	JTextField txtduty = new JTextField(10);
	JButton btnduty = new JButton("�������");
	public Addnation(){
		FrameInit.InitFrame(ad, p);
		ad.setSize(new Dimension(300, 222));
		ad.getContentPane().add(p,BorderLayout.CENTER);
		JPanel p2 = new JPanel();
		p2.setBounds(0, 25, 284, 52);
		JPanel p1 = new JPanel();
		p1.setBounds(0, 87, 284, 52);
		p.setLayout(null);
		p.add(p2);
		
		p.add(p1);
		p2.add(lblduty);
		p2.add(txtduty);
		
		p1.add(btnduty);
		btnduty.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String duty=txtduty.getText();
				if(duty.equals("")){
					JOptionPane.showMessageDialog(null, "��������������!","����",JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				service = new EmployeeServiceImp();
				dao = new EmployeeDaoImp();
				service.setDao(dao);
				boolean flag = service.addNation(duty);
				if(flag){
					JOptionPane.showMessageDialog(null, "�������ɹ�!","������ʾ",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null, "�������ʧ��!","��������",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
		});
		ad.setVisible(true);
	}
}
