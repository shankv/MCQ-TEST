package  project;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;



import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class login extends JDialog implements ActionListener{
	private JTextField u;
	private JPasswordField p;
	private JButton sub;
	private JButton can;
	private JButton nu;

	public login() {
		getContentPane().setLayout(null);
		
		JLabel lblMindBl = new JLabel("BRAIN WEILD");
		lblMindBl.setFont(new Font("Papyrus", Font.BOLD, 26));
		lblMindBl.setBounds(10, 21, 273, 48);
		getContentPane().add(lblMindBl);
		
		JLabel lblUsername = new JLabel("username-");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblUsername.setBounds(61, 100, 92, 14);
		getContentPane().add(lblUsername);
		
		u = new JTextField();
		u.setBounds(160, 99, 123, 20);
		getContentPane().add(u);
		u.setColumns(10);
		
		JLabel lblPassword = new JLabel("password-");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblPassword.setBounds(61, 135, 92, 26);
		getContentPane().add(lblPassword);
		
		p = new JPasswordField();
		p.setBounds(160, 140, 123, 20);
		getContentPane().add(p);
		
		JLabel lblNewUser = new JLabel("new user?");
		lblNewUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewUser.setBounds(77, 235, 92, 14);
		getContentPane().add(lblNewUser);
		
		nu = new JButton("sign up");
		nu.setBounds(160, 233, 89, 23);
		getContentPane().add(nu);
		
		sub = new JButton("submit");
		sub.setBounds(64, 179, 89, 23);
		getContentPane().add(sub);
		
		can = new JButton("cancel");
		can.setBounds(170, 179, 89, 23);
		getContentPane().add(can);
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		sub.addActionListener(this);
		can.addActionListener(this);
		nu.addActionListener(this);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		new login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob =e.getSource();
		if(ob==nu){
			new signup();
		} 
		else	if(ob==can){
			System.exit(0);
		}
		else if(ob==sub){
			String user =u.getText();
			String pass= new String(p.getPassword());
			String s="select * from login where username=? and password=?";
			Connection c =(Connection) myconnection.connect();
		
			try{
				PreparedStatement ps = (PreparedStatement) c.prepareStatement(s);
				ps.setString(1, user);
				ps.setString(2, pass);
				ResultSet rs = ps.executeQuery();
				if(rs.next())
				{
					new mod2();
					dispose();
		
				} 
				else {
					JOptionPane.showMessageDialog(null, "invalid");
					p.setText("");
					u.setText("");
					u.requestFocusInWindow();
					}
		
			} 
			catch(SQLException se)
			{
				se.printStackTrace();
			} 
		}}} 
	
		
	

