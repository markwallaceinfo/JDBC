import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url= "jdbc:mysql://localhost:3306/kevin";
        String uname = "root";
        String password = "password";
        ResultSet resultSet = null;
        Connection con = null;
        String query ="select* from student";//DQL
        String insertQuery = "insert into student values('james','java');";
        try {
            con = DriverManager.getConnection(url,uname,password);
            Statement st = con.createStatement();
            int count = st.executeUpdate(insertQuery);
            System.out.println("No of row affected = " + count);
        }
        finally {
            if (resultSet !=null)
                resultSet.close();
                  if (con != null)
                      con.close();
        }

    }

}
