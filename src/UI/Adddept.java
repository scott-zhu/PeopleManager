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
import service.IEmployeeService;
import service.IService;
import service.UserServiceImp;
import Entity.FrameInit;
public class Adddept extends JFrame{
	IEmployeeDao dao;
	EmployeeServiceImp service;
	JFrame ad = new JFrame("�������");
	JPanel p = new JPanel();
	JLabel lbldutyid = new JLabel("���ű��:");
	JTextField txtdutyid = new JTextField(10);
	JLabel lblduty = new JLabel("��������:");
	JTextField txtduty = new JTextField(10);
	JButton btnduty = new JButton("��Ӳ���");
	public Adddept(){
		FrameInit.InitFrame(ad, p);
		ad.setSize(new Dimension(300, 222));
		ad.getContentPane().add(p,BorderLayout.CENTER);
		JPanel p2 = new JPanel();
		p2.setBounds(0, 25, 284, 79);
		JPanel p1 = new JPanel();
		p1.setBounds(0, 132, 284, 52);
		p.setLayout(null);
		p.add(p2);
		
		p.add(p1);
		p2.setLayout(null);
		lbldutyid.setBounds(14, 8, 106, 15);
		p2.add(lbldutyid);
		txtdutyid.setBounds(130, 5, 66, 21);
		p2.add(txtdutyid);
		lblduty.setBounds(14, 54, 106, 15);
		p2.add(lblduty);
		txtduty.setBounds(130, 51, 66, 21);
		p2.add(txtduty);
		
		p1.add(btnduty);
		btnduty.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String dept=txtduty.getText();
				int deptid=Integer.parseInt(txtdutyid.getText());
				if(dept.equals("")|| deptid<0){
					JOptionPane.showMessageDialog(null, "�����벿�ű�Ż�����!","����",JOptionPane.WARNING_MESSAGE);
					return;
				}
				service = new EmployeeServiceImp();
				dao = new EmployeeDaoImp();
				service.setDao(dao);
				boolean flag = service.addDept(deptid,dept);
				if(flag){
					JOptionPane.showMessageDialog(null, "��Ӳ��ųɹ�!","������ʾ",JOptionPane.INFORMATION_MESSAGE);
					return;
				}else{
					JOptionPane.showMessageDialog(null, "��Ӳ���ʧ��!","��������",JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			
		});
		ad.setVisible(true);
	}
}
