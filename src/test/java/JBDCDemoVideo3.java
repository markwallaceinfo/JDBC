import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JBDCDemoVideo3 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/kevin";
        String uname = "root";
        String password = "password";

        Connection con = DriverManager.getConnection(url, uname, password);
        Statement st = con.createStatement();
        System.out.println("Data before Transaction");
        System.out.println("--------------------");
        ResultSet rS = st.executeQuery("select* from accounts");
       while (rS.next()){
           System.out.println(rS.getString(1)+"..."+ rS.getInt(2));
       }
        System.out.println("Transaction begins.....");
       con.setAutoCommit(false);
       st.executeUpdate("update account set balance = balance -20000 where user = 'millian'");
        st.executeUpdate("update account set balance = balance -20000 where user = 'anushka'");
        System.out.println("can you please confirm this transaction of 2000......[Yes|No]");
        Scanner sc = new Scanner(System.in);
        String option = sc.next();
        if (option.equalsIgnoreCase("yes")){
            con.commit();
            System.out.println("transaction commited");
        }
        else {
            con.rollback();
            System.out.println("transaction rolled back");
        }
        System.out.println("data after transaction");
        System.out.println("-----------------------");
        ResultSet rs1 = st.executeQuery("select* from account");
        while (rs1.next())
        {
            System.out.println(rs1.getString(1)+"....."+rs1.getInt(2));
        }
        con.close();


    }
}