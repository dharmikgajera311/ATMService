package bankmanagementsystem;

import javax.swing.*;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
	JRadioButton r1, r2, r3, r4;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	JButton submit, cancle;
	String formno;

	public SignupThree(String formno) {
		this.formno = formno;
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

		JLabel additionalDetails = new JLabel("Page 3: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 28));
		additionalDetails.setBounds(240, 50, 600, 40);
		add(additionalDetails);

		JLabel type = new JLabel("Account Type:");
		type.setFont(new Font("Raleway", Font.BOLD, 24));
		type.setBounds(80, 140, 200, 30);
		add(type);

		r1 = new JRadioButton("Saving Account");
		r1.setFont(new Font("Raleway", Font.BOLD, 18));
		r1.setBounds(80, 180, 250, 30);
		r1.setBackground(Color.WHITE);
		add(r1);

		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Raleway", Font.BOLD, 18));
		r2.setBounds(330, 180, 300, 30);
		r2.setBackground(Color.WHITE);
		add(r2);

		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Raleway", Font.BOLD, 18));
		r3.setBounds(80, 235, 200, 30);
		r3.setBackground(Color.WHITE);
		add(r3);

		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Raleway", Font.BOLD, 18));
		r4.setBounds(330, 235, 200, 30);
		r4.setBackground(Color.WHITE);
		add(r4);

		ButtonGroup groupacc = new ButtonGroup();
		groupacc.add(r1);
		groupacc.add(r2);
		groupacc.add(r3);
		groupacc.add(r4);

		JLabel card = new JLabel("Card Number: ");
		card.setFont(new Font("Raleway", Font.BOLD, 24));
		card.setBounds(80, 280, 170, 30);
		add(card);

		JLabel number = new JLabel("XXXX-XXXX-XXXX-1602");
		number.setFont(new Font("Raleway", Font.BOLD, 24));
		number.setBounds(300, 280, 400, 30);
		add(number);

		JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
		cardDetail.setFont(new Font("Raleway", Font.BOLD, 12));
		cardDetail.setBounds(80, 310, 170, 20);
		add(cardDetail);

		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway", Font.BOLD, 24));
		pin.setBounds(80, 350, 170, 30);
		add(pin);

		JLabel pnumber = new JLabel("XXXX	");
		pnumber.setFont(new Font("Raleway", Font.BOLD, 24));
		pnumber.setBounds(300, 350, 400, 30);
		add(pnumber);

		JLabel pinDetail = new JLabel("Your 4 Digit Password");
		pinDetail.setFont(new Font("Raleway", Font.BOLD, 12));
		pinDetail.setBounds(80, 380, 170, 20);
		add(pinDetail);

		JLabel services = new JLabel("Services Required: ");
		services.setFont(new Font("Raleway", Font.BOLD, 24));
		services.setBounds(80, 420, 240, 30);
		add(services);

		c1 = new JCheckBox("ATM Card");
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway", Font.BOLD, 16));
		c1.setBounds(80, 470, 250, 30);
		add(c1);

		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway", Font.BOLD, 16));
		c2.setBounds(330, 470, 300, 30);
		add(c2);

		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway", Font.BOLD, 16));
		c3.setBounds(80, 520, 200, 30);
		add(c3);

		c4 = new JCheckBox("EMAIL & SMS Alerts");
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway", Font.BOLD, 16));
		c4.setBounds(330, 520, 200, 30);
		add(c4);

		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.WHITE);
		c5.setFont(new Font("Raleway", Font.BOLD, 16));
		c5.setBounds(80, 570, 200, 30);
		add(c5);

		c6 = new JCheckBox("E-Statement");
		c6.setBackground(Color.WHITE);
		c6.setFont(new Font("Raleway", Font.BOLD, 16));
		c6.setBounds(330, 570, 200, 30);
		add(c6);

		c7 = new JCheckBox(
				"I here by declares that the above entered  details are correct to the best of my knowledge.");
		c7.setBackground(Color.WHITE);
		c7.setFont(new Font("Raleway", Font.BOLD, 16));
		c7.setBounds(80, 640, 2000, 20);
		add(c7);

		cancle = new JButton("Cancle");
		cancle.setBackground(Color.BLACK);
		cancle.setForeground(Color.WHITE);
		cancle.setFont(new Font("Raleway", Font.BOLD, 16));
		cancle.addActionListener(this);
		cancle.setBounds(270, 710, 100, 30);
		add(cancle);

		submit = new JButton("Submit");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Raleway", Font.BOLD, 16));
		submit.addActionListener(this);
		submit.setBounds(410, 710, 100, 30);
		add(submit);

		getContentPane().setBackground(Color.WHITE);
		setSize(850, 850);
		setLocation(500, 50);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SignupThree("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {
			String accountType = null;
			if (r1.isSelected()) {
				accountType = "Saving Account";
			} else if (r2.isSelected()) {
				accountType = "Fixed Deposit Account";
			} else if (r3.isSelected()) {
				accountType = "Current Account";
			} else if (r4.isSelected()) {
				accountType = "Recurring Deposite Account";
			}

			Random random = new Random();
			String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 504000000000L);
			String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
			String facility = "";
			if (c1.isSelected()) {
				facility = facility + "ATM Card";
			}
			if (c2.isSelected()) {
				if (c1.isSelected()) {
					facility = facility + ", Internet Banking";
				} else {
					facility = facility + "Internet Banking";
				}
			}
			if (c3.isSelected()) {
				if (c1.isSelected() || c2.isSelected()) {
					facility = facility + ", Mobile Banking";
				} else {
					facility = facility + "Mobile Banking";
				}

			}
			if (c4.isSelected()) {
				if (c1.isSelected() || c2.isSelected() || c3.isSelected()) {
					facility = facility + ", EMAIL & SMS Alerts";
				} else {
					facility = facility + "EMAIL & SMS Alerts";
				}

			}
			if (c5.isSelected()) {
				if (c1.isSelected() || c2.isSelected() || c3.isSelected()|| c4.isSelected()) {
					facility = facility + ", Cheque Book";
				} else {
					facility = facility + "Cheque Book";
				}
				
			}
			if (c6.isSelected()) {
				if (c1.isSelected() || c2.isSelected() || c3.isSelected()|| c4.isSelected() || c5.isSelected()) {
					facility = facility + ", E-Statement";
				} else {
					facility = facility + "E-Statement";
				}
				
			}

			try {
				if (accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "Account Type is Required");
				} else {
					Conn conn = new Conn();
					String query1 = "insert into signupthree values('" + formno + "','" + accountType + "','"
							+ cardnumber + "','" + pinnumber + "','" + facility + "')";
					String query2 = "insert into login values('" + formno + "','" + cardnumber + "','" + pinnumber
							+ "')";
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
					JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pinnumber);

					setVisible(false);
					new deposit(pinnumber).setVisible(true);

				}

			} catch (Exception e) {
				System.out.println(e);
			}
		} else if (ae.getSource() == cancle) {
			setVisible(false);
			new login().setVisible(true);
		}

	}
}
