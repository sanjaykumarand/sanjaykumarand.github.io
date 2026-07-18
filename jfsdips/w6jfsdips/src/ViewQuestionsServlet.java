import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewQuestionsServlet extends HttpServlet {

    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {

        // Use String[] instead of Question object so JSP doesn't need to import Question class
        // Each String[]: [0]=id, [1]=question, [2]=op1, [3]=op2, [4]=op3, [5]=op4
        List<String[]> questionList = new ArrayList<>();

        try {
            Connection connection = DBConnection.getConnection();
            String query = "SELECT id, question, option1, option2, option3, option4, correct_answer FROM questions";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String[] row = new String[7];
                row[0] = String.valueOf(rs.getInt("id"));
                row[1] = rs.getString("question");
                row[2] = rs.getString("option1");
                row[3] = rs.getString("option2");
                row[4] = rs.getString("option3");
                row[5] = rs.getString("option4");
                row[6] = rs.getString("correct_answer");
                questionList.add(row);
            }

            rs.close();
            ps.close();
            connection.close();

        } catch (Exception e) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h2>DB Error: " + e.getMessage() + "</h2>");
            e.printStackTrace(out);
            return;
        }

        request.setAttribute("questionList", questionList);
        request.getRequestDispatcher("takeQuiz.jsp").forward(request, response);
    }
}
