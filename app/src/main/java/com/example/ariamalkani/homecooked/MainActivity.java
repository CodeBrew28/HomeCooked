package com.example.ariamalkani.homecooked;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private Button login;
    public static UserProfile selfUserProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        login = findViewById(R.id.login_button);
        username = findViewById(R.id.login_username);

        login.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(final View v) {
                if(createSelfUserProfile(username.getText().toString())) {
                    Intent intent = new Intent(v.getContext(), CentralActivity.class);
                    startActivity(intent);
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setMessage("Login unsuccessful");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }
            }
        });
    }


    private boolean createSelfUserProfile(String username){
        if(username.equals("user1")) {
            selfUserProfile = new UserProfile(1, "Bob", "Roberts", "lawbob@bob.com", "5144492360",
                    "1522 Clemment Blvd.", "Canton", StateClass.State.FLORIDA, 81845, false, false, true);
            return true;
        }
        if(username.equals("user2")) {
            selfUserProfile = new UserProfile(2, "Ray", "Smith", "ross123@gmail.com", "5767523360",
                    "7892 Atlee Blvd.", "Leeland", StateClass.State.NORTH_CAROLINA, 83453, true, true,  false);
            return true;
        }
        if(username.equals("user3")) {
            selfUserProfile = new UserProfile(3, "Dave", "Davis", "double@double.com", "8237983525",
                    "2056 Church Rd.", "Townsville", StateClass.State.OHIO, 45463, false, true, true);
            return true;
        }
        if(username.equals("user4")) {
            selfUserProfile = new UserProfile(4, "Glade", "McKay", "glade.mckary@gmail.com", "4563771178",
                    "45 Baker St.", "Missoula", StateClass.State.MISSOURI, 63112, false, true, true);
            return true;
        }

        return false;

    }
}
