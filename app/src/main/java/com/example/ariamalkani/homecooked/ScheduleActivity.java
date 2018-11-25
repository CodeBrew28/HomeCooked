package com.example.ariamalkani.homecooked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class ScheduleActivity extends AppCompatActivity {

    Button attendButton;
    ImageView thumbnail;
    TextView chefNameView;
    TextView verifiedView;
    TextView ratingView;
    TextView veganView;
    TextView priceView;
    TextView locationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        populateData(getIntent());
        setButton();
    }

    private void populateData(Intent intent) {
        int thumbnailID = Integer.parseInt(intent.getStringExtra("THUMBNAIL"));
        thumbnail = findViewById(R.id.thumbnail);
        thumbnail.setImageResource(thumbnailID);

        chefNameView = findViewById(R.id.chef_name);
        String text = "Chef Name: " + intent.getStringExtra("CHEF_NAME");
        chefNameView.setText(text);

        verifiedView = findViewById(R.id.verified_bool);
        if (Boolean.parseBoolean(intent.getStringExtra("VERIFIED"))) {
            verifiedView.setText(getString(R.string.verified));
        } else {
            verifiedView.setText(getString(R.string.unverifeid));
        }

        ratingView = findViewById(R.id.rating);
        text = "Rating: " + intent.getStringExtra("RATING");
        ratingView.setText(text);

        veganView = findViewById(R.id.vegan);
        if (Boolean.parseBoolean(intent.getStringExtra("VEGAN"))) {
            veganView.setText(getString(R.string.vegan));
        } else {
            veganView.setText(getString(R.string.not_vegan));
        }

        priceView = findViewById(R.id.price);
        text = "Price: " + intent.getStringExtra("PRICE");
        priceView.setText(text);

        locationView = findViewById(R.id.location);
        text = "Location: " + intent.getStringExtra("LOCATION");
        locationView.setText(text);
    }

    private void setButton() {
        attendButton = findViewById(R.id.attend_button);
        attendButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PaymentActivity.class);
                startActivity(intent);
            }
        });
    }
}
