package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.ResultSet;


import javax.swing.*;

import Entity.FrameInit;
import Entity.TbEmployeeInfo;
import dao.UserDaoImp;
import dao.EmployeeDaoImp;
import dao.IBaseDao;
import dao.IEmployeeDao;
import service.EmployeeServiceImp;
import service.IService;
import service.UserServiceImp;


public class UpdateEmpInfo extends JFrame{
	IEmployeeDao dao;
	EmployeeServiceImp service;
	
	JFrame uei = new JFrame("修改员工数据");
	JPanel p = new JPanel();
	JTextField ename;
	JComboBox sex = new JComboBox();
	JTextField birthday = new JTextField(10);
	JComboBox npname = new JComboBox();
	JComboBox nation = new JComboBox();
	JTextField degree = new JTextField(10);
	JLabel ledu = new JLabel("学历");
	JTextField school = new JTextField(10);
	JLabel lschool = new JLabel("毕业院校:");
	JLabel ldn = new JLabel("职务:");
	JComboBox dutyname =new JComboBox();
	JLabel lidd = new JLabel("入本单位时间:");
	JTextField hiredate = new JTextField(10);
	JLabel lsjphone = new JLabel("手机:");
	JTextField phone = new JTextField(10);
	JLabel lidcard = new JLabel("身份证号:");
	JTextField idcard = new JTextField(10);
	JLabel lden = new JLabel("\u90E8\u95E8\u7F16\u53F7:");
	JComboBox deptno = new JComboBox();
	JButton btnupdate = new JButton("修改");
	public UpdateEmpInfo(){
		init();
	}
	public void init(){
		FrameInit.InitFrame(uei, p);
        //添加打开窗口时的事件监听器，初始化下拉列表
		uei.addWindowListener(new WindowAdapter(){
			public void windowOpened(WindowEvent e){
				service = new EmployeeServiceImp();
				dao = new EmployeeDaoImp();
				service.setDao(dao);
				ResultSet rs1 = service.getNativePlace();				
				ResultSet rs3 = service.getNation();
				ResultSet rs4 = service.getDutyName();				
				ResultSet rs6 = service.getdeptno();	
				try{
					while(rs1.next()){
						npname.addItem(rs1.getString("npname"));
					}
					
					while(rs3.next()){
						nation.addItem(rs3.getString("nation"));
					}
					while(rs4.next()){
						dutyname.addItem(rs4.getString("dutyname"));
					}
					
					while(rs6.next()){
						deptno.addItem(rs6.getString("deptno"));
					}
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
			}
		});
		uei.setSize(new Dimension(900,400));
		p.setLayout(null);
		JLabel lblename = new JLabel("员工姓名:");
		lblename.setBounds(1, 4, 113, 34);
		p.add(lblename);
		ename = new JTextField(10);
		ename.setBounds(141, 4, 140, 34);
		p.add(ename);
		JLabel lsex = new JLabel("性别:");
		lsex.setBounds(1, 48, 95, 23);
		p.add(lsex);
		sex.setBounds(141, 36, 140, 34);
		sex.addItem("男");
		sex.addItem("女");
		p.add(sex);
		JLabel lsr = new JLabel("出生日期:");
		lsr.setBounds(1, 80, 120, 34);
		p.add(lsr);
		birthday.setBounds(141, 81, 140, 34);
		p.add(birthday);
		JLabel ljg = new JLabel("籍贯");
		ljg.setBounds(1, 113, 113, 34);
		p.add(ljg);
		npname.setBounds(141, 113, 140, 34);
		p.add(npname);
		JLabel lmz = new JLabel("民族");
		lmz.setBounds(1, 146, 113, 34);
		p.add(lmz);
		nation.setBounds(141, 146, 140, 34);
		p.add(nation);
		ledu.setBounds(1, 174, 113, 34);
		p.add(ledu);
		degree.setBounds(141, 175, 140, 34);
		p.add(degree);
		lschool.setBounds(343, 185, 65, 23);
		
		p.add(lschool);
		school.setBounds(446, 190, 140, 23);
		p.add(school);
		ldn.setBounds(343, 146, 65, 34);
		p.add(ldn);
		dutyname.setBounds(446, 146, 140, 34);
		p.add(dutyname);
		lidd.setBounds(343, 113, 83, 34);
		p.add(lidd);
		hiredate.setBounds(446, 119, 140, 23);
		p.add(hiredate);
		lsjphone.setBounds(343, 80, 65, 34);
		p.add(lsjphone);
		phone.setBounds(446, 81, 140, 23);
		p.add(phone);
		lidcard.setBounds(343, 48, 83, 23);
		p.add(lidcard);
		idcard.setBounds(447, 48, 140, 23);
		p.add(idcard);
		lden.setBounds(343, 4, 83, 34);
		p.add(lden);
		deptno.setBounds(447, 4, 140, 34);
		p.add(deptno);
		JLabel label = new JLabel();
		label.setBounds(1, 276, 140, 34);
		p.add(label);
		JLabel label_1 = new JLabel();
		label_1.setBounds(141, 276, 140, 34);
		p.add(label_1);
		btnupdate.setBounds(446, 252, 140, 34);
		
		p.add(btnupdate);
		btnupdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(ename.equals("") || dutyname.equals("") || idcard.equals("") ||
						deptno.equals("") || idcard.equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整的员工信息！","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}else{
					TbEmployeeInfo info = new TbEmployeeInfo();
					info.setEname(ename.getText().trim());					
					info.setSex(sex.getSelectedItem().toString().trim());
					info.setBirthday(birthday.getText().trim());
					info.setNpname(npname.getSelectedItem().toString().trim());
					info.setNation(nation.getSelectedItem().toString().trim());
					
					info.setDegree(degree.getText().trim());
					
					info.setSchool(school.getText().trim());
					
					info.setDutyname(dutyname.getSelectedItem().toString().trim());
					
					info.setHiredate(hiredate.getText().trim());
					
					info.setPhone(phone.getText());
					
					info.setIdcard(idcard.getText().trim());
					info.setDeptno(Integer.parseInt(deptno.getSelectedItem().toString().trim()));
					service = new EmployeeServiceImp();
					dao = new EmployeeDaoImp();
					service.setDao(dao);
					boolean flag = service.updateSpeEmployee(info);
					System.out.println(flag);
					if(flag){
						JOptionPane.showMessageDialog(null, "修改员工成功!","友情提示",JOptionPane.INFORMATION_MESSAGE);
						return;
					}else{
						JOptionPane.showMessageDialog(null, "修改员工失败!","发生错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
		});
		uei.setVisible(true);
	}

}
