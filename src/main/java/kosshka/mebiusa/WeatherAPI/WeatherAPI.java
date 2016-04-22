package kosshka.mebiusa.WeatherAPI;

import kosshka.mebiusa.DomainModel.Weather;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.List;

import static javafx.scene.input.KeyCode.R;

public interface WeatherAPI {
    Weather getCurrentWeather(String city);

    List<Weather> getHistoricalWeather(String city, Date date);

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

    static JSONObject getJSON(String URL, String ID, String city, Date date){
        try {

            //connection
            URL url = new URL(String.format(URL, ID, city, date.toString()));
            HttpURLConnection connection =
                    (HttpURLConnection)url.openConnection();

/*            connection.addRequestProperty("x-api-key",
                    context.getString(R.string.open_weather_maps_app_id));*/

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp="";
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());

            return data;
        } catch(Exception e) {
            return null;
        }
    }

}
