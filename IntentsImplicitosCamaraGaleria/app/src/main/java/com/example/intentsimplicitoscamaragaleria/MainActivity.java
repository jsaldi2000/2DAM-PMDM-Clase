package com.example.intentsimplicitoscamaragaleria;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView; // ImageView donde se mostrará la foto capturada

    // Configuración del ActivityResultLauncher para manejar la cámara
    private final ActivityResultLauncher<Intent> cameraLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    // Obtener la imagen capturada como Bitmap
                    Bitmap imageBitmap = (Bitmap) result.getData().getExtras().get("data");
                    // Mostrar la imagen en el ImageView
                    imageView.setImageBitmap(imageBitmap);
                }
            }
    );

    // Configuración del ActivityResultLauncher para manejar la galería
    private final ActivityResultLauncher<Intent> galleryLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Uri selectedImage = result.getData().getData();
                    if (selectedImage != null) {
                        imageView.setImageURI(selectedImage);
                    } else {
                        Toast.makeText(this, "No se seleccionó ninguna imagen", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "No se seleccionó ninguna imagen", Toast.LENGTH_SHORT).show();
                }
            }
    );

    // Configuración del ActivityResultLauncher para manejar la selección con ACTION_GET_CONTENT
    private final ActivityResultLauncher<Intent> contentLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Uri selectedImageUri = result.getData().getData();
                    if (selectedImageUri != null) {
                        imageView.setImageURI(selectedImageUri);
                    } else {
                        Toast.makeText(this, "No se seleccionó ninguna imagen", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "No se seleccionó ninguna imagen", Toast.LENGTH_SHORT).show();
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Vincular el ImageView al XML
        imageView = findViewById(R.id.imageView);
    }

    // Método para lanzar el intent de la cámara
    public void onOpenCameraClick(android.view.View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            cameraLauncher.launch(takePictureIntent);
        } catch (ActivityNotFoundException e) {
            // Mostrar un mensaje si no se encuentra una app de cámara
            Toast.makeText(this, "No se encontró una aplicación de cámara", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para lanzar el intent de selección de galería
    public void onPickImageClick(android.view.View view) {
        Intent pickImageIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        try {
            galleryLauncher.launch(pickImageIntent);
        } catch (Exception e) {
            Toast.makeText(this, "No se encontró una aplicación para seleccionar imágenes", Toast.LENGTH_SHORT).show();
        }
    }

    // Método para lanzar el intent de selección con ACTION_GET_CONTENT
    public void onGetContentClick(android.view.View view) {
        Intent getContentIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getContentIntent.setType("image/*"); // Especificar que solo queremos imágenes
        try {
            contentLauncher.launch(getContentIntent);
        } catch (Exception e) {
            Toast.makeText(this, "No se encontró una aplicación para seleccionar imágenes", Toast.LENGTH_SHORT).show();
        }
    }
}
