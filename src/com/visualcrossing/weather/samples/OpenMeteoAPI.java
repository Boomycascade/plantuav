import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenMeteoAPI {
    public static void main(String[] args) throws Exception {
        String latitude = "51.5074"; // Replace with desired latitude
        String longitude = "-0.1278"; // Replace with desired longitude
        String apiUrl = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude + "&hourly=temperature_2m&daily=weathercode&timezone=auto";

        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        JSONObject obj = new JSONObject(content.toString());
        //int a = obj.getInt("temperature_2m");
        string a = obj.getstring("temperature_2m");
        System.out.println(obj.toString(2));
       // System.out.println(a);
    }
}