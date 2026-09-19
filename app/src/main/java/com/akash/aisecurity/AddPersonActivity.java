package com.akash.aisecurity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;

import com.google.common.util.concurrent.ListenableFuture;

import android.widget.Toast;

public class AddPersonActivity extends AppCompatActivity {

    private PreviewView previewView;
    private EditText edtName;
    private Button btnStart;
    private ProgressBar progressBar;
    private TextView txtCount;

    private final ActivityResultLauncher<String> requestPermission =
            registerForActivityResult(
                    new ActivityResultContracts.RequestPermission(),
                    granted -> {
                        if (granted) {
                            startCamera();
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);

        previewView = findViewById(R.id.previewView);
        edtName = findViewById(R.id.edtName);
        btnStart = findViewById(R.id.btnStart);
        progressBar = findViewById(R.id.progressBar);
        txtCount = findViewById(R.id.txtCount);

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED) {

            startCamera();

        } else {

            requestPermission.launch(Manifest.permission.CAMERA);

        }

        btnStart.setOnClickListener(v -> {

            String name = edtName.getText().toString().trim();

            if (name.isEmpty()) {

                Toast.makeText(
                        AddPersonActivity.this,
                        "Please enter a name",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            progressBar.setProgress(0);
            txtCount.setText("0 / 100");

            Toast.makeText(
                    AddPersonActivity.this,
                    "Starting capture for " + name,
                    Toast.LENGTH_SHORT
            ).show();

        });
    }

    private void startCamera() {

        ListenableFuture<ProcessCameraProvider> cameraProviderFuture =
                ProcessCameraProvider.getInstance(this);

        cameraProviderFuture.addListener(() -> {

            try {

                ProcessCameraProvider cameraProvider =
                        cameraProviderFuture.get();

                Preview preview = new Preview.Builder().build();

                preview.setSurfaceProvider(
                        previewView.getSurfaceProvider()
                );

                CameraSelector cameraSelector =
                        CameraSelector.DEFAULT_FRONT_CAMERA;

                cameraProvider.unbindAll();

                cameraProvider.bindToLifecycle(
                        this,
                        cameraSelector,
                        preview
                );

            } catch (Exception e) {
                e.printStackTrace();
            }

        }, ContextCompat.getMainExecutor(this));

    }
}