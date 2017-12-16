package eu.execom.helenazecevic.monumentum.repository.task;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import eu.execom.helenazecevic.monumentum.models.Monument;
import eu.execom.helenazecevic.monumentum.models.User;

/**
 * Created by Stevan on 16-Dec-17.
 */

public class HttpRequestTask extends AsyncTask<Void, Void, User> {
    @Override
    protected User doInBackground(Void... params) {
        try {
            final String url = "https://vast-depths-82855.herokuapp.com/user";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            User greeting = restTemplate.getForObject(url, User.class);
            return greeting;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(User greeting) {
        Log.i("Stevan",greeting.getName() + greeting.getEmail());
    }

}
