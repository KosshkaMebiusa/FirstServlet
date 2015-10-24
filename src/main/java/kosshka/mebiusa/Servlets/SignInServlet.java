package kosshka.mebiusa.Servlets;

import kosshka.mebiusa.Classes.DataBase;
import kosshka.mebiusa.Weather.OpenWeatherMapAPI;
import kosshka.mebiusa.Weather.Weather;
import kosshka.mebiusa.Weather.WeatherAPI;
import kosshka.mebiusa.Weather.WorldWeatherOnlineAPI;

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

                WeatherAPI weatherAPI = new OpenWeatherMapAPI();
                Weather weather = weatherAPI.getCurrentWeather(rs.getString("city"));
                req.setAttribute("temperatureOWM", weather.temperature);
                req.setAttribute("pressureOWM", weather.pressure);
                req.setAttribute("humidityOWM",weather.humidity);
                req.setAttribute("windspeedOWM", weather.windSpeed);
                req.setAttribute("winddirectionOWM", weather.windDirection);
                req.setAttribute("weatherConditionOWM", weather.weatherCondition);

                weatherAPI = new WorldWeatherOnlineAPI();
                weather = weatherAPI.getCurrentWeather(rs.getString("city"));
                req.setAttribute("temperatureWWO", weather.temperature);
                req.setAttribute("pressureWWO", weather.pressure);
                req.setAttribute("humidityWWO",weather.humidity);
                req.setAttribute("windspeedWWO", weather.windSpeed);
                req.setAttribute("winddirectionWWO", weather.windDirection);
                req.setAttribute("weatherConditionWWO", weather.weatherCondition);

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
