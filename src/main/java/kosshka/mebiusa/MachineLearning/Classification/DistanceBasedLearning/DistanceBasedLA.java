package kosshka.mebiusa.MachineLearning.Classification.DistanceBasedLearning;

import kosshka.mebiusa.DomainModel.Weather;
import kosshka.mebiusa.MachineLearning.LearningAlgorithm;
import kosshka.mebiusa.MachineLearning.Sample;

import java.util.List;
import java.util.Set;

public abstract class DistanceBasedLA implements LearningAlgorithm<String>{

    int distance(List<Weather> object1, List<Weather> object2){
        final int cTemperature = 1;
        final int cPressure = 1;
        final int cHumidity = 1;
        final int cWindDirection = 1;
        final int cWindSpeed = 1;
        final int cWeatherCondition = 1;

        int dist = 0;
        for (int i = 0; i < object1.size()-1; i++) {
            dist += cTemperature * Math.abs(object1.get(i).getTemperature() - object2.get(i).getTemperature());
            dist += cPressure * Math.abs(object1.get(i).getPressure() - object2.get(i).getPressure());
            dist += cHumidity * Math.abs(object1.get(i).getHumidity() - object2.get(i).getHumidity());
            dist += cWindDirection * Math.abs(object1.get(i).getWindDirection() - object2.get(i).getWindDirection());
            dist += cWindSpeed * Math.abs(object1.get(i).getWindSpeed() - object2.get(i).getWindSpeed());
            if (object1.get(i).getWeatherCondition().equals(object2.get(i).getWeatherCondition())){
                dist += cWeatherCondition;
        }

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
