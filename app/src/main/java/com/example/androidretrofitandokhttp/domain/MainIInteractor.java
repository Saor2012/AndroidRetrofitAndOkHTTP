package com.example.androidretrofitandokhttp.domain;

import com.example.androidretrofitandokhttp.data.model.ExchangeAPIModel;

import java.util.List;

import io.reactivex.Single;

public interface MainIInteractor {
        Single<List<ExchangeAPIModel>> getDataAPI();
}
