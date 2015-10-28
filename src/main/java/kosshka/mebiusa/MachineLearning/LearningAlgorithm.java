package kosshka.mebiusa.MachineLearning;

import kosshka.mebiusa.DomainModel.Weather;

import java.util.List;

/**
 * Created by kosshka_mebiusa on 28.10.15.
 */
public interface LearningAlgorithm<E> {

    E algorithm(List<Weather> object);

    void teach(List<Precedent> trainingSampel);

    int lossFunction(Precedent<E> precedent);

    default double Q(List<Precedent> sample){
        int sum = 0;
        for (Precedent precedent: sample){
            sum += lossFunction(precedent);
        }
        return 1/sample.size() * sum;
    }

}
