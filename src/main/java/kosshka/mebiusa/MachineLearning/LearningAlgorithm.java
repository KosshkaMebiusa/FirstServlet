package kosshka.mebiusa.MachineLearning;

import java.util.List;

/**
 * Created by kosshka_mebiusa on 28.10.15.
 */
public interface LearningAlgorithm<E> {

    DecisionFunction<E> teach(List<Precedent<E>> trainingSampel);

    int lossFunction(Precedent<E> precedent);

    default double Q(List<Precedent> sample){
        int sum = 0;
        for (Precedent precedent: sample){
            sum += lossFunction(precedent);
        }
        return 1/sample.size() * sum;
    }

}
