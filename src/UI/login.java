package UI;
import javax.swing.*;

import dao.UserDaoImp;
import dao.EmployeeDaoImp;
import dao.IBaseDao;
import dao.IEmployeeDao;
import dao.IUserDao;
import service.EmployeeServiceImp;
import service.IService;
import service.UserServiceImp;
import util.OracleHelper;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JDialog implements ActionListener{
	IUserDao dao;
	UserServiceImp service;
	private Connection conn;	
	//定义登录界面的组件
		JButton jb1,jb3=null;
		JRadioButton jrb1,jrb2=null;
		JPanel jp1,jp2,jp3=null;
	    JTextField jtf=null;
		JLabel jlb1,jlb2=null;
		JPasswordField jpf=null;
	
	public login(/*MainFrame mf*/)
	{
		getContentPane().setBackground(SystemColor.menu);
		conn = OracleHelper.getConnect();
		setTitle("职工档案管理系统");
		
		getContentPane().setLayout(null);
		
		this.setResizable(false);

		
		 //创建组件
		jb1=new JButton("登录");
		
		jb3=new JButton("退出");
		//设置监听
		jb1.addActionListener(this);
		
		jb3.addActionListener(this);
		
		jlb1=new JLabel("用户名：");
		jlb2=new JLabel("密    码：");
		
		jtf=new JTextField(10);
		jpf=new JPasswordField(10);
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		jp1.add(jlb1);
		jp1.add(jtf);
		
		jp2.add(jlb2);
		jp2.add(jpf);
		
		jp3.add(jb1);
		
		jp3.add(jb3);
		jp1.setBounds(0, 32, 300, 30);
		jp2.setBounds(0, 72, 300, 30);
		jp3.setBounds(0, 112, 300, 40);
		getContentPane().add(jp1);
		getContentPane().add(jp2);
		getContentPane().add(jp3);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u767B\u9646\u804C\u5DE5\u6863\u6848\u7BA1\u7406\u7CFB\u7EDF");
		label.setBounds(81, 10, 192, 15);
		getContentPane().add(label);
		
		this.setSize(300, 180);
		this.setLocation(300, 200);
		
//		this.setTitle("注册登录界面");
		this.setVisible(true);	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//监听各个按钮
		if(e.getActionCommand()=="退出")
		{
			System.exit(0);
		}else if(e.getActionCommand()=="登录")
		{
			//调用登录方法
			this.login();
		}		
	}	

	//登录方法
	public void login() {
		service = new UserServiceImp();
		dao = new UserDaoImp();
		service.setDao(dao);
		if(service.getPassword(this.jtf.getText(), this.jpf.getText())){
			this.setVisible(false);
			MainFrame mi = new MainFrame();
			mi.init();
		}else{
			JOptionPane.showConfirmDialog(null, "账户或密码错误");
			this.setVisible(true);
		}		
	}

}
