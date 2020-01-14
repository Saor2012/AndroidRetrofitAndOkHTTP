package com.example.androidretrofitandokhttp.data.repository;

import com.example.androidretrofitandokhttp.data.roomdb.Entry;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface IRepository {
    Single<Long> insert(String string);
    Single<List<Entry>> query();
    Completable deleteEntry(long id);
}
