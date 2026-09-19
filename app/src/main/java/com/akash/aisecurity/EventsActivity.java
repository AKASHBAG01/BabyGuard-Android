package com.akash.aisecurity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.akash.aisecurity.api.ApiClient;
import com.akash.aisecurity.api.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventsActivity extends AppCompatActivity {

    ListView listEvents;

    ArrayList<String> events = new ArrayList<>();

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        listEvents = findViewById(R.id.listEvents);

        adapter = new ArrayAdapter<>(
                this,
                R.layout.item_event,
                R.id.txtEvent,
                events
        );

        listEvents.setAdapter(adapter);

        loadEvents();
    }

    private void loadEvents() {

        ApiService api =
                ApiClient.getClient().create(ApiService.class);

        api.getEvents().enqueue(new Callback<EventsResponse>() {

            @Override
            public void onResponse(Call<EventsResponse> call,
                                   Response<EventsResponse> response) {

                if (response.isSuccessful() && response.body() != null) {

                    events.clear();

                    for (Event event : response.body().getEvents()) {

                        events.add(
                                event.getTime() +
                                        "   " +
                                        event.getMessage()
                        );
                    }

                    adapter.notifyDataSetChanged();

                }

            }

            @Override
            public void onFailure(Call<EventsResponse> call, Throwable t) {

                Toast.makeText(
                        EventsActivity.this,
                        "Cannot connect to server",
                        Toast.LENGTH_SHORT
                ).show();

            }
        });

    }

}