package kosshka.mebiusa.Weather;

import org.json.JSONObject;

/**
 * Created by kosshka_mebiusa on 24.10.15.
 */
public class WorldWeatherOnlineAPI implements WeatherAPI {

    private static final String WORLD_WEATHER_ONLINE_API_URL = "http://api.worldweatheronline.com/free/v2/weather.ashx?key=%s&q=%s&fx=no&format=json";

    private static final String WORLD_WEATHER_ONLINE_API_ID = "2165acc893e58ba65d64584d61a94";

    public Weather getCurrentWeather(String city) {
        JSONObject json = WeatherAPI.getJSON(WORLD_WEATHER_ONLINE_API_URL,WORLD_WEATHER_ONLINE_API_ID,city);
        try {
            JSONObject main = json.getJSONObject("data").getJSONArray("current_condition").getJSONObject(0);

            int temperature = main.getInt("temp_C");
            int pressure = main.getInt("pressure");
            int humidity = main.getInt("humidity");
            int windSpeed = main.getInt("windspeedKmph");
            int windDirection = main.getInt("winddirDegree");
            JSONObject weather = main.getJSONArray("weatherDesc").getJSONObject(0);
            String weatherCondition = weather.getString("value");

            return new Weather(weatherCondition,temperature,pressure, humidity,windSpeed,windDirection);
        } catch (Exception e){
            return null;
        }
    }

}
