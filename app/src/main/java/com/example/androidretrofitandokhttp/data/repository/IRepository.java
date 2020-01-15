package com.example.androidretrofitandokhttp.data.repository;

import com.example.androidretrofitandokhttp.data.model.ExchangeAPIModel;
import com.example.androidretrofitandokhttp.data.roomdb.Entry;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import retrofit2.Call;

public interface IRepository {
    /*Single<Long> insert(String string);
    Single<List<Entry>> query();
    Completable deleteEntry(long id);*/
    Single<List<ExchangeAPIModel>> getData();
}
