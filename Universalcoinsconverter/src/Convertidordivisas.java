//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Map;
import java.util.Scanner;

public class Convertidordivisas{
    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private final String apiKey;

    public Convertidordivisas(String apiKey) {
        this.apiKey = apiKey;
    }

    public void Convertidordivisas(String monedaOrigen, String monedaDestino) {
        try {
            URI uri = this.buildURI(monedaOrigen);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().GET().uri(uri).build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                RespuestaTasaDivisas respuesta = (RespuestaTasaDivisas)gson.fromJson((String)response.body(), RespuestaTasaDivisas.class);
                if (respuesta != null && respuesta.getConversionRates() != null) {
                    Map<String, Double> conversionRates = respuesta.getConversionRates();
                    if (conversionRates.containsKey(monedaDestino)) {
                        double tasa = (Double)conversionRates.get(monedaDestino);
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Digita la cantidad que quieres convertir (" + monedaOrigen + " a " + monedaDestino + "): ");
                        double cantidad = scanner.nextDouble();
                        double cantidadConvertida = cantidad * tasa;
                        System.out.println("" + cantidad + " " + monedaOrigen + " equivale a " + cantidadConvertida + " " + monedaDestino);
                    } else {
                        System.out.println("tasa no encontrada " + monedaDestino);
                    }
                } else {
                    System.out.println("La API no contiene los datos solicitados.");
                }
            } else {
                System.out.println("Error al realizar la solicitud. Código de estado: " + response.statusCode());
            }
        } catch (InterruptedException | URISyntaxException | IOException var17) {
            Exception e = var17;
            System.err.println("Error al realizar la solicitud: " + e.getMessage());
        }

    }

    private URI buildURI(String monedaOrigen) throws URISyntaxException {
        String url = "https://v6.exchangerate-api.com/v6/" + this.apiKey + "/latest/" + monedaOrigen;
        return new URI(url);
    }
}
