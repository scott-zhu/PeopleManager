package UI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import Entity.TbEmployeeInfo;
public class AddEmployee extends JFrame{
	IEmployeeDao dao;
	EmployeeServiceImp service;
	JFrame ae = new JFrame("员工信息添加");
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
	JButton btnadd = new JButton("添加");
	JButton btnreset = new JButton("重置");
	public AddEmployee(){
		FrameInit.InitFrame(ae, p);
		//添加打开窗口时的事件监听器，初始化下拉列表
		ae.addWindowListener(new WindowAdapter(){
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
		ae.setSize(new Dimension(900,400));
		p.setSize(new Dimension(586, 473));
		p.setLayout(null);
		JLabel lblename = new JLabel("员工姓名:");
		lblename.setBounds(5, 8, 72, 18);
		p.add(lblename);
		ename = new JTextField(10);
		ename.setBounds(87, 7, 107, 21);
		p.add(ename);
		JLabel lsex = new JLabel("性别:");
		lsex.setBounds(5, 36, 54, 18);
		p.add(lsex);
		sex.setBounds(87, 38, 66, 21);
		sex.addItem("男");
		sex.addItem("女");
		p.add(sex);
		JLabel lsr = new JLabel("出生日期:");
		lsr.setBounds(5, 58, 71, 24);
		p.add(lsr);
		birthday.setBounds(87, 60, 107, 21);
		p.add(birthday);
		JLabel ljg = new JLabel("籍贯");
		ljg.setBounds(5, 92, 60, 21);
		p.add(ljg);
		npname.setBounds(87, 91, 117, 21);
		p.add(npname);
		JLabel lmz = new JLabel("民族");
		lmz.setBounds(5, 123, 54, 27);
		p.add(lmz);
		nation.setBounds(87, 126, 98, 21);
		p.add(nation);
		ledu.setBounds(5, 157, 54, 15);
		p.add(ledu);
		degree.setBounds(87, 154, 107, 21);
		p.add(degree);
		lschool.setBounds(254, 154, 72, 18);
		p.add(lschool);
		school.setBounds(342, 154, 107, 21);
		p.add(school);
		ldn.setBounds(254, 123, 54, 18);
		p.add(ldn);
		dutyname.setBounds(332, 122, 117, 21);
		p.add(dutyname);
		lidd.setBounds(244, 95, 98, 15);
		p.add(lidd);
		hiredate.setBounds(352, 92, 97, 21);
		p.add(hiredate);
		lsjphone.setBounds(258, 63, 50, 15);
		p.add(lsjphone);
		phone.setBounds(325, 60, 107, 21);
		p.add(phone);
		lidcard.setBounds(248, 38, 78, 15);
		p.add(lidcard);
		idcard.setBounds(325, 35, 107, 21);
		p.add(idcard);
		lden.setBounds(248, 10, 78, 15);
		p.add(lden);
		deptno.setBounds(325, 7, 107, 21);
		p.add(deptno);
		JLabel label = new JLabel();
		label.setBounds(101, 94, 0, 0);
		p.add(label);
		JLabel label_1 = new JLabel();
		label_1.setBounds(106, 94, 0, 0);
		p.add(label_1);
		btnadd.setBounds(285, 227, 71, 23);
		p.add(btnadd);
		btnreset.setBounds(377, 227, 78, 23);
		p.add(btnreset);
		//添加按钮事件监听程序
		btnadd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(ename.equals("") || dutyname.equals("") || idcard.equals("") ||
						deptno.equals("") || idcard.equals("")){
					JOptionPane.showMessageDialog(null, "请输入完整的员工信息！","警告",JOptionPane.WARNING_MESSAGE);
					return;
				}else{
					//封装到人员实体
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
					boolean flag = service.addEmployee(info);
					if(flag){
						JOptionPane.showMessageDialog(null, "添加员工成功!","友情提示",JOptionPane.INFORMATION_MESSAGE);
						return;
					}else{
						JOptionPane.showMessageDialog(null, "添加员工失败!","发生错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
		});
		//重置按钮事件监听程序
		btnreset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ename.setText("");
				birthday.setText("");
				degree.setText("");
				school.setText("");
				hiredate.setText("");
				phone.setText("");
				idcard.setText("");				
			}
		});
		ae.setVisible(true);
	}
	
}
