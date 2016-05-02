package kosshka.mebiusa.Classes.Distances;

import net.sf.javaml.core.Instance;
import net.sf.javaml.distance.DistanceMeasure;

/**
 * Created by kosshka_mebiusa on 02.05.16.
 */
public class LinearDistance implements DistanceMeasure {
    @Override
    public boolean compare(double v, double v1) {
        return Math.abs(v-v1)<0.1;
    }

    @Override
    public double measure(Instance instance, Instance instance1) {
        double sum = 0;
        for (double i:instance) {
            sum += i;
        }
        return sum;
    }
}
