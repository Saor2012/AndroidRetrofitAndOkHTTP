package com.example.androidretrofitandokhttp.presentation;

import com.example.androidretrofitandokhttp.data.model.ExchangeAPIModel;
import com.example.androidretrofitandokhttp.presentation.base.BaseIPresenter;

import java.util.List;

public interface MainIPresenter {
    interface View {
        void CheckSwitch(String v);
        void setResult(String response, String v);
        void UpdateData(List<ExchangeAPIModel> list);
        void viewToast(String message);
    }
    interface Presenter extends BaseIPresenter<View> {
        void init();
        void updateList(List<ExchangeAPIModel> data);
        void calculate(List<ExchangeAPIModel> data, String v, String number, boolean flag);
        void onClick(String v);
    }
}
