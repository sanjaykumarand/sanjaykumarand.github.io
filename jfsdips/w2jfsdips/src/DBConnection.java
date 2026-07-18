import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static String url = "jdbc:mysql://" + System.getenv("DB_HOST_2") + ":" + System.getenv("DB_PORT_2") + "/" + System.getenv("DB_NAME_2");
    static String username = System.getenv("DB_USER_2");
    static String password = System.getenv("DB_PASS_2");

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