package com.akash.aisecurity.api;

import com.akash.aisecurity.EventsResponse;
import com.akash.aisecurity.FamilyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("family")
    Call<FamilyResponse> getFamily();

    @GET("events")
    Call<EventsResponse> getEvents();

}