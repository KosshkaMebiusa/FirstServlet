package kosshka.mebiusa.Classes.ML;

import kosshka.mebiusa.DomainModel.Weather;
import net.sf.javaml.classification.AbstractMeanClassifier;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.NearestMeanClassifier;
import net.sf.javaml.classification.evaluation.CrossValidation;
import net.sf.javaml.classification.evaluation.PerformanceMeasure;
import net.sf.javaml.core.Dataset;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by kosshka_mebiusa on 27.04.16.
 */
public class NearestMeanML extends MLAlgorithm {

    List<Weather> weatherList;
    int weatherItem;

    public NearestMeanML(List<Weather> weatherList, int weatherItem) {
        this.weatherList = weatherList;
        this.weatherItem = weatherItem;
    }

    private int N;

    public int getN() {
        return N;
    }

    private double P;

    public double getP() {
        return P;
    }

    @Override
    public void bestParametrs() {

        int bestN = 0;
        double bestp = 0;
        for (int iN = min; iN < max; iN++){
            Dataset data = MachineLearning.makeDataset(weatherList, iN, weatherItem);
            Classifier knn = new NearestMeanClassifier();
            CrossValidation cv = new CrossValidation(knn);
            Map<Object, PerformanceMeasure> p = cv.crossValidation(data, 5, new Random(1));
            double Psum=0;
            for (PerformanceMeasure performanceMeasure:p.values()){
                Psum += performanceMeasure.getAccuracy();
            }
            Psum = Psum / p.values().size();

            if (Psum>bestp){
                bestp = Psum;
                bestN = iN;
            }
        }

        N = bestN;
        P = bestp;

    }

    @Override
    public String getParameteresString()  {
        return "N = " + N;
    }

}
