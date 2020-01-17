package com.example.androidretrofitandokhttp.data.retrofit;

import com.example.androidretrofitandokhttp.data.model.ExchangeAPIModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("p24api/pubinfo?json&exchange&coursid=5")
    Single<List<ExchangeAPIModel>> getData();//@Query("pubinfo?json&exchange&coursid=5") String status
}
