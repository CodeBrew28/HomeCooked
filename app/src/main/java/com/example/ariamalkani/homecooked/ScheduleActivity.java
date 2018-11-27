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
        Intent intent = getIntent();
        populateData(intent);
        setButton(intent);
    }

    private void populateData(Intent intent) {
        Meal meal = (Meal) intent.getSerializableExtra("SERIALIZED_MEAL");

        thumbnail = findViewById(R.id.thumbnail);
        thumbnail.setImageResource(meal.getThumbnail());

        chefNameView = findViewById(R.id.chef_name);
        String text = "Chef: " + meal.getChefName();
        chefNameView.setText(text);

        verifiedView = findViewById(R.id.verified_bool);
        if (meal.getVerified()) {
            verifiedView.setText(getString(R.string.verified));
        } else {
            verifiedView.setText(getString(R.string.unverifeid));
        }

        ratingView = findViewById(R.id.rating);
        text = "Rating: " + meal.getRating();
        ratingView.setText(text);

        veganView = findViewById(R.id.vegan);
        if (meal.getVegan()) {
            veganView.setText(getString(R.string.vegan));
        } else {
            veganView.setText(getString(R.string.not_vegan));
        }

        priceView = findViewById(R.id.price);
        text = "Price: " + meal.getAvgPrice();
        priceView.setText(text);

        locationView = findViewById(R.id.location);
        text = "Location: " + meal.getLocation();
        locationView.setText(text);
    }

    private void setButton(Intent intent) {
        final Meal meal = (Meal) intent.getSerializableExtra("SERIALIZED_MEAL");
        attendButton = findViewById(R.id.attend_button);
        attendButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PaymentActivity.class);
                intent.putExtra("SERIALIZED_MEAL", meal);
                startActivity(intent);
            }
        });
    }
}
