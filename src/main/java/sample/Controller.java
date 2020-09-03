package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Controller {

    @FXML
    private Button button;

    @FXML
    private TextField url;

    @FXML
    private TextArea tarea;

    @FXML
    void click(ActionEvent event) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url.getText())
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response);

            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                tarea.appendText(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }

            tarea.appendText(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
