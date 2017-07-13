package UI;

import java.sql.*;
import java.util.Vector;


import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Entity.FrameInit;
import dao.UserDaoImp;
import dao.EmployeeDaoImp;
import dao.IBaseDao;
import dao.IEmployeeDao;
import service.EmployeeServiceImp;
import service.IService;
import service.UserServiceImp;

import java.awt.event.*;
public class QueryCondition extends JFrame{
	IEmployeeDao dao;
	EmployeeServiceImp service;
	JFrame qc = new JFrame("������ѯԱ����Ϣ");
	JPanel p = new JPanel();
	JPanel p1 = new JPanel();
	JComboBox cbo = new JComboBox();
	JComboBox cbocon = new JComboBox();
	JLabel lblcon = new JLabel("��ѡ���ѯ����");
	JButton btnquery = new JButton("��ѯ");
	JTable tb = new JTable();
	JScrollPane scroll = new JScrollPane(tb);
	public QueryCondition(){
		init();
	}
	public void init(){
		FrameInit.InitFrame(qc, p);
		qc.add(scroll,BorderLayout.CENTER);
		qc.add(p1,BorderLayout.NORTH);
		p1.add(lblcon);
		
		cbo.addItem("����");
		cbo.addItem("ְ��");		
		cbo.addItem("�Ա�");		
		cbo.addItem("����");
		cbo.addItem("ѧλ");		
		cbo.addItem("����");		
		
		p1.add(cbo);
		service = new EmployeeServiceImp();
		dao = new EmployeeDaoImp();
		service.setDao(dao);
		cbo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String con = cbo.getSelectedItem().toString().trim();
				
				if(con.equals("����")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = service.getEmployeeName();
						while(rs.next()){
							cbocon.addItem(rs.getString("ename"));
						}
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					return;
				}
				else if(con.equals("ְ��")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = service.getDutyName();
						while(rs.next()){
							cbocon.addItem(rs.getString("dutyname"));
						}
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					return;
				}				
				else if(con.equals("�Ա�")){
					cbocon.removeAllItems();
					cbocon.addItem("��");
					cbocon.addItem("Ů");
					return;
				}
				
				else if(con.equals("����")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = service.getdeptno();
						while(rs.next()){
							cbocon.addItem(rs.getString("deptno"));
						}
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					return;
				}
				else if(con.equals("��Ƹʱ��")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = service.getHiredate();
						while(rs.next()){
							cbocon.addItem(rs.getString("hiredate"));
						}
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					return;
				}
				else if(con.equals("����")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = service.getNativePlace();
						while(rs.next()){
							cbocon.addItem(rs.getString("npname"));
						}
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					return;
				}
				else if(con.equals("ѧλ")){
					try{
						cbocon.removeAllItems();
						ResultSet rs = service.getDegree();
						while(rs.next()){
							cbocon.addItem(rs.getString("degree"));
						}
					}catch(Exception ex){
						System.out.println(ex.getMessage());
					}
					return;
				}			
				
			}
		});
		p1.add(cbocon);
		p1.add(btnquery);
		btnquery.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String con = cbo.getSelectedItem().toString().trim();
				String conc = cbocon.getSelectedItem().toString();
				System.out.println(conc);
				ResultSet rs = service.getConditionEmp(con, conc);
				//TableModel��һ��ʵ�֣�ʹ��һ��Vector���洢��Ԫ����ֵ���󣬹���һ���������еı�
				DefaultTableModel dt = new DefaultTableModel();
				try{
					//���ڻ�ȡResultSet�������е����ͺ����ԵĶ���
					ResultSetMetaData rsmd = rs.getMetaData();
					//�õ��е�����
					int numOfCol = rsmd.getColumnCount();
					int b = 1;
					//��TableModel�������
					while(b<=numOfCol){
						dt.addColumn(rsmd.getColumnName(b));
						b++;
					}
					tb.getTableHeader().setVisible(true);
					
					//��������е�ÿ����¼��װ��vector������
					while(rs.next()){
						Vector newRow = new Vector();
						int c = 1;
						while(c<=numOfCol){
							newRow.addElement(rs.getString(c));
							c++;
						}
						//��TableModel�������
						dt.addRow(newRow);
					}
				}catch(Exception ex){
					System.out.println(ex.getMessage());
				}
				//��Table������ģ������Ϊdt
				tb.setModel(dt);
				
			}
		});
		
		qc.setVisible(true);
		
	}
}
