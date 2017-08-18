package project;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import java.awt.Color;

public class mod1 extends JFrame implements ActionListener
{
	private JButton start;
	Dimension dim;
	Toolkit tk;
	int height, width;
	public mod1() 
	{
		getContentPane().setBackground(Color.BLACK);
		dim = tk.getDefaultToolkit().getScreenSize();
		height = (int)dim.getHeight();
		width=(int)dim.getWidth();
		getContentPane().setLayout(null);
		setSize(dim);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setForeground(new Color(255, 255, 0));
		lblWelcome.setFont(new Font("Brush Script MT", Font.BOLD | Font.ITALIC, 53));
		lblWelcome.setBounds(533, 11, 293, 86);
		getContentPane().add(lblWelcome);
		
		start = new JButton("Start");
		start.setForeground(new Color(139, 0, 0));
		start.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 11));
		start.setBounds(627, 689, 89, 23);
		getContentPane().add(start);
		
		JLabel lblWayToMind = new JLabel("Click to play the game..... ");
		lblWayToMind.setForeground(new Color(255, 255, 0));
		lblWayToMind.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
		lblWayToMind.setBounds(591, 654, 197, 23);
		getContentPane().add(lblWayToMind);
	
	//	setSize(900,1000);
		setResizable(false);
		ImageIcon ii = new ImageIcon(getClass().getResource("images/aa.png"));
		JLabel lab = new JLabel(ii);

		lab.setBounds(0,0,width,height);
		getContentPane().add(lab);
		
		JLabel lblTo = new JLabel("TO");
		lblTo.setForeground(new Color(255, 255, 0));
		lblTo.setFont(new Font("Brush Script MT", Font.BOLD | Font.ITALIC, 52));
		lblTo.setBounds(627, 69, 89, 86);
		getContentPane().add(lblTo);
		
		setVisible(true);
		start.addActionListener(this); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new mod1();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob =e.getSource();
		if( ob==start){
			new login();
		   dispose();
		}
		
		
	}
}
