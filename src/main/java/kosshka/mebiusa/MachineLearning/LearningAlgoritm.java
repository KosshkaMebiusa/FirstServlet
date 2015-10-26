package kosshka.mebiusa.MachineLearning;

import kosshka.mebiusa.Weather.Weather;

import java.util.List;

/**
 * Created by kosshka_mebiusa on 26.10.15.
 */
public interface LearningAlgoritm {

    Weather algorithm(List<Weather> object);

    void teach(List<Precedent> trainingSampel);

    default int lossFunction(Precedent precedent){

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

    default double Q(List<Precedent> sample){
        int sum = 0;
        for (Precedent precedent: sample){
            sum += lossFunction(precedent);
        }
        return 1/sample.size() * sum;
    }

}
