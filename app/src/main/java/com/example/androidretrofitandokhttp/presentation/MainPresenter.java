package com.example.androidretrofitandokhttp.presentation;

import com.example.androidretrofitandokhttp.data.model.ExchangeAPIModel;
import com.example.androidretrofitandokhttp.domain.MainIInteractor;
import com.example.androidretrofitandokhttp.domain.MainInteractor;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class MainPresenter implements MainIPresenter.Presenter {
    private MainIPresenter.View view;
    private MainIInteractor interactor;

    public MainPresenter() {
        if (interactor == null) interactor = new MainInteractor();
    }

    @Override
    public void startView(MainIPresenter.View view) {
        this.view = view;
    }

    @Override
    public void stopView() {
        if (view != null) view = null;
        if (interactor != null) interactor = null;
    }

    @Override
    public void init() {
        interactor.getDataAPI()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new DisposableSingleObserver<List<ExchangeAPIModel>>() {
                @Override
                public void onSuccess(List<ExchangeAPIModel> exchangeAPIModels) {
                    updateList(exchangeAPIModels);
                    dispose();
                }

                @Override
                public void onError(Throwable e) {
                    Timber.e("Exception: MainPresenter init() at interactor.getDataAPI() throw error - %s", e.getMessage());
                }
            });
            //.doOnError(throwable -> Timber.e("Exception: MainPresenter init() at interactor.getDataAPI() throw error - %s", throwable.getMessage()))
            //.subscribe(list -> {
            //    if (list != null) view.UpdateData(list);
            //    else view.viewToast("Empty list on storage");
            //}, throwable -> Timber.e("Error get news"));
    }

    @Override
    public void updateList(List<ExchangeAPIModel> data) {
        if (data != null) view.UpdateData(data);
        else view.viewToast("Empty list on storage");
    }

    @Override
    public void calculate(List<ExchangeAPIModel> data, String v, String number, boolean flag) {

    }

    @Override
    public void onClick(String v) {

    }
}
