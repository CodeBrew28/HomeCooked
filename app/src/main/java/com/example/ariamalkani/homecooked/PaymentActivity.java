package com.example.ariamalkani.homecooked;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class PaymentActivity extends AppCompatActivity {

    Button button;

    @Override
    public void onCreate(final Bundle savedState) {
        super.onCreate(savedState);

        setContentView(R.layout.activity_payment);

        button = findViewById(R.id.pay_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(final View v) {
                Intent intent = getIntent();
                Meal meal = (Meal) intent.getSerializableExtra("SERIALIZED_MEAL");
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage(buildDialogMessage(meal));
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(v.getContext(), CentralActivity.class);
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });
    }

    private String buildDialogMessage(Meal meal) {
        return "Chef: " + meal.getChefName() + "\nPrice: " + meal.getAvgPrice()
                + "\nLocation: " + meal.getLocation();
    }


}
