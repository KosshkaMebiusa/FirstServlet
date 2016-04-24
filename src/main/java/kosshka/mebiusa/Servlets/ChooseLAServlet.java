package kosshka.mebiusa.Servlets;

import kosshka.mebiusa.Classes.DataBase;
import kosshka.mebiusa.Classes.ML.MLAlgorithm;
import kosshka.mebiusa.Classes.ML.MachineLearning;
import kosshka.mebiusa.DomainModel.Weather;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by kosshka_mebiusa on 24.04.16.
 */
public class ChooseLAServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Weather> weatherList = DataBase.allWeather();
        int weatherItem = Integer.parseInt(req.getParameter("chooseitem"));
        MLAlgorithm mlAlgorithm = MachineLearning.bestAlgorithm(weatherList, weatherItem);
        String algorithmName = mlAlgorithm.getClass().toString();

        req.setAttribute("algorithm", algorithmName);
        req.setAttribute("P", mlAlgorithm.getP());
        req.setAttribute("params", mlAlgorithm.getParameteresString());
        RequestDispatcher rd = req.getRequestDispatcher("/testResult.jsp");
        rd.forward(req,resp);

    }
}
