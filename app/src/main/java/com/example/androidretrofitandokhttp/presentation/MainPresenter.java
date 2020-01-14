package com.example.androidretrofitandokhttp.presentation;

import com.example.androidretrofitandokhttp.domain.MainIInteractor;
import com.example.androidretrofitandokhttp.domain.MainInteractor;

public class MainPresenter implements MainIPresenter.Presenter {
    private MainIPresenter.View view;
    private MainIInteractor interactor;

    public MainPresenter() {
        if (interactor != null) interactor = new MainInteractor();
    }

    @Override
    public void startView(MainIPresenter.View view) {
        this.view = view;
    }

    @Override
    public void stopView() {
        if (view != null) view = null;
    }
}
