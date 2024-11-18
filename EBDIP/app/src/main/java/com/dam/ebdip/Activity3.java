package com.dam.ebdip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    Button btnAyuda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        btnAyuda = findViewById(R.id.btnAyuda);
        btnAyuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                        Uri.parse("tel:+34917407272"));

                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                } else {
                    Toast.makeText(Activity3.this, R.string.no_accion, Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }
}