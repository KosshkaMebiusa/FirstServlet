package kosshka.mebiusa.Servlets;

import kosshka.mebiusa.Classes.DataBase;
import kosshka.mebiusa.DomainModel.Weather;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;


public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
//            DataBase.start();
            ResultSet rs = DataBase.findUser(req.getParameter("login"), req.getParameter("password"));
            if (rs.next()){
                String city = rs.getString("city");
                req.setAttribute("login", rs.getString("login"));
                req.setAttribute("city", city);

/*
                WeatherAPI weatherAPI = new OpenWeatherMapAPI();
                Weather weather = weatherAPI.getCurrentWeather(city);

                weather.setDate(new Date(System.currentTimeMillis()));
                weather.setTime(new java.sql.Time(System.currentTimeMillis()));
                DataBase.addWeather(weather);

                req.setAttribute("temperatureOWM", weather.getTemperature());
                req.setAttribute("pressureOWM", weather.getPressure());
                req.setAttribute("humidityOWM", weather.getHumidity());
                req.setAttribute("windspeedOWM", weather.getWindSpeed());
                req.setAttribute("winddirectionOWM", weather.getWindDirection());
                req.setAttribute("weatherConditionOWM", weather.getWeatherCondition());

                weatherAPI = new WorldWeatherOnlineAPI();
                weather = weatherAPI.getCurrentWeather(city);
                req.setAttribute("temperatureWWO", weather.getTemperature());
                req.setAttribute("pressureWWO", weather.getPressure());
                req.setAttribute("humidityWWO", weather.getHumidity());
                req.setAttribute("windspeedWWO", weather.getWindSpeed());
                req.setAttribute("winddirectionWWO", weather.getWindDirection());
                req.setAttribute("weatherConditionWWO", weather.getWeatherCondition());
*/

                List<Weather> weatherList = DataBase.allWeather();
                req.setAttribute("weatherList", weatherList);

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
