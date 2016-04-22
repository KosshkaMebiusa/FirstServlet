package kosshka.mebiusa.WeatherAPI;

import kosshka.mebiusa.DomainModel.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class WorldWeatherOnlineAPI implements WeatherAPI {

    private static final String WORLD_WEATHER_ONLINE_API_URL = "http://api.worldweatheronline.com/premium/v1/weather.ashx?key=%s&q=%s&fx=no&format=json";
    private static final String WORLD_WEATHER_ONLINE_API_URL_HISTORICAL = "http://api.worldweatheronline.com/premium/v1/past-weather.ashx?key=%s&q=%s&format=json&date=%s";

    private static final String WORLD_WEATHER_ONLINE_API_ID = "39f3b73243614dd5a89164352162204";

    private Weather getWeatherFromJSON (JSONObject main) throws JSONException{

        int pressure = main.getInt("pressure");
        int humidity = main.getInt("humidity");
        int windSpeed = main.getInt("windspeedKmph");
        int windDirection = main.getInt("winddirDegree");
        JSONObject weather = main.getJSONArray("weatherDesc").getJSONObject(0);
        String weatherCondition = weather.getString("value");

        return new Weather(weatherCondition, 0, pressure, humidity, windSpeed, windDirection);
    }

    public Weather getCurrentWeather(String city) {
        JSONObject json = WeatherAPI.getJSON(WORLD_WEATHER_ONLINE_API_URL, WORLD_WEATHER_ONLINE_API_ID, city);
        try {
            JSONObject main = json.getJSONObject("data").getJSONArray("current_condition").getJSONObject(0);

            Weather weather = getWeatherFromJSON(main);
            weather.setTemperature(main.getInt("temp_C"));

            return weather;


        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Weather> getHistoricalWeather(String city, Date date) {
        JSONObject json = WeatherAPI.getJSON(WORLD_WEATHER_ONLINE_API_URL_HISTORICAL, WORLD_WEATHER_ONLINE_API_ID, city, date);
        List<Weather> weatherList = new ArrayList<>();
        try {
            JSONArray jsonArray = json.getJSONObject("data").getJSONArray("weather").getJSONObject(0).getJSONArray("hourly");
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Weather weather = getWeatherFromJSON(jsonObject);
                int temperature = jsonObject.getInt("tempC");
                weather.setTemperature(temperature);

                String timeString = jsonObject.getString("time");
                if (timeString.length() == 3){
                    timeString = "0" + timeString;
                }

                DateFormat format = new SimpleDateFormat("HHmm");
                Time time = new Time(format.parse(timeString).getTime());
                weather.setTime(time);
                weather.setDate(new java.sql.Date(date.getTime()));

                weatherList.add(weather);

            }
        } catch (Exception e) {
            return null;
        }
        return weatherList;
    }

}
