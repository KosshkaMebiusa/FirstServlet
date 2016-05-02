package kosshka.mebiusa.Classes.ML;

import kosshka.mebiusa.DomainModel.Weather;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.KNearestNeighbors;
import net.sf.javaml.classification.evaluation.CrossValidation;
import net.sf.javaml.classification.evaluation.PerformanceMeasure;
import net.sf.javaml.classification.tree.RandomTree;
import net.sf.javaml.core.Dataset;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by kosshka_mebiusa on 27.04.16.
 */
public class RandomTreeML extends MLAlgorithm{
    List<Weather> weatherList;
    int weatherItem;

    public RandomTreeML(List<Weather> weatherList, int weatherItem){
        this.weatherList = weatherList;
        this.weatherItem = weatherItem;
    }

    private int k;

    public int getK() {
        return k;
    }

    private int N;

    public int getN() {
        return N;
    }

    private double Fm;

    public double getFm() {
        return Fm;
    }

    public void bestParametrs(){

        int bestk = 0;
        int bestN = 0;
        double bestF = 0;
        for (int iN = min; iN < max; iN++)
            for (int ik = min; ik < max; ik++) {
                Dataset data = MachineLearning.makeDataset(weatherList, iN, weatherItem);
                Classifier knn = new RandomTree(k,new Random(5));
                CrossValidation cv = new CrossValidation(knn);
                Map<Object, PerformanceMeasure> p = cv.crossValidation(data, 5, new Random(1));
                double F = super.Fmeasure(p);
                if (F>bestF){
                    bestF = F;
                    bestk = ik;
                    bestN = iN;
                }
            }

        k = bestk;
        N = bestN;
        Fm = bestF;

    }

    @Override
    public String getParameteresString() {
        return "N = " + N + ", k = " + k;
    }

}
