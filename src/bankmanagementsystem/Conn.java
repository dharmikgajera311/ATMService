package bankmanagementsystem;

import java.sql.*;


public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	String url = "jdbc:mysql://localhost:3306/bankmanagementsystem?connectTimeout=5000&socketTimeout=5000&useSSL=false&allowPublicKeyRetrieval=true";            
        	c = DriverManager.getConnection(url, "root", "Dharmik@+#16");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public Connection getConnection(){
    	return c;
    }

    public static void main(String[] args) {
        new Conn();
    }
}
