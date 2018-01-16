package project;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;



public class mod7 extends JDialog implements ActionListener {
	
	private JRadioButton b,a;
	private JRadioButton c;
	private JRadioButton d;
	private JButton submit;
	private JButton quit;
	private JTextField text;
	int qid,high,low;
	Dimension dim;
    String aa,ab,ac,ad;
	String ans="";
	private JLabel lblQ;
	String a1="",b1="";
	int qq;
    Toolkit tk;
    int height,width;
	public mod7() {
		getContentPane().setForeground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(0, 0, 0));
		 
		getContentPane().setLayout(null);
		dim = tk.getDefaultToolkit().getScreenSize();
		height = (int)dim.getHeight();
		width=(int)dim.getWidth();
		setSize(dim);
		
		a = new JRadioButton("hvda");
		a.setBackground(new Color(0, 0, 0));
		a.setFont(new Font("Tahoma", Font.PLAIN, 17));
		a.setForeground(Color.CYAN);
		a.setBounds(352, 422, 353, 23);
		getContentPane().add(a);
		
		b = new JRadioButton("");
		b.setBackground(new Color(0, 0, 0));
		b.setFont(new Font("Tahoma", Font.PLAIN, 17));
		b.setForeground(Color.CYAN);
		b.setBounds(763, 422, 371, 23);
		getContentPane().add(b);
		
		c = new JRadioButton("New radio button");
		c.setBackground(new Color(0, 0, 0));
		c.setFont(new Font("Tahoma", Font.PLAIN, 17));
		c.setForeground(new Color(0, 255, 255));
		c.setBounds(352, 495, 353, 23);
		getContentPane().add(c);
		
		d = new JRadioButton("New radio button");
		d.setBackground(new Color(0, 0, 0));
		d.setFont(new Font("Tahoma", Font.PLAIN, 17));
		d.setForeground(new Color(0, 255, 255));
		d.setBounds(763, 496, 371, 23);
		getContentPane().add(d);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(a);
		bg.add(b);
		bg.add(c);
		bg.add(d);
		
		submit = new JButton("submit");
		submit.setBounds(513, 577, 89, 38);
		getContentPane().add(submit);
		
		quit = new JButton("quit");
		quit.setBounds(737, 577, 89, 38);
		getContentPane().add(quit);
		
		lblQ = new JLabel("1");
		lblQ.setBackground(new Color(0, 0, 0));
		lblQ.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lblQ.setBounds(51, 165, 30, 25);
		getContentPane().add(lblQ);
		
		JLabel lblA = new JLabel("A:");
		lblA.setForeground(Color.CYAN);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblA.setBounds(303, 422, 18, 23);
		getContentPane().add(lblA);
		
		JLabel lblB = new JLabel("B:");
		lblB.setForeground(Color.CYAN);
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblB.setBounds(711, 422, 18, 23);
		getContentPane().add(lblB);
		
		JLabel lblC = new JLabel("C:");
		lblC.setForeground(new Color(0, 255, 255));
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblC.setBounds(303, 492, 18, 23);
		getContentPane().add(lblC);
		
		JLabel lblD = new JLabel("D:");
		lblD.setForeground(new Color(0, 255, 255));
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblD.setBounds(711, 492, 30, 23);
		getContentPane().add(lblD);
		
		text = new JTextField();
		text.setSelectedTextColor(new Color(0, 0, 0));
		text.setDisabledTextColor(new Color(0, 0, 0));
		text.setFont(new Font("Tahoma", Font.PLAIN, 17));
		text.setForeground(Color.CYAN);
		text.setBackground(new Color(0, 0, 0));
		text.setBounds(303, 323, 799, 38);
		getContentPane().add(text);
		text.setColumns(10);
		
        // setSize(1000,1000);
         ImageIcon ii = new ImageIcon(getClass().getResource("images/aa.png"));
 		JLabel lab = new JLabel(ii);

 		lab.setBounds(428,11,500,312);
 		getContentPane().add(lab);
 		
 		JLabel lblNewLabel = new JLabel("QUESTION-");
 		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
 		lblNewLabel.setForeground(new Color(255, 255, 255));
 		lblNewLabel.setBounds(195, 334, 99, 27);
 		getContentPane().add(lblNewLabel);
         
         
          qq=0;
			
			Random r = new Random();
			while(true){
				qq=r.nextInt(19);
				if(qq>16)
					break;
			}
		fillInfo();
	
		
		setVisible(true);
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		submit.addActionListener(this);
		quit.addActionListener(this);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new mod7();

	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==quit){
			dispose();
		}
		if(e.getSource()== submit)
		{
			if(a.isSelected())
			{ans= aa;}
			if(b.isSelected())
			{ans= ab;}
			if(c.isSelected())
			{ans= ac;}
			if(d.isSelected())
			{ans= ad;}
			
		
		String s ="update ques1 set userans=? where qid=?";
		try {
			Connection con= (Connection) myconnection.connect();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(s);
			ps.setString(1, ans);
			ps.setInt(2, qq);
		
			ps.executeUpdate();
		//	JOptionPane.showMessageDialog(null, "info added");
			
			check();
         
		}
		
		catch(SQLException se)
		{
			se.printStackTrace(); } }
	}


void fillInfo()
{
	Connection cd =(Connection) myconnection.connect() ;
			String s="select * from ques1 where qid=?";
			try
			{
				
			PreparedStatement ps =(PreparedStatement) cd.prepareStatement(s);
//			 qq=Integer.parseInt(lblQ.getText());

			ps.setInt(1, qq);
			lblQ.setText(Integer.toString(qq));
			
			ResultSet rs=ps.executeQuery();
				while( rs.next())
						{
						
						 

						text.setText(rs.getString("quesname"));
						a.setText(rs.getString("opta"));
						b.setText(rs.getString("optb"));
						c.setText(rs.getString("optc"));
						d.setText(rs.getString("optd"));
					    break;
			          
						}
				
			aa=	rs.getString("opta");
			ab=rs.getString("optb");
			ac=rs.getString("optc");
		 ad =rs.getString("optd");
						}
			
catch(SQLException se)
{
	se.printStackTrace(); }
		
}
 
void check()
{
	Connection cd = (Connection) myconnection.connect() ;
	String s="select userans ,crrtans from ques1 where qid=?";
	try
	{
		
	PreparedStatement ps = cd.prepareStatement(s);
	ps.setInt(1,qq);
	ResultSet rs= ps.executeQuery();
	
	
	while(rs.next()){a1=rs.getString("crrtans");
	b1=rs.getString("userans");
	break;}
	if(a1.equals(b1))
	{
		JOptionPane.showMessageDialog(null, "wow! correct ans");
     new mod8();
     dispose();
	}
	else 			JOptionPane.showMessageDialog(null, "sorry try again");
	                
	
}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
}

}
