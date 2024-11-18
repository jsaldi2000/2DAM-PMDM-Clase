package com.example.intentsimplicitosconfiguracionwifi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Método para abrir la configuración principal del dispositivo
    public void onOpenSettingsClick(android.view.View view) {
        Intent settingsIntent = new Intent(Settings.ACTION_SETTINGS);
        try {
            startActivity(settingsIntent);
        } catch (Exception e) {
            Toast.makeText(this, "No se pudo abrir la configuración principal", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para abrir la configuración de Wi-Fi
    public void onOpenWifiSettingsClick(android.view.View view) {
        Intent wifiSettingsIntent = new Intent(Settings.ACTION_WIFI_SETTINGS);
        try {
            startActivity(wifiSettingsIntent);
        } catch (Exception e) {
            Toast.makeText(this, "No se pudo abrir la configuración de Wi-Fi", Toast.LENGTH_SHORT).show();
        }
    }
}
