import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        conversor conversor1 = new conversor();
        HttpClient client = HttpClient.newHttpClient();

        try {
            while(true) {


        System.out.println("Escriba la divisa de su propiedad\n" + conversor1.getMenu());
        String divisa = scanner.nextLine();

        System.out.println("Escriba la opcion correspondiente a la que necesite convertir\n" + conversor1.getMenu() + "\n");
        String divisa2 = scanner.nextLine();

        System.out.println("Escriba la cantidad de dinero que necesita convertir a la divisa requerida\n");
        String divisa3 = scanner.nextLine();

        conversor1.setMoneda(divisa);

        conversor1.setCambio(divisa2);

        conversor1.setConversor(Double.parseDouble(divisa3));

        String direccion = "https://v6.exchangerate-api.com/v6/20ee79510e460a55322d2368/pair/" + conversor1.getMoneda() + "/" + conversor1.getCambio() + "/" + conversor1.getConversor();


                HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

                HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
                 String json = response.body();

        Gson gson = new Gson();
        //gson.fromJson(json,conversor.class)


        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        // Obtener el objeto "conversion_rates"
        double conversionResult = jsonObject.get("conversion_result").getAsDouble();


        // Imprimir el valor obtenido
        System.out.println("El valor de la conversión es: " + conversionResult);

        System.out.println("¿Desea continuar? (s/n):");
        String continuar = scanner.nextLine();
        if (!continuar.equalsIgnoreCase("s")) {
            break;
        }
    }
} catch (IllegalArgumentException e) {
    System.out.println(e.getMessage());
    System.out.println("El programa se ha cancelado debido a un valor no válido.");
} catch (Exception e) {
    System.out.println("Se ha producido un error inesperado: " + e.getMessage());
}

    }



    }

