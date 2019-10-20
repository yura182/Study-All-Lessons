package lesson14.np;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequest {
    private final URL url;

    public PostRequest(URL url) {
        this.url = url;
    }

    public String request(String json) throws IOException {
        HttpURLConnection postConnection = (HttpURLConnection) url.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();

        os.write(json.getBytes());
        os.flush();
        os.close();

        if (postConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()))) {
                for (String inputLine; (inputLine = in.readLine()) != null; ) {
                    response.append(inputLine);
                }
            }
            JSONObject jsonObject = new JSONObject(response.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            return jsonArray.toString();
        }
        return "";
    }

}
