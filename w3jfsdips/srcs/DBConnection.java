import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
static String url =
"jdbc:mysql://localhost:3306/library_management";
static String username = "sanjaykumaran";
static String password = "Sanjay+-7906";
public static Connection getConnection() {
Connection connection = null;
try {
Class.forName(
"com.mysql.cj.jdbc.Driver"
);
connection =
DriverManager.getConnection(
url,
username,
password
);
} catch (Exception e) {
System.out.println(e);
}
return connection;
}
}