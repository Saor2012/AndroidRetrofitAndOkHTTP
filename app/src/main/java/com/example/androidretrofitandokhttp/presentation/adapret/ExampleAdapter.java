package com.example.androidretrofitandokhttp.presentation.adapret;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidretrofitandokhttp.R;
import com.example.androidretrofitandokhttp.data.model.ExchangeAPIModel;
import com.example.androidretrofitandokhttp.presentation.MainIPresenter;

import java.util.List;

public class ExampleAdapter extends RecyclerView.Adapter<ViewHolderAdapter> {
    private MainIPresenter.Presenter presenter;
    private List<ExchangeAPIModel> list;

    public ExampleAdapter(MainIPresenter.Presenter presenter, List<ExchangeAPIModel> list) {
        this.presenter = presenter;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderAdapter(LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false), presenter);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderAdapter holder, int position) {
        if (list.size() != 0) holder.bind(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
