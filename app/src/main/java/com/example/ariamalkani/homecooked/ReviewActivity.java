package com.example.ariamalkani.homecooked;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReviewActivity extends AppCompatActivity {
    Button submitButton;
    Button reportButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        submitButton = findViewById(R.id.submitReviewButton);
        reportButton = findViewById(R.id.reportButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(final View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Review submitted!");
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


}
