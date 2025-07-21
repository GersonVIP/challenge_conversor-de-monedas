import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorDivisas {
    private static final String API_KEY = "71bdb801600de813b585d548";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";

    private JsonObject tasas;

    public ConversorDivisas() {
        this.tasas = cargarTasas();
    }

    private JsonObject cargarTasas() {
        try {
            URL url = new URL(BASE_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder respuesta = new StringBuilder();
            String linea;

            while ((linea = reader.readLine()) != null) {
                respuesta.append(linea);
            }

            reader.close();
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(respuesta.toString(), JsonObject.class);
            return json.getAsJsonObject("conversion_rates");

        } catch (Exception e) {
            System.out.println("Error al cargar tasas: " + e.getMessage());
            return null;
        }
    }

    public double convertir(String monedaDestino, double cantidad) {
        if (tasas != null && tasas.has(monedaDestino)) {
            return cantidad * tasas.get(monedaDestino).getAsDouble();
        } else {
            System.out.println("Moneda no disponible.");
            return -1;
        }
    }

    public double convertirInversa(String monedaOrigen, double cantidad) {
        if (tasas != null && tasas.has(monedaOrigen)) {
            return cantidad / tasas.get(monedaOrigen).getAsDouble();
        } else {
            System.out.println("Moneda no disponible.");
            return -1;
        }
    }
}
