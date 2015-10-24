package kosshka.mebiusa.Weather;

import org.json.JSONObject;

public class OpenWeatherMapAPI implements WeatherAPI {
    private static final String OPEN_WEATHER_MAP_API_URL = "http://api.openweathermap.org/data/2.5/weather?APPID=%s&q=%s&units=metric";

    private static final String OPEN_WEATHER_MAP_API_ID = "540a3340d64f9f8c655cd3f75d2810a0";


    public Weather getCurrentWeather(String city) {
        JSONObject json = WeatherAPI.getJSON(OPEN_WEATHER_MAP_API_URL, OPEN_WEATHER_MAP_API_ID,city);
        try {
            JSONObject main = json.getJSONObject("main");
            int temperature = (int) main.getDouble("temp");
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

}
