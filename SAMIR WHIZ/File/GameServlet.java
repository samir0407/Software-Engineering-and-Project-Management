package controller;

import dao.ScoreDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/GameServlet")
public class GameServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String playerName =
                request.getParameter("playerName");

        int q1 =
                Integer.parseInt(
                        request.getParameter("q1"));

        int q2 =
                Integer.parseInt(
                        request.getParameter("q2"));

        double q3 =
                Double.parseDouble(
                        request.getParameter("q3"));

        double q4 =
                Double.parseDouble(
                        request.getParameter("q4"));

        int score = 0;

        if(q1 == 1)
            score += 2;

        if(q2 == 2)
            score += 2;

        if(Math.abs(q3 - 0.5) < 0.01)
            score += 3;

        if(Math.abs(q4 - 0.5) < 0.01)
            score += 3;

        ScoreDAO dao = new ScoreDAO();

        dao.saveScore(
                playerName,
                score,
                "NORMAL"
        );

        request.setAttribute(
                "playerName",
                playerName);

        request.setAttribute(
                "score",
                score);

        request.getRequestDispatcher(
                "/result.jsp")
                .forward(
                        request,
                        response);
    }
}