package kosshka.mebiusa.MachineLearning;

import kosshka.mebiusa.DomainModel.Weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherLA implements LearningAlgorithm<Weather> {

    LearningAlgorithm<String> weatherConditionLA;
    LearningAlgorithm<Integer> temperatureLA;

    DecisionFunction<Weather> algorithm;

    public DecisionFunction<Weather> teach(Sample trainingSample){

        //выборки для отдельных алгоритмов
        List<Precedent<String>> weatherConditionSample = new ArrayList<>();
        List<Precedent<Integer>> temperatureSample = new ArrayList<>();

        for (Precedent<Weather> precedent : trainingSample.sample){

            Precedent<String> weatherConditionPrecedent = new Precedent();
            weatherConditionPrecedent.object = precedent.object;
            weatherConditionPrecedent.answer = precedent.answer.getWeatherCondition();
            weatherConditionSample.add(weatherConditionPrecedent);

            Precedent<Integer> tempPrecedent = new Precedent();
            tempPrecedent.object = precedent.object;
            tempPrecedent.answer = precedent.answer.getTemperature();
            temperatureSample.add(tempPrecedent);

        }
        DecisionFunction<Weather> algorithm = (List<Weather> object) ->{
            Weather weather;

//            DecisionFunction<String> weatherConditionAlgorithm = weatherConditionLA.teach(weatherConditionSample);
//            String weatherCondition = weatherConditionAlgorithm.calculate(object);
//
//            DecisionFunction<Integer> tempAlgorithm = temperatureLA.teach(temperatureSample);
//            Integer temperature = tempAlgorithm.calculate(object);
//
//            weather = new Weather(weatherCondition,temperature,0,0,0,0);
//            return  weather;
            return null;
        };
        this.algorithm = algorithm;
        return  algorithm;
    }

    public int lossFunction(Precedent<Weather> precedent){

        final int cTemperature = 1;
        final int cPressure = 1;
        final int cHumidity = 1;
        final int cWindDirection = 1;
        final int cWindSpeed = 1;
        final int cWeatherCondition = 1;

        Weather answer = algorithm.calculate(precedent.object);
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
