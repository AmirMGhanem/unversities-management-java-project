package University;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register  implements ActionListener {
	protected JLabel LadminLogin;
	protected JTextField TFadminLogin;
	protected JLabel LadminPassword;
	protected JPasswordField TFadminPassword;
	protected JButton Bregister;
	protected JButton Blogin;
	protected UnivGUI p;
	protected JFrame f = new JFrame();
	private  signInfo SI;
	public Register() {
		 p = new UnivGUI();
		f.setLayout(new GridLayout(0, 2));
		LadminLogin = new JLabel("New UserName :");
		TFadminLogin = new JTextField(10);
		LadminPassword = new JLabel("New Password :");
		TFadminPassword = new JPasswordField();
		Bregister = new JButton("Register");
		Blogin = new JButton("Login");
		f.add(LadminLogin);
		f.add(TFadminLogin);
		f.add(LadminPassword);
		f.add(TFadminPassword);
		f.add(Bregister);
		f.add(Blogin);
		Blogin.addActionListener(this);
		Bregister.addActionListener(this);

		f.setSize(300, 300);
		f.setVisible(true);
	}

	private void Conn() {

		for (int i = 0; i < p.ALuniv.size(); i++) {
			if (TFadminLogin.getText().equals(p.ALuniv.get(i).getManager().getId())
					&& (p.ALuniv.get(i).getId() == Integer.parseInt(TFadminPassword.getText()))) {

				 SI = new signInfo(TFadminLogin.getText(), TFadminPassword.getText());
				p.ALuniv.get(i).setSi(SI);
				p.ALsi.add(SI);
				System.out.println("username : " + SI.getUsername() + " - password : " + SI.getPassword());
			}
		}

	}

	private void insertDB()
	{					Connection myConn=null;
	try {
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/univ?serverTimezone=UTC","root","");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

		for (int i = 0; i < p.ALuniv.size(); i++) {
			if (TFadminLogin.getText().equals(p.ALuniv.get(i).getManager().getId())
					&& (p.ALuniv.get(i).getId() == Integer.parseInt(TFadminPassword.getText()))) {

				try {
					
					String sql="INSERT INTO signinfo VALUES('"+p.ALuniv.get(i).getSi().getUsername()+"',"+p.ALuniv.get(i).getSi().getPassword()+")";
					
					Statement myStmt = myConn.createStatement();
					myStmt.executeUpdate(sql);
				} catch (SQLException e) {
				
				e.printStackTrace();
			}		
			}
		}
	}
	
	public static void main(String[] args) {

		Register r = new Register();

		r.f.show();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(Bregister)) {
			Conn();
			insertDB();
		}

		if (e.getSource().equals(Blogin)) {

			 p.show();
		}

	}
}
