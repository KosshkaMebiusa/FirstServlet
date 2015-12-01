package kosshka.mebiusa.MachineLearning.Classification.DistanceBasedLearning;

import kosshka.mebiusa.DomainModel.Weather;
import kosshka.mebiusa.MachineLearning.DecisionFunction;
import kosshka.mebiusa.MachineLearning.Precedent;
import kosshka.mebiusa.MachineLearning.Sample;
import java.util.List;

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
    public DecisionFunction<String> teach(Sample trainingSample) {
        DecisionFunction<String> algorithm = (List<Weather> object) ->{
            int minDist = Integer.MAX_VALUE;
            String minDistAnswer = "";
            for (Precedent<String> precedent : trainingSample.sample) {
                int curDist = distance(precedent.object,object);
                if (curDist < minDist){
                    minDist = curDist;
                    minDistAnswer = precedent.answer;
                }
            }
            return minDistAnswer;
        };

        this.algorithm = algorithm;
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
