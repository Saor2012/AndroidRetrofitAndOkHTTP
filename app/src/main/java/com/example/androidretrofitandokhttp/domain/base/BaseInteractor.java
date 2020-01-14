package com.example.androidretrofitandokhttp.domain.base;

import io.reactivex.CompletableTransformer;
import io.reactivex.FlowableTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseInteractor {
    private Scheduler workThead;
    private Scheduler observerThead;

    public BaseInteractor() {
        this.workThead = Schedulers.io();
        this.observerThead = AndroidSchedulers.mainThread();
    }

    protected <T> SingleTransformer<T, T> applySingleTransformer() {
        return single -> single.subscribeOn(workThead)
                .observeOn(observerThead);
    }

    protected <T> FlowableTransformer<T, T> applyFlowableTransformer() {
        return flowable -> flowable.subscribeOn(workThead)
                .observeOn(observerThead);
    }

    protected <T> ObservableTransformer<T, T> applyObservableTransformer() {
        return observable -> observable.subscribeOn(workThead)
                .observeOn(observerThead);
    }

    protected CompletableTransformer applyCompletableTransformer() {
        return completable -> completable.subscribeOn(workThead)
                .observeOn(observerThead);
    }
}
