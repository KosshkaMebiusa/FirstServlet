package kosshka.mebiusa.MachineLearning;

import kosshka.mebiusa.DomainModel.Weather;

import java.util.List;

public class WeatherLA implements LearningAlgorithm<Weather> {

    LearningAlgorithm<Integer> temperatureLA, pressureLA, humidityLA, windSpeedLA, windDirectionLA;
    LearningAlgorithm<String> weatherConditionLA;

    public Weather algorithm(List<Weather> object){
        String weatherCondition = weatherConditionLA.algorithm(object);
        int temperature = temperatureLA.algorithm(object);
        int pressure = pressureLA.algorithm(object);
        int humidity = humidityLA.algorithm(object);
        int windSpeed = windDirectionLA.algorithm(object);
        int windDirection = windDirectionLA.algorithm(object);

        return new Weather(weatherCondition, temperature, pressure, humidity, windSpeed, windDirection);
    }

    public void teach(List<Precedent> trainingSample){
        weatherConditionLA.teach(trainingSample);
        temperatureLA.teach(trainingSample);
        pressureLA.teach(trainingSample);
        humidityLA.teach(trainingSample);
        windDirectionLA.teach(trainingSample);
        windSpeedLA.teach(trainingSample);
    }

    public int lossFunction(Precedent<Weather> precedent){

        final int cTemperature = 1;
        final int cPressure = 1;
        final int cHumidity = 1;
        final int cWindDirection = 1;
        final int cWindSpeed = 1;
        final int cWeatherCondition = 1;

        Weather answer = algorithm(precedent.object);
        int loss = 0;
        loss += cTemperature * Math.abs(precedent.answer.getTemperature() - answer.getTemperature());
        loss += cPressure * Math.abs(precedent.answer.getPressure() - answer.getPressure());
        loss += cHumidity * Math.abs(precedent.answer.getHumidity() - answer.getHumidity());
        loss += cWindDirection * Math.abs(precedent.answer.getWindDirection() - answer.getWindDirection());
        loss += cWindSpeed * Math.abs(precedent.answer.getWindSpeed() - answer.getWindSpeed());
        if (precedent.answer.getWeatherCondition() == answer.getWeatherCondition()){
            loss += cWeatherCondition;
        }
        return loss;
    }

}
