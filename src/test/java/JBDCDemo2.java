import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JBDCDemo2 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/kevin";
        String uname = "root";
        String password = "password";
        ResultSet resultSet = null;
        Connection con = null;
        String query = "select* from student";//DQL
        String insertQuery = "insert into student values('2',john','java');";
        try {
            con = DriverManager.getConnection(url, uname, password);
            Statement st = con.createStatement();
            boolean execute = st.execute(query);
            if (execute) {
                ResultSet resultSet1 = st.getResultSet();
                resultSet1.next();
                System.out.println(resultSet1.getString(2));
            } else {
                System.out.println(st.getUpdateCount());
            }

        } finally {
            if (resultSet != null)
                resultSet.close();
            if (con != null)
                con.close();
        }

    }
}
