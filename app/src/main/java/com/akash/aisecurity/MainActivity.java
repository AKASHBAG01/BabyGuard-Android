package com.akash.aisecurity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCamera;
    Button btnFamily;
    Button btnEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera = findViewById(R.id.btnCamera);
        btnFamily = findViewById(R.id.btnFamily);
        btnEvents = findViewById(R.id.btnEvents);

        btnCamera.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, LiveCameraActivity.class)));

        btnFamily.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, FamilyActivity.class)));

        btnEvents.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, EventsActivity.class)));
    }
}