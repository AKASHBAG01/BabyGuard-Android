package com.akash.aisecurity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.akash.aisecurity.api.ApiClient;
import com.akash.aisecurity.api.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FamilyActivity extends AppCompatActivity {

    ListView listFamily;
    Button btnAddPerson;

    ArrayAdapter<String> adapter;
    ArrayList<String> familyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        listFamily = findViewById(R.id.listFamily);
        btnAddPerson = findViewById(R.id.btnAddPerson);

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                familyList
        );

        listFamily.setAdapter(adapter);

        loadFamily();

        btnAddPerson.setOnClickListener(v -> {

            Intent intent = new Intent(
                    FamilyActivity.this,
                    AddPersonActivity.class
            );

            startActivity(intent);

        });

    }

    private void loadFamily() {

        ApiService api = ApiClient
                .getClient()
                .create(ApiService.class);

        api.getFamily().enqueue(new Callback<FamilyResponse>() {

            @Override
            public void onResponse(Call<FamilyResponse> call,
                                   Response<FamilyResponse> response) {

                if (response.isSuccessful() && response.body() != null) {

                    familyList.clear();

                    familyList.addAll(response.body().getMembers());

                    adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Call<FamilyResponse> call, Throwable t) {

                Toast.makeText(
                        FamilyActivity.this,
                        "Cannot connect to backend",
                        Toast.LENGTH_LONG
                ).show();

            }

        });

    }

}