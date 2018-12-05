package com.example.ariamalkani.homecooked;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HostFinal extends AppCompatActivity {

    private Button submitMeal;
    private Button pictureSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_final);

        submitMeal = findViewById(R.id.submitMeal);
        pictureSubmit=findViewById(R.id.UploadPictures);

        submitMeal.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(final View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("Meal Submitted!");
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

        pictureSubmit.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(final View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage("This does nothing (yet)");
                builder.setPositiveButton("That's too bad", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }});
                builder.show();
            }
        });
    }
}
