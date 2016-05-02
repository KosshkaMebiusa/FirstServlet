package kosshka.mebiusa.Classes.ML;

import kosshka.mebiusa.DomainModel.Weather;
import net.sf.javaml.classification.AbstractMeanClassifier;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.MeanFeatureVotingClassifier;
import net.sf.javaml.classification.evaluation.CrossValidation;
import net.sf.javaml.classification.evaluation.PerformanceMeasure;
import net.sf.javaml.core.Dataset;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by kosshka_mebiusa on 27.04.16.
 */
public class AbstractMeanML extends MLAlgorithm {

    List<Weather> weatherList;
    int weatherItem;

    public AbstractMeanML(List<Weather> weatherList, int weatherItem) {
        this.weatherList = weatherList;
        this.weatherItem = weatherItem;
    }

    private int N;

    public int getN() {
        return N;
    }
    private double Fm;

    public double getFm() {
        return Fm;
    }

    @Override
    public void bestParametrs() {

        int bestN = 0;
        double bestF = 0;
        for (int iN = min; iN < max; iN++){
            Dataset data = MachineLearning.makeDataset(weatherList, iN, weatherItem);
            Classifier knn = new AbstractMeanClassifier();
            CrossValidation cv = new CrossValidation(knn);
            Map<Object, PerformanceMeasure> p = cv.crossValidation(data, 5, new Random(1));
            double F = super.Fmeasure(p);
            if (F>bestF){
                bestF = F;
                bestN = iN;
            }
        }

        N = bestN;
        Fm = bestF;

    }

    @Override
    public String getParameteresString()  {
        return "N = " + N;
    }

}
