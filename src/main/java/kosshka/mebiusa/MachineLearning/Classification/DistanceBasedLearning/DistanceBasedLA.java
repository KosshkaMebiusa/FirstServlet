package kosshka.mebiusa.MachineLearning.Classification.DistanceBasedLearning;

import kosshka.mebiusa.DomainModel.Weather;
import kosshka.mebiusa.MachineLearning.LearningAlgorithm;
import kosshka.mebiusa.MachineLearning.Sample;

import java.util.List;
import java.util.Set;

public abstract class DistanceBasedLA implements LearningAlgorithm<String>{

    int distance(Weather weather1, Weather weather2){
        final int cTemperature = 1;
        final int cPressure = 1;
        final int cHumidity = 1;
        final int cWindDirection = 1;
        final int cWindSpeed = 1;
        final int cWeatherCondition = 1;

        int dist = 0;
        dist += cTemperature * Math.abs(weather1.getTemperature() - weather2.getTemperature());
        dist += cPressure * Math.abs(weather1.getPressure() - weather2.getPressure());
        dist += cHumidity * Math.abs(weather1.getHumidity() - weather2.getHumidity());
        dist += cWindDirection * Math.abs(weather1.getWindDirection() - weather2.getWindDirection());
        dist += cWindSpeed * Math.abs(weather1.getWindSpeed() - weather2.getWindSpeed());
        if (weather1.getWeatherCondition() == weather2.getWeatherCondition()){
            dist += cWeatherCondition;
        }
        return dist;
    }

    abstract int omega(int i, List<Weather> weatherList );

    Set<String> Y;

    int gammaY(List<Weather> u, Sample sample, String Y){
        int sum = 0;
        for (int i = 1; i <= sample.sample.size(); i++){
            if (sample.sample.get(i).answer.equals(Y)){
                sum += omega(i, u);
            }
        }
        return sum;
    }

}
