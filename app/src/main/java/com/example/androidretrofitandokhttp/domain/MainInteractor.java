package com.example.androidretrofitandokhttp.domain;

import com.example.androidretrofitandokhttp.data.model.ExchangeAPIModel;
import com.example.androidretrofitandokhttp.data.repository.IRepository;
import com.example.androidretrofitandokhttp.data.repository.Repository;
import com.example.androidretrofitandokhttp.domain.base.BaseInteractor;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import timber.log.Timber;

public class MainInteractor extends BaseInteractor implements MainIInteractor {
    private IRepository repository;

    public MainInteractor() {
        this.repository = new Repository();
    }

    @Override
    public Single<List<ExchangeAPIModel>> getDataAPI() {
        return repository.getData()
            .flatMap(list -> {
                if (list == null) return Single.error(new Throwable("The list of ExchangeAPIModels API is null"));
                else return Single.just(list);
            });
            //.compose(applySingleTransformer());
    }
}
