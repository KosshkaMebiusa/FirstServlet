package kosshka.mebiusa.MachineLearning;

/**
 * Created by kosshka_mebiusa on 28.10.15.
 */
public interface LearningAlgorithm<E> {

    DecisionFunction<E> teach(Sample trainingSample);

    int lossFunction(Precedent<E> precedent);

    default double Q(Sample sample){
        int sum = 0;
        for (Precedent precedent: sample.sample){
            sum += lossFunction(precedent);
        }
        return 1/sample.sample.size() * sum;
    }

}
