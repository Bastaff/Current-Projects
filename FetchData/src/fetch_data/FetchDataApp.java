package fetch_data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchDataApp {

	public static void main(String[] args) throws IOException
    {

        getHistoricalCountryIndicator();

    }

    public static void constructUrl(String path) throws IOException
    {
        String _clientKey = "cg085gp1blld8mn:c2pvgpmopdbyqtc";
        String base_url = "https://api.tradingeconomics.com/historical/country/new%20zealand/indicator/gdp?c=cg085gp1blld8mn:c2pvgpmopdbyqtc&format=xml";
        String auth = base_url + path + "?c=" + _clientKey;

        URL obj = new URL(auth);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();


        System.out.println(response.toString());
    }


    
    public static void getHistoricalCountryIndicator() throws IOException {


        String params = "new zealand" + "/";
        params = params.replaceAll("\\s","%20");

        String params1 = "gdp";
        params1 = params1.replaceAll("\\s","%20");

        String path = "/historical/country" + "/" + params + "indicator/" +  params1;

        constructUrl(path);

    }


}
