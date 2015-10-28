package kosshka.mebiusa.WeatherAPI;

import kosshka.mebiusa.DomainModel.Weather;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public interface WeatherAPI {
    Weather getCurrentWeather(String city);

    static JSONObject getJSON(String URL, String ID, String city){
        try {

            //connection
            URL url = new URL(String.format(URL, ID, city));
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            //reading jsonobject
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer json = new StringBuffer();
            String tmp = "";
            while ((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();
            JSONObject data = new JSONObject(json.toString());

            return data;
        } catch(Exception e) {
            return null;
        }
    }

}
