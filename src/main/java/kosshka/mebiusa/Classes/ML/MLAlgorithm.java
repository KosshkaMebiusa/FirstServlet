package kosshka.mebiusa.Classes.ML;

import net.sf.javaml.classification.evaluation.PerformanceMeasure;

import java.util.Map;

/**
 * Created by kosshka_mebiusa on 24.04.16.
 */
public abstract class MLAlgorithm {

    protected int min = 1;
    protected int max = 10;

    public abstract void bestParametrs();

    public abstract String getParameteresString();

    public abstract double getFm();

    protected double Fmeasure(Map<Object, PerformanceMeasure> p){
        double F=0;
        for (PerformanceMeasure performanceMeasure:p.values()){
            F += performanceMeasure.getFMeasure();
        }
        return F/p.size();
    }

}
