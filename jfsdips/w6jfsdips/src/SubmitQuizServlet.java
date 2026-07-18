import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitQuizServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] questionIds = request.getParameterValues("questionIds");
        int score = 0;
        int total = 0;

        if (questionIds != null) {
            total = questionIds.length;

            try {
                Connection connection = DBConnection.getConnection();

                for (String idStr : questionIds) {
                    int id = Integer.parseInt(idStr);
                    String submittedAnswer = request.getParameter("q" + id);

                    String query = "SELECT correct_answer FROM questions WHERE id = ?";
                    PreparedStatement ps = connection.prepareStatement(query);
                    ps.setInt(1, id);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        String correctAnswer = rs.getString("correct_answer");
                        if (submittedAnswer != null && submittedAnswer.equals(correctAnswer)) {
                            score++;
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        request.setAttribute("score", score);
        request.setAttribute("total", total);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
