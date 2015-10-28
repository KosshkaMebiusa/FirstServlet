package kosshka.mebiusa.Servlets;

import kosshka.mebiusa.Classes.DataBase;
import kosshka.mebiusa.WeatherAPI.OpenWeatherMapAPI;
import kosshka.mebiusa.DomainModel.Weather;
import kosshka.mebiusa.WeatherAPI.WeatherAPI;
import kosshka.mebiusa.WeatherAPI.WorldWeatherOnlineAPI;

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
            ResultSet rs = DataBase.findUser(req.getParameter("login"), req.getParameter("password"));
            if (rs.next()){
                req.setAttribute("login", rs.getString("login"));
                req.setAttribute("city", rs.getString("city"));

                WeatherAPI weatherAPI = new OpenWeatherMapAPI();
                Weather weather = weatherAPI.getCurrentWeather(rs.getString("city"));
                req.setAttribute("temperatureOWM", weather.getTemperature());
                req.setAttribute("pressureOWM", weather.getPressure());
                req.setAttribute("humidityOWM", weather.getHumidity());
                req.setAttribute("windspeedOWM", weather.getWindSpeed());
                req.setAttribute("winddirectionOWM", weather.getWindDirection());
                req.setAttribute("weatherConditionOWM", weather.getWeatherCondition());

                weatherAPI = new WorldWeatherOnlineAPI();
                weather = weatherAPI.getCurrentWeather(rs.getString("city"));
                req.setAttribute("temperatureWWO", weather.getTemperature());
                req.setAttribute("pressureWWO", weather.getPressure());
                req.setAttribute("humidityWWO", weather.getHumidity());
                req.setAttribute("windspeedWWO", weather.getWindSpeed());
                req.setAttribute("winddirectionWWO", weather.getWindDirection());
                req.setAttribute("weatherConditionWWO", weather.getWeatherCondition());

                List<Weather> weatherList = DataBase.allWeather();
                req.setAttribute("weatherList", weatherList);

/*                ArrayList list = new ArrayList();
                Map author1 = new HashMap();
                author1.put("name", "A");
                author1.put("id", new Integer(1));
                list.add(author1);
                Map author2 = new HashMap();
                author2.put("name", "B");
                author2.put("id", new Integer(2));
                list.add(author2);
                Map author3 = new HashMap();
                author3.put("name", "C");
                author3.put("id", new Integer(3));
                list.add(author3);
                req.setAttribute("list", list);*/

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
