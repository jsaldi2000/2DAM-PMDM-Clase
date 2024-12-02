package com.example.fragmentosestaticos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CicloDeVida"; // Etiqueta para los Logs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Traza logcat
        //Log.d(TAG, "onCreate Main llamado");

    }

    @Override
    protected void onStart() {
        super.onStart();
        //Log.d(TAG, "onStart Main llamado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Log.d(TAG, "onResume Main llamado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Log.d(TAG, "onPause Main llamado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Log.d(TAG, "onStop Main llamado");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //Log.d(TAG, "onSaveInstanceState Main llamado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Log.d(TAG, "onDestoy Main llamado");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Log.d(TAG, "onRestoreInstanceState Main llamado");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //Log.d(TAG, "onRestart Main llamado");
    }


}