package JavaProgramming;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String BASE_URL = "https://api.exchangeratesapi.io/latest?base=";
    private static final String API_BASE_CURRENCY = "USD"; // The base currency for the API (you can change it if needed)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the source currency (3-letter code): ");
        String sourceCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (3-letter code): ");
        String targetCurrency = scanner.next().toUpperCase();

        try {
            double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);
            System.out.println(amount + " " + sourceCurrency + " = " + convertedAmount + " " + targetCurrency);
        } catch (IOException e) {
            System.out.println("Error fetching data from the API.");
        }
    }

    private static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) throws IOException {
        String apiUrl = BASE_URL + API_BASE_CURRENCY;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            response.append(line);
        }

        bufferedReader.close();
        connection.disconnect();

        JSONObject jsonResponse = new JSONObject(response.toString());
        JSONObject rates = jsonResponse.getJSONObject("rates");

        double sourceRate = rates.getDouble(sourceCurrency);
        double targetRate = rates.getDouble(targetCurrency);

        // Convert the amount from source currency to base currency (USD)
        double amountInBaseCurrency = amount / sourceRate;

        // Convert the amount from base currency (USD) to the target currency
        return amountInBaseCurrency * targetRate;
    }
}
