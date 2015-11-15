package kosshka.mebiusa.Servlets;

import kosshka.mebiusa.Classes.DataBase;
import kosshka.mebiusa.DomainModel.Weather;
import kosshka.mebiusa.WeatherAPI.WeatherAPI;
import kosshka.mebiusa.WeatherAPI.WorldWeatherOnlineAPI;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        WeatherAPI weatherAPI = new WorldWeatherOnlineAPI();

        String dateString = "2015-10-21";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = null;
        try {
            date = format.parse(dateString);
        } catch (Exception e){

        }
        java.util.Date today = new java.util.Date();
        while (date.before(today)){
            List<Weather> weatherList = weatherAPI.getHistoricalWeather("Saint-Petersburg", new Date(date.getTime()));
            for (Weather weather:weatherList ){
                try {
                    DataBase.addWeather(weather);
                } catch (Exception e){

                }
            }
            date = new Date(date.getTime() + 86400000);
        }

        List<Weather> allWeatherList = DataBase.allWeather();
        req.setAttribute("weatherList", allWeatherList);

        RequestDispatcher rd = req.getRequestDispatcher("/weather.jsp");
        rd.forward(req,resp);

    }
}
