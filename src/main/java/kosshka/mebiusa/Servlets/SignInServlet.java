package kosshka.mebiusa.Servlets;

import kosshka.mebiusa.Classes.DataBase;
import kosshka.mebiusa.Classes.Weather;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

/**
 * Created by kosshka_mebiusa on 17.10.15.
 */
public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            ResultSet rs = DataBase.find(req.getParameter("login"), req.getParameter("password"));
            if (rs.next()){
                req.setAttribute("login", rs.getString("login"));
                req.setAttribute("city", rs.getString("city"));
                req.setAttribute("temperature", Weather.getWeatherData(rs.getString("city")));

                RequestDispatcher rd = req.getRequestDispatcher("/weather.jsp");
                rd.forward(req,resp);
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("/signup.jsp");
                rd.forward(req, resp);
            }
        } catch (Exception e){
            req.setAttribute("login", "!!!"+e.getMessage());
            RequestDispatcher rd = req.getRequestDispatcher("/weather.jsp");
            rd.forward(req,resp);
        }

    }

}
