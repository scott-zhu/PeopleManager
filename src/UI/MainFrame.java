package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class MainFrame extends JFrame{	
	public MainFrame() {
		getContentPane().setBackground(SystemColor.textHighlight);		
		getContentPane().setBounds(new Rectangle(400, 400, 400, 400));
		getContentPane().setLayout(null);		
	}	
	JFrame mainFrame = new JFrame("职工档案管理系统");	
	JPanel p = new JPanel();
	JLabel label = new JLabel();	
	JMenuBar jmb = new JMenuBar();
	JMenu jm1 = new JMenu();
	JMenu jm2 = new JMenu();
	JMenu jm3 = new JMenu();	
	JMenu jm5 = new JMenu();
	JMenu jm6 = new JMenu();
	JMenuItem jmi = new JMenuItem();
	JMenuItem jmi1 = new JMenuItem();
	JMenuItem jmi2 = new JMenuItem();
	JMenuItem jmi3 = new JMenuItem();
	JMenuItem jmi4 = new JMenuItem();
	JMenuItem jmi5 = new JMenuItem();
	JMenuItem jmi6 = new JMenuItem();
	JMenuItem jmi7 = new JMenuItem();
	JMenuItem jmi8 = new JMenuItem();
	JMenuItem jmi9 = new JMenuItem();
	JMenuItem jmi10 = new JMenuItem();
	JMenuItem jmi11 = new JMenuItem();
	JMenuItem jmi12 = new JMenuItem();	
	
	public void init(){
		//设置mainFrame的panel，关闭方式，大小		
		mainFrame.getContentPane().add(p,BorderLayout.CENTER);		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setSize(screenSize.width-400,screenSize.height-200);		
		//设置panel的Layout
		p.setLayout(new BorderLayout());		
		p.add(label, BorderLayout.CENTER);		
		jm1.setText("信息查询");
		jmi.setText("查询全部员工信息");
		jmi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				QueryAllEmployee q = new QueryAllEmployee();
			}
		});
		jmi1.setText("条件查询");
		jmi1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				QueryCondition qc = new QueryCondition();
			}
		});
		jm1.add(jmi);
		jm1.add(jmi1);		
		jm2.setText("员工信息操作");
		jmi7.setText("添加员工信息");
		jmi2.setText("修改员工信息");
		jmi3.setText("删除员工信息");
		jm2.add(jmi7);
		jm2.add(jmi2);
		jm2.add(jmi3);
		jmi2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				UpdateEmpInfo uei = new UpdateEmpInfo();
			}
		});
		jmi3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				DeleteEmployee de = new DeleteEmployee();
			}
		});
		jmi7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddEmployee ae = new AddEmployee();
			}
		});
		jm5.setText("基本信息管理");
		jmi8.setText("学历添加");
		jmi8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BasicInfoAdd bif = new BasicInfoAdd();
			}
		});
		jmi9.setText("职务添加");
		jmi9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddDuty ad = new AddDuty();
			}
		});
		jmi10.setText("部门添加");
		jmi10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Adddept ad = new Adddept();
			}
		});
		jmi11.setText("民族添加");
		jmi11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Addnation ad = new Addnation();
			}
		});
		jmi12.setText("籍贯添加");
		jmi12.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Addnp ad = new Addnp();
			}
		});		
		
		jm5.add(jmi8);
		jm5.add(jmi9);
		jm5.add(jmi10);
		jm5.add(jmi11);
		jm5.add(jmi12);		
		jm3.setText("系统");
		jmi5.setText("有关本系统");
		jmi4.setText("退出系统");
		jm3.add(jmi5);
		jm3.add(jmi4);
		jmi4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int result = JOptionPane.showConfirmDialog(mainFrame, "您确定离开本系统吗？", "友情提示", JOptionPane.OK_CANCEL_OPTION);
				if(result==JOptionPane.OK_OPTION){
					System.exit(0);
				}else{					
				}
			}
		});
		jmi5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				About a = new About();
			}
		});		
		jm6.setText("帮助");
		jmi6.setText("帮助说明");		
		jm6.add(jmi6);
		
		jmi6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Help h = new Help();
			}
		});	
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm5);
		jmb.add(jm3);		
		jmb.add(jm6);	
		mainFrame.setJMenuBar(jmb);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);		
	}	
	public static void main(String[] args) {		
		login u = new login();
	}
}
