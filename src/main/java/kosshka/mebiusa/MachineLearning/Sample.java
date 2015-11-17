package kosshka.mebiusa.MachineLearning;

import kosshka.mebiusa.DomainModel.Weather;

import java.util.LinkedList;
import java.util.List;

public class Sample {
    public List<Precedent> sample = new LinkedList<>();

    Sample (List<Weather> weatherList, int N, int propety){

        for (int i=N; i < weatherList.size(); i++){
            Precedent precedent;
            switch (propety){
                case Weather.TEPMERATURE:
                    precedent = new Precedent<Integer>();
                    precedent.answer = weatherList.get(i).getTemperature();
                    break;
                case Weather.PRESSURE:
                    precedent = new Precedent<Integer>();
                    precedent.answer = weatherList.get(i).getPressure();
                    break;
                case Weather.HUMIDITY:
                    precedent = new Precedent<Integer>();
                    precedent.answer = weatherList.get(i).getHumidity();
                    break;
                case Weather.WIND_SPEED:
                    precedent = new Precedent<Integer>();
                    precedent.answer = weatherList.get(i).getWindSpeed();
                    break;
                case Weather.WIND_DIRECTION:
                    precedent = new Precedent<Integer>();
                    precedent.answer = weatherList.get(i).getWindDirection();
                    break;
                case Weather.WEATHER_DISCRIPTION:
                    precedent = new Precedent<String>();
                    precedent.answer = weatherList.get(i).getWeatherCondition();
                    break;
                default:
                    precedent = new Precedent();
            }
            precedent.object.addAll(weatherList.subList(i-N, i));


        }
    }
}
