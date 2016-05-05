package kosshka.mebiusa.Classes.Distances;

import net.sf.javaml.core.Instance;
import net.sf.javaml.distance.DistanceMeasure;

/**
 * Created by kosshka_mebiusa on 02.05.16.
 */
public class LinearDistance implements DistanceMeasure {

    int[] coefs;

//    public LinearDistance(int[] coefs){
//        this.coefs = coefs;
//    }

    @Override
    public boolean compare(double v, double v1) {
        return v<v1;
    }

    @Override
    public double measure(Instance instance, Instance instance1) {
        double sum = 0;
        int i = 0;
/*
        for (double inst:instance) {
            sum += coefs[i]*inst;
            i = (i+1);
        }
*/
        for (double inst:instance) {
            sum += inst;
            i++;
        }

        return sum;
    }
}
