package kosshka.mebiusa.Classes.ML;

import kosshka.mebiusa.DomainModel.Weather;
import net.sf.javaml.core.*;

import java.util.List;

/**
 * Created by kosshka_mebiusa on 23.04.16.
 */
public class MachineLearning {

    //make instance from weatherList with k element starting with k element. value is weather item type
    private static Instance makeInstance(List<Weather> weatherList, int k, int N, int weatherItem) {

        double[] values = new double[5*N];

        for (int i = k; i < k+N; i++) {
            values[i-k] = weatherList.get(i).getTemperature();
            values[i-k+1] = weatherList.get(i).getPressure();
            values[i-k+2] = weatherList.get(i).getHumidity();
            values[i-k+3] = weatherList.get(i).getWindSpeed();
            values[i-k+4] = weatherList.get(i).getWindDirection();

        }

        Instance instance = new DenseInstance(values);

        switch (weatherItem){
            case Weather.TEMPERATURE:
                instance.setClassValue(weatherList.get(k+N).getTemperature());
                break;
            case Weather.PRESSURE:
                instance.setClassValue(weatherList.get(k+N).getPressure());
                break;
            case Weather.HUMIDITY:
                instance.setClassValue(weatherList.get(k+N).getHumidity());
                break;
            case Weather.WIND_SPEED:
                instance.setClassValue(weatherList.get(k+N).getWindSpeed());
                break;
            case Weather.WIND_DIRECTION:
                instance.setClassValue(weatherList.get(k+N).getWindDirection());
                break;
            case Weather.WEATHER_CONDITION:
                instance.setClassValue(weatherList.get(k+N).getWeatherCondition());
                break;

        }
        return instance;
    }

    //make dataset from weatherList with N elements in instance, value is weather item type
    public static Dataset makeDataset(List<Weather> weatherList, int N, int weatherItem){

        Dataset data = new DefaultDataset();

        for (int i = 0; i < weatherList.size()-N; i++) {
            Instance instance = makeInstance(weatherList, i, N, weatherItem);
            data.add(instance);
        }

        return data;
    }

    public static MLAlgorithm bestAlgorithm(List<Weather> weatherList, int weatherItem){
        MLAlgorithm[] mlAlgorithms = new MLAlgorithm[]
                {new KNearestNeighborsML(weatherList, weatherItem), new KDtreeKNNML(weatherList, weatherItem),
                new MeanFeatureVotingML(weatherList, weatherItem),/* new AbstractMeanML(weatherList, weatherItem),*/
                new NearestMeanML(weatherList,weatherItem), new ZeroRML(weatherList,weatherItem)};

        double bestP=0;
        MLAlgorithm bestAlgorithm = null;

        for (MLAlgorithm mlAlgorithm: mlAlgorithms) {
            mlAlgorithm.bestParametrs();
            double P = mlAlgorithm.getP();
            if (P>bestP) bestP = P;
            bestAlgorithm = mlAlgorithm;
        }

        return bestAlgorithm;
    }

}

