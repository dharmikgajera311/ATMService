package bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener {
	long random;
	JTextField pan, aadhar;
	JButton next;
	JRadioButton syes, sno, eyes, eno;
	JDateChooser dateChooser;
	JComboBox<String> religion, category, occupation, education, income;
	String formno;

	SignupTwo(String formno) {

		setLayout(null);
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

		this.formno = formno;

		JLabel additionalDetails = new JLabel("Page 2: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 28));
		additionalDetails.setBounds(240, 80, 600, 40);
		add(additionalDetails);

		JLabel name = new JLabel("Religion:");
		name.setFont(new Font("Raleway", Font.BOLD, 24));
		name.setBounds(120, 150, 200, 30);
		add(name);

		String valReligion[] = { "Hindu", "Muslim", "Sikh", "Christian", "Other" };
		religion = new JComboBox(valReligion);
		religion.setBounds(330, 150, 400, 30);
		religion.setFont(new Font("Raleway", Font.BOLD, 18));
		religion.setBackground(Color.white);
		religion.setForeground(Color.black);
		add(religion);

		JLabel fname = new JLabel("Category");
		fname.setFont(new Font("Raleway", Font.BOLD, 24));
		fname.setBounds(120, 210, 200, 30);
		add(fname);

		String valCategory[] = { "General", "OBC", "SC", "ST", "Other" };
		category = new JComboBox(valCategory);
		category.setFont(new Font("Raleway", Font.BOLD, 18));
		category.setBounds(330, 210, 400, 30);
		category.setBackground(Color.white);
		add(category);

		JLabel dob = new JLabel("Income ");
		dob.setFont(new Font("Raleway", Font.BOLD, 24));
		dob.setBounds(120, 270, 400, 30);
		add(dob);

		String incomeCategory[] = { "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000" };
		income = new JComboBox(incomeCategory);
		income.setFont(new Font("Raleway", Font.BOLD, 18));
		income.setBounds(330, 270, 400, 30);
		add(income);

		JLabel gender = new JLabel("Educational");
		gender.setFont(new Font("Raleway", Font.BOLD, 24));
		gender.setBounds(120, 330, 200, 30);
		add(gender);

		JLabel email = new JLabel("Qualification: ");
		email.setFont(new Font("Raleway", Font.BOLD, 24));
		email.setBounds(120, 360, 200, 30);
		add(email);

		String educationValues[] = { "Non-Graduation", "Graduate", "Post-Graduation", "Doctrate", "Others" };
		education = new JComboBox(educationValues);
		education.setBounds(330, 360, 200, 30);
		education.setFont(new Font("Raleway", Font.BOLD, 18));
		education.setBackground(Color.white);
		add(education);

		JLabel marital = new JLabel("Occupation");
		marital.setFont(new Font("Raleway", Font.BOLD, 24));
		marital.setBounds(120, 450, 200, 30);
		add(marital);

		String occuationValues[] = { "Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Other" };
		occupation = new JComboBox(occuationValues);
		occupation.setFont(new Font("Raleway", Font.BOLD, 18));
		occupation.setBounds(330, 450, 150, 30);
		occupation.setBackground(Color.white);
		add(occupation);

		JLabel address = new JLabel("PAN No: ");
		address.setFont(new Font("Raleway", Font.BOLD, 24));
		address.setBounds(120, 510, 200, 30);
		add(address);

		pan = new JTextField();
		pan.setFont(new Font("Raleway", Font.BOLD, 18));
		pan.setBounds(330, 510, 400, 30);
		add(pan);

		JLabel city = new JLabel("Aadhar No: ");
		city.setFont(new Font("Raleway", Font.BOLD, 24));
		city.setBounds(120, 570, 200, 30);
		add(city);

		aadhar = new JTextField();
		aadhar.setFont(new Font("Raleway", Font.BOLD, 18));
		aadhar.setBounds(330, 570, 400, 30);
		add(aadhar);

		JLabel state = new JLabel("Senior Citizen: ");
		state.setFont(new Font("Raleway", Font.BOLD, 24));
		state.setBounds(120, 630, 200, 30);
		add(state);

		syes = new JRadioButton("Yes");
		syes.setBounds(360, 630, 70, 30);
		syes.setFont(new Font("Raleway", Font.BOLD, 18));
		syes.setBackground(Color.white);
		add(syes);

		sno = new JRadioButton("No");
		sno.setBounds(460, 630, 70, 30);
		sno.setFont(new Font("Raleway", Font.BOLD, 18));
		sno.setBackground(Color.white);
		add(sno);

		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(syes);
		maritalgroup.add(sno);

		JLabel pincode = new JLabel("Existing Account: ");
		pincode.setFont(new Font("Raleway", Font.BOLD, 24));
		pincode.setBounds(120, 690, 220, 30);
		add(pincode);

		eyes = new JRadioButton("Yes");
		eyes.setFont(new Font("Raleway", Font.BOLD, 18));
		eyes.setBounds(360, 690, 70, 30);
		eyes.setBackground(Color.white);
		add(eyes);

		eno = new JRadioButton("No");
		eno.setFont(new Font("Raleway", Font.BOLD, 18));
		eno.setBounds(460, 690, 70, 30);
		eno.setBackground(Color.white);
		add(eno);

		ButtonGroup edugroup = new ButtonGroup();
		edugroup.add(eyes);
		edugroup.add(eno);

		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.white);
		next.setFont(new Font("raleway", Font.BOLD, 18));
		next.setBounds(645, 750, 83, 30);
		next.addActionListener(this);
		add(next);

		getContentPane().setBackground(Color.WHITE);
		setSize(850, 900);
		setLocation(500, 50);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String sreligion = (String) religion.getSelectedItem();
		String scategory = (String) category.getSelectedItem();
		String sincome = (String) income.getSelectedItem();
		String seducation = (String) education.getSelectedItem();
		String soccupation = (String) occupation.getSelectedItem();
		String seniorcitizen = null;
		if (syes.isSelected()) {
			seniorcitizen = "Yes";
		} else if (sno.isSelected()) {
			seniorcitizen = "No";
		}

		String exisitingaccount = null;
		if (eyes.isSelected()) {
			exisitingaccount = "Yes";
		} else if (eno.isSelected()) {
			exisitingaccount = "No";
		}

		String span = pan.getText();
		String saadhar = aadhar.getText();

		try {

			Conn c = new Conn();
			String query = "insert into signuptwo values('" + formno + "', '" + sreligion + "', '" + scategory + "', '"
					+ sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '"
					+ seniorcitizen + "', '" + exisitingaccount + "')";
			c.s.executeUpdate(query);
			
			setVisible(false);
			new SignupThree(formno).setVisible(true);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		new SignupTwo("");
	}
}
