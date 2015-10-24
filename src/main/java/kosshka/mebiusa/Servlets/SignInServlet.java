package kosshka.mebiusa.Servlets;

import kosshka.mebiusa.Classes.DataBase;
import kosshka.mebiusa.Weather.OpenWeatherMapAPI;
import kosshka.mebiusa.Weather.Weather;
import kosshka.mebiusa.Weather.WeatherAPI;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;


public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            ResultSet rs = DataBase.find(req.getParameter("login"), req.getParameter("password"));
            if (rs.next()){
                req.setAttribute("login", rs.getString("login"));
                req.setAttribute("city", rs.getString("city"));

                WeatherAPI openWeatherMapAPI = new OpenWeatherMapAPI();
                Weather weather = openWeatherMapAPI.getCurrentWeather(rs.getString("city"));

                req.setAttribute("temperature", weather.temperature);
                req.setAttribute("pressure", weather.pressure);
                req.setAttribute("humidity",weather.humidity);
                req.setAttribute("windspeed", weather.windSpeed);
                req.setAttribute("winddirection", weather.windDirection);
                req.setAttribute("weatherCondition", weather.weatherCondition);

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
