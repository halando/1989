import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.lang.ClassNotFoundException;

public class Connecting {

   private String database;
    private String user;
   private  String pass;
   private Connection conn;
    public Connecting() {
    }

    public Connecting(String database, String user, String pass){
        this.database = database;
        this.user = user;
        this.pass = pass;
        conn = null;
    }

    public void connect() {

        String url = "jdbc:mariadb://localhost:3306/" + database;
       

        try {
            // com.mysql.jdbc.Driver
            Class.forName("org.mariadb.jdbc.Driver");
            conn = (Connection)DriverManager.getConnection(url, user,pass);
        } catch (SQLException ex) {
         System.out.println("Hiba a kapcsolódás során.");
        } catch (ClassNotFoundException ex) {
            System.out.println("Nincs meg a driver");
        }

        if (conn != null) {
            System.out.println("sikeres kapcsolódás");
        }
    }

    public void closeConnect() {
         if(conn != null){
           try {
            conn.close();
           } catch (SQLException ex) {
            System.out.println("Hiba a lezárás során");
           }
         }
    }
     public Connection getConnection(){
        return conn;
     }
}
