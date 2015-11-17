package kosshka.mebiusa.DomainModel;

import java.sql.Time;
import java.sql.Date;

/**
 * Created by kosshka_mebiusa on 21.10.15.
 */
public class Weather {

    public final static int TEPMERATURE = 1;
    public final static int PRESSURE = 2;
    public final static int HUMIDITY = 3;
    public final static int WIND_SPEED = 4;
    public final static int WIND_DIRECTION = 5;
    public final static int WEATHER_DISCRIPTION = 6;


    private String weatherCondition;
    private int temperature;
    private int pressure;
    private int humidity;
    private int windSpeed;
    private int windDirection;
    private Date date;
    private Time time;

    public Weather(String weatherCondition, int temperature, int pressure,
                   int humidity, int windSpeed, int windDirection){
        this.setWeatherCondition(weatherCondition);
        this.setTemperature(temperature);
        this.setPressure(pressure);
        this.setHumidity(humidity);
        this.setWindSpeed(windSpeed);
        this.setWindDirection(windDirection);

    }

    public Weather(Date date, Time time, String weatherCondition, int temperature, int pressure,
                   int humidity, int windSpeed, int windDirection){
        this.setWeatherCondition(weatherCondition);
        this.setTemperature(temperature);
        this.setPressure(pressure);
        this.setHumidity(humidity);
        this.setWindSpeed(windSpeed);
        this.setWindDirection(windDirection);
        this.setDate(date);
        this.setTime(time);

    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
