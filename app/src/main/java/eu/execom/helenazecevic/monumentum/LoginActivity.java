package eu.execom.helenazecevic.monumentum;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EditorAction;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import eu.execom.helenazecevic.monumentum.models.User;
import eu.execom.helenazecevic.monumentum.repository.UserDAORepository;
import eu.execom.helenazecevic.monumentum.repository.task.HttpLoginTask;
import eu.execom.helenazecevic.monumentum.utils.Preferences_;

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {

    @ViewById
    EditText email;

    @ViewById
    EditText password;

    @Pref
    Preferences_ prefs;

    @ViewById
    Button login;

    @Bean
    UserDAORepository userDAORepository;



    @Override
    protected void onResume() {
        if (prefs.id().exists()) {
            NavigationActivity_.intent(this).username(userDAORepository.getLoggedInUser().getName()).start();
        }
        super.onResume();
    }

    @EditorAction(R.id.password)
    @Click
    void login()  {
        final User user = userDAORepository.logIn(email.getText().toString(), password.getText().toString());

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (user != null) {
            prefs.id().put(user.getId());
            NavigationActivity_.intent(this).username(user.getName()).start();

        } else {
            Toast.makeText(this, "Login failed!", Toast.LENGTH_LONG).show();
        }
    }

    @Click(R.id.registration)
    void register() {
        RegistrationActivity_.intent(this).flags(Intent.FLAG_ACTIVITY_NO_HISTORY).start();
    }
}
