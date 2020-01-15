package com.example.androidretrofitandokhttp.presentation.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

public abstract class BaseActivity<Binding extends ViewDataBinding> extends AppCompatActivity {
    private Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutRes());
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        onStartView();
    }

    @Override
    public void onDestroy() {
        if (getPresenter() != null) {
            onDestroyView();
            getPresenter().stopView();
        }
        super.onDestroy();
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    protected Binding getBinding(){
        return binding;
    }

    protected abstract void initView();

    protected abstract void onStartView();

    protected abstract void onDestroyView();

    protected abstract BaseIPresenter getPresenter();

    protected void toast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
