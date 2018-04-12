import java.sql.*;

public class DBConnection {

    public static void main(String[] args) throws SQLException {


        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String dbname = "testing";

//    Connect to DB

        try {

            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbname, "root", "");
            System.out.println(conn.isClosed());
//            Fire Query
            Statement state=conn.createStatement();
//            Result set is the return type of query output
            ResultSet rs=state.executeQuery("select * from employee where age=38");

            while (rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString(1)+"---------"+rs.getString(2)+"------------"+rs.getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((conn != null) && (!conn.isClosed())) {
                conn.close();
            }
        }
    }
}
