package eu.execom.helenazecevic.monumentum.repository.task;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import eu.execom.helenazecevic.monumentum.models.User;

/**
 * Created by Stevan on 16-Dec-17.
 */

public class HttpLoginTask extends AsyncTask<User,User,User> {

    User logged;

    public User getLogged() {
        return logged;
    }

    public void setLogged(User logged) {
        this.logged = logged;
    }

    @Override
    protected User doInBackground(User... users) {
        try {

            final String url = "https://vast-depths-82855.herokuapp.com/login";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
            HttpEntity<User> request  = new HttpEntity<>(users[0]);
            User user = restTemplate.postForObject(url,request, User.class);
            logged=user;
            return user;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(User greeting) {
        Log.i("Stevan","Korisnik " + greeting.getId() + " je logovan!");

    }

}