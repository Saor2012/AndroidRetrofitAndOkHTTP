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
    private List<ExchangeAPIModel> list;

    public MainPresenter() {
        if (interactor == null) interactor = new MainInteractor();
        list = null;
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
                    if (isDisposed()) {
                        onError(new Exception("Local exaption: subscriber is disposed"));
                    }
                    list = exchangeAPIModels;
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
        if (!Double.valueOf(number).isNaN() && !Double.valueOf(number).isInfinite()) {
            if (number.equals("")) view.viewToast("Zero entry number");
            else {
                data.forEach(values -> {
                    if (values.getCcy().equals(v)) {
                        if (flag) {
                            double result = Double.valueOf(values.getSale()) * Double.valueOf(number);
                            view.setResult(String.valueOf(result), v);
                        } else {
                            double result = Double.valueOf(values.getBuy()) * Double.valueOf(number);
                            view.setResult(String.valueOf(result), v);
                        }
                    }
                });
            }
        } else view.viewToast("NAN or Infinite insert value");
    }

    @Override
    public void onClick(String v) {
        view.CheckSwitch(v);
        String number = view.getData();
        if (!number.equals("") && number.matches("[0-9]{1,10}"))
            calculate(list, v, number, view.getLevelType());
        else view.viewToast("Invalide insert value");
    }
}
