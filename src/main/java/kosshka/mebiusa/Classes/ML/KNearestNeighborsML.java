package kosshka.mebiusa.Classes.ML;

import kosshka.mebiusa.Classes.Distances.LinearDistance;
import kosshka.mebiusa.Classes.Distances.QuadDistance;
import kosshka.mebiusa.DomainModel.Weather;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.KNearestNeighbors;
import net.sf.javaml.classification.evaluation.CrossValidation;
import net.sf.javaml.classification.evaluation.PerformanceMeasure;
import net.sf.javaml.core.Dataset;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by kosshka_mebiusa on 23.04.16.
 */
public class KNearestNeighborsML extends MLAlgorithm {

    List<Weather> weatherList;
    int weatherItem;

    public KNearestNeighborsML(List<Weather> weatherList, int weatherItem){
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

    private String distance;

    public void getDistance(String distance) {
        this.distance = distance;
    }



    public void bestParametrs(){

        int bestk = 0;
        int bestN = 0;
        double bestF = 0;
        String bestDistanse = "";
        for (int iN = min; iN < max; iN++)
            for (int ik = min; ik < max; ik++) {
                Dataset data = MachineLearning.makeDataset(weatherList, iN, weatherItem);

                distance = "Default";
                Classifier knn = new KNearestNeighbors(ik);
                CrossValidation cv = new CrossValidation(knn);
                Map<Object, PerformanceMeasure> p = cv.crossValidation(data, 5, new Random(1));
                double F = super.Fmeasure(p);
                if (F>bestF){
                    bestF = F;
                    bestk = ik;
                    bestN = iN;
                    bestDistanse = distance;
                }

//                for (int bin = 0; bin < 32; bin++){
//                    String str = Integer.toBinaryString(bin);
//                    str = "00000"+str;
//                    str = str.substring(str.length()-5);
//                    char[] chars = str.toCharArray();
//                    int[] array = new int[iN*5];
//                    for (int i = 0; i<5; i++ ){
//                        array[i] = (int)chars[i]-48;
//                    }
                    LinearDistance ld = new LinearDistance();
                    distance = "Linear";
                    knn = new KNearestNeighbors(ik, ld);
                    cv = new CrossValidation(knn);
                    p = cv.crossValidation(data, 5, new Random(1));
                    F = super.Fmeasure(p);
                    if (F>bestF){
                        bestF = F;
                        bestk = ik;
                        bestN = iN;
                        bestDistanse = distance;
                    }
//                }

                QuadDistance qd = new QuadDistance();
                distance = "Quad";
                knn = new KNearestNeighbors(ik, qd);
                cv = new CrossValidation(knn);
                p = cv.crossValidation(data, 5, new Random(1));
                F = super.Fmeasure(p);
                if (F>bestF){
                    bestF = F;
                    bestk = ik;
                    bestN = iN;
                    bestDistanse = distance;
                }

            }

        k = bestk;
        N = bestN;
        Fm = bestF;
        distance = bestDistanse;

    }

    @Override
    public String getParameteresString() {
        return "N = " + N + ", k = " + k + ", " + distance + " Distanse";
    }


}
