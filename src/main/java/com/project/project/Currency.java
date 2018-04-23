package com.project.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.json.*;
public class Currency {

    // wydobywamy aktualna wartość walut z API NBP
    public double getCurrency(String currencyCode) {
        double currencyValue=1;
        try {
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/A/?format=json");
            connection = (HttpURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            //now to json
            String finalJSON = buffer.toString();
            JSONArray tableArray = new JSONArray(finalJSON);
            JSONObject mainObject = tableArray.getJSONObject(0);
            JSONArray rates = mainObject.getJSONArray("rates");
            for(int i=0;i<rates.length();i++){
                JSONObject currency = rates.getJSONObject(i);
                String code = currency.getString("code");
                Double value = currency.getDouble("mid");
                if (code.equals(currencyCode) )
                    currencyValue=value;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return (currencyValue);
    }
}