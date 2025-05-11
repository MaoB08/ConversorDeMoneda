package Logic;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class Logic {
    public void getConvertion(String baseCurrency, String toCurrency){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el monto en "+ baseCurrency +": ");
        double monto = scanner.nextDouble();
        try {
            String apiKey = "4478accef2cf8c9a78518a9a";
            String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            Gson gson = new Gson();
            Cash exchangeResponse = gson.fromJson(response.toString(), Cash.class);


            double tasa = exchangeResponse.conversion_rates.get(toCurrency);


            double result = monto * tasa;

            System.out.println(monto + baseCurrency + "equivale a " + result + toCurrency);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void allCurrencies(){
        try {
            String apiKey = "4478accef2cf8c9a78518a9a";
            String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/codes";

            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            Gson gson = new Gson();
            CurrencyResponse currencyResponse = gson.fromJson(response.toString(), CurrencyResponse.class);

            System.out.println("Monedas admitidas:");
            for (String[] moneda : currencyResponse.supported_codes) {
                System.out.println(moneda[0] + " - " + moneda[1]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
