package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class signup extends JDialog implements ActionListener {

	private JButton login;
	private JTextField cp;
	private JPasswordField p;
	private JTextField u;

	public signup() {
		
		getContentPane().setLayout(null);// TODO Auto-generated constructor stub
		
		JLabel lblMindBlogger = new JLabel("BRAIN WEILD");
		lblMindBlogger.setFont(new Font("Papyrus", Font.BOLD, 26));
		lblMindBlogger.setBounds(10, 11, 281, 32);
		getContentPane().add(lblMindBlogger);
		
		JLabel lblWelcomeToSign = new JLabel("welcome to sign up-");
		lblWelcomeToSign.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblWelcomeToSign.setBounds(39, 73, 201, 20);
		getContentPane().add(lblWelcomeToSign);
		
		JLabel lblUsername = new JLabel("username-");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(39, 128, 82, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password-");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(39, 162, 82, 20);
		getContentPane().add(lblPassword);
		
		u = new JTextField();
		u.setColumns(10);
		u.setBounds(127, 127, 112, 20);
		getContentPane().add(u);
		
		login = new JButton("login");
		login.setBounds(75, 233, 89, 23);
		getContentPane().add(login);
		
		JLabel lblConfirmPassword = new JLabel("confirm password-");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(10, 193, 124, 14);
		getContentPane().add(lblConfirmPassword);
		
		cp = new JTextField();
		cp.setBounds(127, 195, 113, 20);
		getContentPane().add(cp);
		cp.setColumns(10);
		
		p = new JPasswordField();
		p.setBounds(127, 164, 113, 20);
		getContentPane().add(p);
		setSize(500,500);
		setVisible(true);
		login.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
new signup();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		 String s1 =cp. getText();
         String s2=u.getText();
         String s3 = p.getText();
         System.out.print(s1);
         System.out.print(s3);
        
		if(ob==login)
		{
			if(s1.equals(s3))
			{	try {Connection c =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/shashank","root","shank");
				String s = "insert into login values(?,?)";
				PreparedStatement ps =(PreparedStatement) c.prepareStatement(s);
                
				ps.setString(1,s2);
				ps.setString(2, s1);
				int y= ps.executeUpdate();
				System.out.println("affected"+y);
        new login();
		JOptionPane.showMessageDialog(null, "sucessfully signup! now please login");
		    } 
			catch(SQLException se)
			{
			se.printStackTrace();
			} }
			else
				{JOptionPane.showMessageDialog(null, "password, confirm password are not same");
			p.setText("");
			u.setText("");
			cp.setText("");
			u.requestFocusInWindow();
			}
		}
		
	}
}
