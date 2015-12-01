package kosshka.mebiusa.MachineLearning;

import kosshka.mebiusa.DomainModel.Weather;

import java.util.List;

/**
 * Created by kosshka_mebiusa on 01.12.15.
 */
public class TestResult<E> {
    private List<Weather> object;
    private E realAnswer;
    private E answer;

    public List<Weather> getObject() {
        return object;
    }

    public void setObject(List<Weather> object) {
        this.object = object;
    }

    public E getRealAnswer() {
        return realAnswer;
    }

    public void setRealAnswer(E realAnswer) {
        this.realAnswer = realAnswer;
    }

    public E getAnswer() {
        return answer;
    }

    public void setAnswer(E answer) {
        this.answer = answer;
    }
}
