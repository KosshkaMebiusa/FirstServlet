package kosshka.mebiusa.Classes.ML;

/**
 * Created by kosshka_mebiusa on 24.04.16.
 */
public abstract class MLAlgorithm {

    protected int min = 1;
    protected int max = 10;

    public abstract void bestParametrs();

    public abstract String getParameteresString();

    public abstract double getP();

}
