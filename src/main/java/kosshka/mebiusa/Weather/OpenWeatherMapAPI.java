package kosshka.mebiusa.Weather;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by kosshka_mebiusa on 15.10.15.
 */
public class OpenWeatherMapAPI implements WeatherAPI {
    private static final String OPEN_WEATHER_MAP_API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&APPID=%s&units=metric";

    private static final String OPEN_WEATHER_MAP_API_ID = "540a3340d64f9f8c655cd3f75d2810a0";

    private static JSONObject getJSON(String city){
        try {

            //connection
            URL url = new URL(String.format(OPEN_WEATHER_MAP_API_URL, city, OPEN_WEATHER_MAP_API_ID));
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            //reading jsonobject
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer json = new StringBuffer(1024);
            String tmp = "";
            while ((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();
            JSONObject data = new JSONObject(json.toString());

            //Это значение будет равно 404 если ответ не получен
            if (data.getInt("cod") != 200){
                return null;
            }

            return data;
        } catch(Exception e) {
            return null;
        }
    }


    public Weather getCurrentWeather(String city) {
        JSONObject json = getJSON(city);
        try {
            JSONObject main = json.getJSONObject("main");
            double temperature = main.getDouble("temp");
            int pressure = main.getInt("pressure");
            int humidity = main.getInt("humidity");
            JSONObject wind = json.getJSONObject("wind");
            int windSpeed = wind.getInt("speed");
            int windDirection = wind.getInt("deg");
            JSONObject weather = json.getJSONArray("weather").getJSONObject(0);
            String weatherCondition = weather.getString("main");

            return new Weather(weatherCondition,temperature,pressure, humidity,windSpeed,windDirection);
        } catch (Exception e){
            return null;
        }
    }

    public Weather getCurrentWeather(double lat, double lon) {
        return null;
    }

}
