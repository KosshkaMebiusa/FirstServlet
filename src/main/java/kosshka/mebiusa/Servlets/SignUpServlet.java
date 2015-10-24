package kosshka.mebiusa.Servlets;

import kosshka.mebiusa.Classes.DataBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userLogin = req.getParameter("login");
        String userPassword = req.getParameter("password");
        String userCity = req.getParameter("city");


        try {
            DataBase.add(userLogin, userPassword, userCity);
            req.setAttribute("login", userLogin);
            req.setAttribute("city", userCity);

            RequestDispatcher rd = req.getRequestDispatcher("/success.jsp");
            rd.forward(req,resp);

        } catch (Exception e){

        }
    }
}
