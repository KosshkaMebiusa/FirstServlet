package kosshka.mebiusa.Servlets;

import kosshka.mebiusa.Classes.DataBase;
import kosshka.mebiusa.DomainModel.Weather;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by kosshka_mebiusa on 03.05.16.
 */
public class CreateDatabaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String database = req.getParameter("dbname");
        try {
            DataBase.createDB(database);
        }catch (Exception e){

        }

        List<Weather> weatherList = DataBase.allWeather();
        req.setAttribute("weatherList", weatherList);

        RequestDispatcher rd = req.getRequestDispatcher("/weather.jsp");
        rd.forward(req,resp);
    }
}
