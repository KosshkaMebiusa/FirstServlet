package kosshka.mebiusa.Servlets;

import kosshka.mebiusa.Classes.DataBase;
import kosshka.mebiusa.Classes.ML.*;
import kosshka.mebiusa.DomainModel.Weather;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
/*        DecisionFunction<String> algorithm;
        List<Weather> weatherList = DataBase.allWeather();
        int N = Integer.parseInt(req.getParameter("n"));
        Sample trainingSample = new Sample(weatherList.subList(0,(int)weatherList.size()/2),N,Weather.WEATHER_CONDITION);
        Sample testSample = new Sample(weatherList.subList((int)weatherList.size()/2+1,weatherList.size()-1),N,Weather.WEATHER_CONDITION);
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
        String algorithmName = req.getParameter("algorithm");
        req.setAttribute("algorithm", algorithmName);
        RequestDispatcher rd = req.getRequestDispatcher("/testResult.jsp");
        rd.forward(req,resp);*/

        List<Weather> weatherList = DataBase.allWeather();
        String algorithmName = req.getParameter("algorithm");
        int weatherItem = Integer.parseInt(req.getParameter("testitem"));
        double P=0;
        String paramStr = "";
        MLAlgorithm algorithm = null;
        switch (algorithmName){
            case "kNN":
                algorithm = new KNearestNeighborsML(weatherList, weatherItem);
                break;
            case "KDtreeKNN":
                algorithm = new KDtreeKNNML(weatherList, weatherItem);
                break;

            case "MFV":
                algorithm = new MeanFeatureVotingML(weatherList, weatherItem);
                break;
            case "AbstrMean":
                algorithm = new AbstractMeanML(weatherList,weatherItem);
                break;
            case "NearestMean":
                algorithm = new NearestMeanML(weatherList,weatherItem);
                break;
            case "ZeroR":
                algorithm = new ZeroRML(weatherList,weatherItem);
                break;
            case "RandTree":
                algorithm = new RandomTreeML(weatherList,weatherItem);
                break;

        }
        algorithm.bestParametrs();
        paramStr = algorithm.getParameteresString();
        P = algorithm.getP();


        req.setAttribute("algorithm", algorithmName);
        req.setAttribute("P", P);
        req.setAttribute("params", paramStr);
        RequestDispatcher rd = req.getRequestDispatcher("/testResult.jsp");
        rd.forward(req,resp);

    }
}
