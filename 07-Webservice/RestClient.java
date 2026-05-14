import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class RestClient {

    public static void main(String[] args) {

        try {

            URL url = URI.create("http://localhost:8000/hello").toURL();

            HttpURLConnection conn =
                    (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(
                                    conn.getInputStream()));

            String output;

            System.out.println("Response from Web Service:");

            while ((output = br.readLine()) != null) {

                System.out.println(output);
            }

            conn.disconnect();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}