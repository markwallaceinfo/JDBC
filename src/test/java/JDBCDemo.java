
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url= "jdbc:mysql://localhost:3306/company";
        String uname = "root";
        String password = "password";
        Connection con = DriverManager.getConnection(url,uname,password);
        Statement st = con.createStatement();
        ResultSet resultSet = st.executeQuery("select * from employee");

        while (resultSet.next()){
            System.out.println("Employee Id :" + resultSet.getInt(1));
            System.out.println("Employee Id :" + resultSet.getString(2));
            System.out.println("Employee Id :" + resultSet.getString(3));
        }


    }
}
