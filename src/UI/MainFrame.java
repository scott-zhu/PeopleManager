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
	JFrame mainFrame = new JFrame("ְ����������ϵͳ");	
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
		//����mainFrame��panel���رշ�ʽ����С		
		mainFrame.getContentPane().add(p,BorderLayout.CENTER);		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setSize(screenSize.width-400,screenSize.height-200);		
		//����panel��Layout
		p.setLayout(new BorderLayout());		
		p.add(label, BorderLayout.CENTER);		
		jm1.setText("��Ϣ��ѯ");
		jmi.setText("��ѯȫ��Ա����Ϣ");
		jmi.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				QueryAllEmployee q = new QueryAllEmployee();
			}
		});
		jmi1.setText("������ѯ");
		jmi1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				QueryCondition qc = new QueryCondition();
			}
		});
		jm1.add(jmi);
		jm1.add(jmi1);		
		jm2.setText("Ա����Ϣ����");
		jmi7.setText("���Ա����Ϣ");
		jmi2.setText("�޸�Ա����Ϣ");
		jmi3.setText("ɾ��Ա����Ϣ");
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
		jm5.setText("������Ϣ����");
		jmi8.setText("ѧ�����");
		jmi8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				BasicInfoAdd bif = new BasicInfoAdd();
			}
		});
		jmi9.setText("ְ�����");
		jmi9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddDuty ad = new AddDuty();
			}
		});
		jmi10.setText("�������");
		jmi10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Adddept ad = new Adddept();
			}
		});
		jmi11.setText("�������");
		jmi11.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Addnation ad = new Addnation();
			}
		});
		jmi12.setText("�������");
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
		jm3.setText("ϵͳ");
		jmi5.setText("�йر�ϵͳ");
		jmi4.setText("�˳�ϵͳ");
		jm3.add(jmi5);
		jm3.add(jmi4);
		jmi4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int result = JOptionPane.showConfirmDialog(mainFrame, "��ȷ���뿪��ϵͳ��", "������ʾ", JOptionPane.OK_CANCEL_OPTION);
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
		jm6.setText("����");
		jmi6.setText("����˵��");		
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
