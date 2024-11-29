package bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

import javafx.collections.ListChangeListener.Change;

public class PinChange extends JFrame implements ActionListener {
	String pinnumber;
	JPasswordField pin, repin;
	JButton change, back;

	PinChange(String pinnumber) {
		setLayout(null);

		this.pinnumber = pinnumber;
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);

		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setBounds(250, 300, 400, 20);
		text.setForeground(Color.white);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);

		JLabel pintext = new JLabel("New PIN:");
		pintext.setBounds(165, 340, 180, 25);
		pintext.setForeground(Color.white);
		pintext.setFont(new Font("System", Font.BOLD, 16));
		image.add(pintext);

		pin = new JPasswordField();
		pin.setFont(new Font("Raleway", Font.BOLD, 22));
		pin.setBounds(330, 340, 180, 25);
		image.add(pin);

		JLabel repintext = new JLabel("Re-Enter new PIN:");
		repintext.setBounds(165, 385, 180, 25);
		repintext.setForeground(Color.white);
		repintext.setFont(new Font("System", Font.BOLD, 16));
		image.add(repintext);

		repin = new JPasswordField();
		repin.setFont(new Font("Raleway", Font.BOLD, 22));
		repin.setBounds(330, 385, 180, 25);
		image.add(repin);

		change = new JButton("CHANGE");
		change.setBounds(355, 475, 150, 30);
		change.addActionListener(this);
		image.add(change);

		back = new JButton("BACK");
		back.setBounds(355, 510, 150, 30);
		back.addActionListener(this);
		image.add(back);

		setSize(900, 850);
		setLocation(450, 120);
		// setUndecorated(true);
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == change) {
			try {
				
				String npin = pin.getText();
				String rpin = repin.getText();
				String fpin=null;
				
				
				if (npin.equals(rpin)) {
					fpin = npin;
					
				}
				if (!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Entered pin doesn't match");
					return;
				}
				if(npin.equals("")){
					JOptionPane.showMessageDialog(null, "Please enter a new pin");
					return;
				}
				if(rpin.equals("")){
					JOptionPane.showMessageDialog(null,"Please re-enter new pin");
					return;
				}
				
				Conn conn = new Conn();
				String query1= "UPDATE bank SET pin= '"+rpin+"' where pin ='"+pinnumber+"'";
				String query2= "update login set pin= '"+rpin+"' where pin ='"+pinnumber+"'";
				String query3= "update signupthree set pinnumber= '"+fpin+"' where pinnumber ='"+pinnumber+"'";
				
				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				conn.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null,"PIN changed successfully");
				
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
				
			} catch (MysqlDataTruncation e) {
			    System.out.println("Data truncation error: " + e.getMessage());
			    e.printStackTrace();
			    JOptionPane.showMessageDialog(null, "Data truncation: Data too long for column 'pin'");
			} catch (SQLException e) {
			    System.out.println("SQL Error: " + e.getMessage());
			    e.printStackTrace();
			    JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
			} catch (Exception e) {
			    System.out.println("Error: " + e.getMessage());
			    e.printStackTrace();
			    JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage());
			}


		}else{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}

	}

	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}

}
