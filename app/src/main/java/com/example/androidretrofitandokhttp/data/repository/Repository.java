package com.example.androidretrofitandokhttp.data.repository;

import com.example.androidretrofitandokhttp.app.App;
import com.example.androidretrofitandokhttp.data.roomdb.Entry;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleTransformer;
import timber.log.Timber;

public class Repository implements IRepository {
    public Repository() {}

    @Override
    public Single<Long> insert(String string) {
        return Single.defer(() -> Single.just(App.localDB.insert(new Entry(string))))
                .doOnError(throwable -> Timber.e("Exception: insert() at insert dao throw error: %s", throwable.getMessage()));
    }

    @Override
    public Single<List<Entry>> query() {
        return App.localDB.queryList()
                .doOnError(throwable -> Timber.e("Exception: queryList() at query dao throw error: %s", throwable.getMessage()));
    }

    @Override
    public Completable deleteEntry(long id) {
        return App.localDB.delete(id)
                .doOnError(throwable -> Timber.e("Exception: delete() at delete dao throw error: %s", throwable.getMessage()));
    }
}
