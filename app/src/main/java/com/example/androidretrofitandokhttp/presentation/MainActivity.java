package com.example.androidretrofitandokhttp.presentation;

import android.os.Bundle;

import com.example.androidretrofitandokhttp.R;
import com.example.androidretrofitandokhttp.databinding.ActivityMainBinding;
import com.example.androidretrofitandokhttp.presentation.adapret.ExampleAdapter;
import com.example.androidretrofitandokhttp.presentation.base.BaseActivity;
import com.example.androidretrofitandokhttp.presentation.base.BaseIPresenter;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements MainIPresenter.View {
    private MainIPresenter.Presenter presenter;
    private ExampleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
        //presenter.init();
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
}
