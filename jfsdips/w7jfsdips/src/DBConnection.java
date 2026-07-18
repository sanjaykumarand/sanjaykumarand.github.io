import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static String url = "jdbc:mysql://" + System.getenv("DB_HOST_7") + ":" + System.getenv("DB_PORT_7") + "/" + System.getenv("DB_NAME_7");
    static String username = System.getenv("DB_USER_7");
    static String password = System.getenv("DB_PASS_7");

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}