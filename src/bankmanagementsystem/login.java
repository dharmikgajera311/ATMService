package bankmanagementsystem;
	
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {
	JButton login, clear, signup;
	JTextField cardTextField;
	JPasswordField pinTextField;

	login() {
		setTitle("AUTOMATED TELLER MACHINE");
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(200, 10, 100, 100);
		add(label);

		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD, 50));
		text.setBounds(350, 40, 450, 40);
		add(text);

		JLabel cardno = new JLabel("Card No: ");
		cardno.setFont(new Font("Raleway", Font.BOLD, 35));
		cardno.setBounds(250, 150, 230, 30);
		add(cardno);

		cardTextField = new JTextField();
		cardTextField.setBounds(450, 150, 230, 32);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 18));
		add(cardTextField);

		JLabel pin = new JLabel("PIN: ");
		pin.setFont(new Font("Raleway", Font.BOLD, 35));
		pin.setBounds(250, 220, 230, 30);
		add(pin);

		pinTextField = new JPasswordField();
		pinTextField.setBounds(450, 220, 230, 32);
		pinTextField.setFont(new Font("Arial", Font.BOLD, 18));
		add(pinTextField);

		login = new JButton("SIGN IN");
		login.setBounds(250, 300, 200, 40);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);

		clear = new JButton("CLEAR");
		clear.setBounds(480, 300, 200, 40);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);

		signup = new JButton("SIGN UP");
		signup.setBounds(250, 375, 430, 40);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);

		getContentPane().setBackground(Color.WHITE);

		setSize(1000, 520);
		setVisible(true);
		setLocation(500, 250);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		} else if (ae.getSource() == login) {
			Conn conn = new Conn();
			Connection connection = conn.getConnection();
			String cardnumber = cardTextField.getText();
			String pinnumber = new String(pinTextField.getPassword()); 
			String query = "SELECT * FROM login WHERE cardnumber = ? AND pin = ?";
			try {
				PreparedStatement pstmt = connection.prepareStatement(query);
				pstmt.setString(1, cardnumber);
				pstmt.setString(2, pinnumber);
				ResultSet rs = pstmt.executeQuery();
				if (cardnumber.equals("") || pinnumber.equals("")) {
					JOptionPane.showMessageDialog(null, "please enter cardnumber or pin");
				} else {
					if (rs.next()) {
						setVisible(false);
						new Transactions(pinnumber).setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect card Number or Pin!");
					}
				}
				rs.close();
				pstmt.close();
				connection.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} else if (ae.getSource() == signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new login();
	}
}
