package bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;

    MiniStatement(String pinnumber) {

        setTitle("Mini Statement");
        setLayout(null);
        this.pinnumber = pinnumber;

        JLabel bank = new JLabel("INDIAN BANK");
        bank.setBounds(150, 30, 150, 20);
        bank.setFont(new Font("System", Font.BOLD, 16));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        card.setFont(new Font("System", Font.BOLD, 16));
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(20, 130, 300, 300); // Increased height to accommodate more entries
        add(mini);

        JLabel balance = new JLabel();
        balance.setBounds(180, 450, 300, 20);
        add(balance);

        back = new JButton("Back");
        back.setBounds(20, 470, 100, 20);
        back.addActionListener(this);
        add(back);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"' ");
            if (rs.next()) {
                card.setText("Card number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXX"
                        + rs.getString("cardnumber").substring(10, 12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        StringBuilder miniText = new StringBuilder("<html>");
        long bal = 0;
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
            while (rs.next()) {
                miniText.append(rs.getString("date"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type"))
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("amount"))
                        .append("<br><br>");
                if (rs.getString("type").equals("Deposit")) {
                    bal += Long.parseLong(rs.getString("amount"));
                } else {
                    bal -= Long.parseLong(rs.getString("amount"));
                }
            }
            miniText.append("</html>");
            mini.setText(miniText.toString());
            balance.setText("YOUR BALANCE RS. " + bal);
        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(400, 600);
        setLocation(580, 260);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}
