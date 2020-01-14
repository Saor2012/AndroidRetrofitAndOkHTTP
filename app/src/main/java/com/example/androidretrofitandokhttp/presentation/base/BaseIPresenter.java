package com.example.androidretrofitandokhttp.presentation.base;

public interface BaseIPresenter<V> {
    void startView(V view);
    void stopView();
}
