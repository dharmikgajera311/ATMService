package bankmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinnumber;
    JButton back;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 480, 150, 30);
        back.addActionListener(this);
        image.add(back);

        Conn conn = new Conn();
        long balance = 0; // Changed from int to long

        try {
            ResultSet rs = conn.s.executeQuery("select * from bank where pin='" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Long.parseLong(rs.getString("amount")); // Changed from Integer.parseInt to Long.parseLong
                } else {
                    balance -= Long.parseLong(rs.getString("amount")); // Changed from Integer.parseInt to Long.parseLong
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("YOUR CURRENT BALANCE:");
        text.setBounds(190, 350, 300, 30);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        JLabel text2 = new JLabel("RS. " + balance);
        text2.setBounds(190, 390, 300, 30);
        text2.setForeground(Color.white);
        text2.setFont(new Font("System", Font.BOLD, 16));
        image.add(text2);


        setSize(900, 850);
        setLocation(450, 120);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}
