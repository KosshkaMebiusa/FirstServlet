package kosshka.mebiusa.Servlets;

import kosshka.mebiusa.Classes.DataBase;
import kosshka.mebiusa.DomainModel.Weather;
import kosshka.mebiusa.MachineLearning.Classification.DistanceBasedLearning.NearestNeighborLA;
import kosshka.mebiusa.MachineLearning.DecisionFunction;
import kosshka.mebiusa.MachineLearning.LearningAlgorithm;
import kosshka.mebiusa.MachineLearning.Precedent;
import kosshka.mebiusa.MachineLearning.Sample;
import kosshka.mebiusa.MachineLearning.TestResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kosshka_mebiusa on 30.11.15.
 */
public class TestLAServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/test.jsp");
        rd.forward(req, resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DecisionFunction<String> algorithm;
        List<Weather> weatherList = DataBase.allWeather();
        Sample trainingSample = new Sample(weatherList.subList(0,(int)weatherList.size()/2),5,Weather.WEATHER_DISCRIPTION);
        Sample testSample = new Sample(weatherList.subList((int)weatherList.size()/2+1,weatherList.size()-1),5,Weather.WEATHER_DISCRIPTION);
        LearningAlgorithm<String> learningAlgorithm = new NearestNeighborLA();
        algorithm = learningAlgorithm.teach(trainingSample);

        List<TestResult> results = new ArrayList();
        for (Precedent<String> precedent: testSample.sample){
            TestResult result = new TestResult();
            result.setObject(precedent.object);
            result.setRealAnswer(precedent.answer);
            result.setAnswer(algorithm.calculate(precedent.object));
            results.add(result);
        }

        double Q = learningAlgorithm.Q(testSample);

        req.setAttribute("list", results);
        req.setAttribute("Q", Q);
        RequestDispatcher rd = req.getRequestDispatcher("/testResult.jsp");
        rd.forward(req,resp);

    }
}
