import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
static final String URL = "jdbc:mysql://localhost:3306/student_management";
static final String USER = "sanjaykumaran";
static final String PASSWORD = "Sanjay+-7906";
public static Connection getConnection() {
Connection connection = null;
try {
Class.forName("com.mysql.cj.jdbc.Driver");
connection = DriverManager.getConnection(URL,USER,PASSWORD);
System.out.println("Database Connected Successfully");
} catch (Exception e) {
	 e.printStackTrace();
}
return connection;
}
}