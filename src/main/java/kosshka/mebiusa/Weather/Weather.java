package kosshka.mebiusa.Weather;

/**
 * Created by kosshka_mebiusa on 21.10.15.
 */
public class Weather {

    public String weatherCondition;
    public int temperature;
    public int pressure;
    public int humidity;
    public int windSpeed;
    public int windDirection;

    public Weather(String weatherCondition, int temperature, int pressure,
                   int humidity, int windSpeed, int windDirection){
        this.weatherCondition = weatherCondition;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;

    }

}
