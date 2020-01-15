package com.example.androidretrofitandokhttp.presentation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.androidretrofitandokhttp.R;
import com.example.androidretrofitandokhttp.data.model.ExchangeAPIModel;
import com.example.androidretrofitandokhttp.databinding.ActivityMainBinding;
import com.example.androidretrofitandokhttp.presentation.adapret.ExampleAdapter;
import com.example.androidretrofitandokhttp.presentation.base.BaseActivity;
import com.example.androidretrofitandokhttp.presentation.base.BaseIPresenter;

import java.util.List;

import timber.log.Timber;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements MainIPresenter.View {
    private MainIPresenter.Presenter presenter;
    private ExampleAdapter adapter;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }*/

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        presenter = new MainPresenter();
        getBinding().setEvent(presenter);
    }

    @Override
    protected void onStartView() {
        presenter.startView(this);
        presenter.init();
    }

    @Override
    protected void onDestroyView() {
        if (presenter != null) presenter.stopView();
        presenter = null;
        if (adapter != null) adapter = null;
    }

    @Override
    protected BaseIPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void CheckSwitch(String v) {
        switch (v) {
            case "USD":
                getBinding().btnUSD.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                getBinding().btnEUR.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                getBinding().btnGBP.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                getBinding().btnPLN.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                break;
            case "EUR":
                getBinding().btnUSD.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                getBinding().btnEUR.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                getBinding().btnGBP.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                getBinding().btnPLN.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                break;
            case "GBP":
                getBinding().btnUSD.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                getBinding().btnEUR.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                getBinding().btnGBP.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                getBinding().btnPLN.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                break;
            case "PLN":
                getBinding().btnUSD.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                getBinding().btnEUR.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                getBinding().btnGBP.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                getBinding().btnPLN.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                break;
        }
    }

    @Override
    public void setResult(String response, String v) {
        //getBinding().textYourSumView.setText();
    }

    @SuppressLint("WrongConstant")
    @Override
    public void UpdateData(List<ExchangeAPIModel> list) {
        if (adapter == null) {
            getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
            getBinding().recyclerView.setAdapter(adapter = new ExampleAdapter(presenter, list));
        } else {
            adapter = new ExampleAdapter(presenter, list);
            getBinding().recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void viewToast(String message) {
        Timber.e("Message: %s", message);
        toast(message);
    }

    @SuppressLint("WrongConstant")
    public void initAdapter(List<String> strings) {
        if (presenter != null) {
            getBinding().recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
            getBinding().recyclerView.setAdapter(adapter = new ExampleAdapter(presenter, null)); //<-- Need strings list, v1

        }
    }
}
