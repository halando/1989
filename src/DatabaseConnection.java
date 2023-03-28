import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DatabaseConnection {

    private static Connection conn;
    public static void main(String[] args)  {


       Connecting connecting = new Connecting("employee","root","");
       connecting.connect();
       conn = connecting.getConnection();
        getData();
     
    }
    private static void getData(){

        String sql = "SELECT*FROM workers; ";

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                System.out.print(rs.getInt(1)+ ",");
                System.out.print(rs.getString("name")+ " ,");
                System.out.print(rs.getInt(3)+ "\n");
            }
        } catch (SQLException ex) {
            System.out.println("Hiba a lekérdezés során");
           
        }
    }
}
