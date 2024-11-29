package bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;

    SignupOne() {
        setLayout(null);
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 10000L);

        JLabel formno = new JLabel("Application No:" + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(220, 20, 600, 40);
        add(formno);

        JLabel personDetails = new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 28));
        personDetails.setBounds(240, 80, 600, 40);
        add(personDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Raleway", Font.BOLD, 24));
        name.setBounds(120, 150, 200, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        nameTextField.setBounds(330, 150, 400, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name: ");
        fname.setFont(new Font("Raleway", Font.BOLD, 24));
        fname.setBounds(120, 210, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        fnameTextField.setBounds(330, 210, 400, 30);
        add(fnameTextField);

        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setFont(new Font("Raleway", Font.BOLD, 24));
        dob.setBounds(120, 270, 400, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(330, 270, 400, 30);
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 18));
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Raleway", Font.BOLD, 24));
        gender.setBounds(120, 330, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(330, 330, 70, 30);
        male.setFont(new Font("Raleway", Font.BOLD, 18));
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 330, 100, 30);
        female.setFont(new Font("Raleway", Font.BOLD, 18));
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Raleway", Font.BOLD, 24));
        email.setBounds(120, 390, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        emailTextField.setBounds(330, 390, 400, 30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status: ");
        marital.setFont(new Font("Raleway", Font.BOLD, 24));
        marital.setBounds(120, 450, 200, 30);
        add(marital);

        married = new JRadioButton("Married");
        married.setFont(new Font("Raleway", Font.BOLD, 18));
        married.setBounds(330, 450, 100, 30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Raleway", Font.BOLD, 18));
        unmarried.setBounds(450, 450, 120, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setFont(new Font("Raleway", Font.BOLD, 18));
        other.setBounds(590, 450, 100, 30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup marritalegroup = new ButtonGroup();
        marritalegroup.add(married);
        marritalegroup.add(unmarried);
        marritalegroup.add(other);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Raleway", Font.BOLD, 24));
        address.setBounds(120, 510, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        addressTextField.setBounds(330, 510, 400, 30);
        add(addressTextField);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Raleway", Font.BOLD, 24));
        city.setBounds(120, 570, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        cityTextField.setBounds(330, 570, 400, 30);
        add(cityTextField);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Raleway", Font.BOLD, 24));
        state.setBounds(120, 630, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        stateTextField.setBounds(330, 630, 400, 30);
        add(stateTextField);

        JLabel pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 24));
        pincode.setBounds(120, 690, 200, 30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        pinTextField.setBounds(330, 690, 400, 30);
        add(pinTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 18));
        next.setBounds(645, 750, 83, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 900);
        setLocation(500, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }

        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()) {
            marital = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pinTextField.getText();

        try {
            if (name.equals("") || fname.equals("") || dob.equals("") || gender == null || email.equals("")
                    || marital == null || address.equals("") || city.equals("") || state.equals("") || pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "All fields are required!");
                return;
            } else {
                Conn c = new Conn();
                String query = "insert into signup values('" + formno + "', '" + name + "', '" + fname + "', '" + dob
                        + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city
                        + "', '" + pincode + "', '" + state + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
