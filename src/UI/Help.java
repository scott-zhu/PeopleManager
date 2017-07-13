package UI;

import javax.swing.*;
import Entity.FrameInit;
import java.awt.*;
public class Help extends JFrame{
	JFrame a = new JFrame("帮助说明");
	JPanel p = new JPanel();
	JLabel l = new JLabel();
	public Help(){
		init();
	}
	public void init(){
		FrameInit.InitFrame(a, p);
		p.add(l,BorderLayout.CENTER);
		a.setSize(new Dimension(250,150));
		l.setText("<html><body><center><h1>自己摸索</h1></center><br> </body></html>");
		a.setVisible(true);
	}

}
