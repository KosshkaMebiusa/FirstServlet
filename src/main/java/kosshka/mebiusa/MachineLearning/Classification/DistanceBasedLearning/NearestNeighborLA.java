package kosshka.mebiusa.MachineLearning.Classification.DistanceBasedLearning;

import kosshka.mebiusa.DomainModel.Weather;
import kosshka.mebiusa.MachineLearning.DecisionFunction;
import kosshka.mebiusa.MachineLearning.Precedent;
import kosshka.mebiusa.MachineLearning.Sample;

import java.util.List;

/**
 * Created by kosshka_mebiusa on 15.11.15.
 */
public class NearestNeighborLA extends DistanceBasedLA {

    DecisionFunction<String> algorithm;

    @Override
    int omega(int i, List<Weather> weatherList) {
        if (i == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public DecisionFunction<String> teach(Sample trainingSampel) {
        DecisionFunction<String> algorithm = (List<Weather> object) ->{
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
        };;

        return algorithm;
    }

    @Override
    public int lossFunction(Precedent<String> precedent) {
        String answer = algorithm.calculate(precedent.object);
        if (answer.equals(precedent.answer)){
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public double Q(Sample testSample) {
        int result=0;
        for (Precedent<String> precedent: testSample.sample){
            result += lossFunction(precedent);
        }
        return result;
    }
}
