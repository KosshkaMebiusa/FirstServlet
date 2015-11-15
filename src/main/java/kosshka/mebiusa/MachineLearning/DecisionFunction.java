package kosshka.mebiusa.MachineLearning;

import kosshka.mebiusa.DomainModel.Weather;

import java.util.List;

@FunctionalInterface
public interface DecisionFunction<E> {
    E calculate(List<Weather> object);
}
