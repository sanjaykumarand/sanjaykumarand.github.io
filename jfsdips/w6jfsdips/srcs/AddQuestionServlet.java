import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AddQuestionServlet
extends HttpServlet {
protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
String question =
request.getParameter("question");
String option1 =
request.getParameter("option1");
String option2 =
request.getParameter("option2");
String option3 =
request.getParameter("option3");
String option4 =
request.getParameter("option4");
String correctAnswer =
request.getParameter("correct_answer");
try {
Connection connection =
DBConnection.getConnection();
String query =
"INSERT INTO questions(question, option1, option2, option3, option4,correct_answer) VALUES (?, ?, ?, ?, ?, ?)";
PreparedStatement ps =
connection.prepareStatement(query);
ps.setString(1, question);
ps.setString(2, option1);
ps.setString(3, option2);
ps.setString(4, option3);
ps.setString(5, option4);
ps.setString(6, correctAnswer);
ps.executeUpdate();
response.sendRedirect(
"index.jsp"
);
} catch (Exception e) {
System.out.println(e);
}
}
}