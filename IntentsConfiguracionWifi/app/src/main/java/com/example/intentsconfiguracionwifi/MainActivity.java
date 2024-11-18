package com.example.intentsconfiguracionwifi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Settings;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Método para abrir los settings
    public void onOpenSettingsClick(android.view.View view){
        Intent settingsIntent = new Intent(Settings.ACTION_SETTINGS);
        try {
            startActivity(settingsIntent);
        }catch (Exception e){
            Toast.makeText(this, "no se pudo abrir la configuración", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para abrir los settings
    public void onOpenWifiSettingsClick(android.view.View view){
        Intent wifiSettingsIntent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        try {
            startActivity(wifiSettingsIntent);
        }catch (Exception e){
            Toast.makeText(this, "no se pudo abrir la configuración de wifi", Toast.LENGTH_SHORT).show();
        }
    }

}