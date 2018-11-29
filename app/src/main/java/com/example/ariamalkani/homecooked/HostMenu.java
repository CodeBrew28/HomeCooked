package com.example.ariamalkani.homecooked;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HostMenu extends AppCompatActivity {
    private Button continueButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_menu);

        continueButton=findViewById(R.id.continue2);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(final View v) {
                        Intent intent = new Intent(v.getContext(), HostFinal.class);
                        startActivity(intent);
            }
        });
    }
}
