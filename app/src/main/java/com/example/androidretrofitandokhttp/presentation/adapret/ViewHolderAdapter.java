package com.example.androidretrofitandokhttp.presentation.adapret;

import android.renderscript.ScriptGroup;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidretrofitandokhttp.R;
import com.example.androidretrofitandokhttp.data.model.ExchangeAPIModel;
import com.example.androidretrofitandokhttp.databinding.RvItemBinding;
import com.example.androidretrofitandokhttp.presentation.MainIPresenter;
import com.example.androidretrofitandokhttp.presentation.MainPresenter;

import java.text.DecimalFormat;

public class ViewHolderAdapter extends RecyclerView.ViewHolder {
    private MainIPresenter.Presenter presenter;
    private RvItemBinding binding;

    public ViewHolderAdapter(@NonNull View itemView, MainIPresenter.Presenter presenter) {
        super(itemView);
        this.presenter = presenter;
        binding = DataBindingUtil.bind(itemView);
        if (binding != null && presenter != null) binding.setEvent(presenter);
    }

    public void bind (ExchangeAPIModel item, int position) {
        if (item != null) {
            binding.setEntity(item);
            binding.itemViewBuy.setText(item.getBuy());
            binding.itemViewTypeExchange.setText(item.getCcy());
            binding.itemViewSale.setText(item.getSale());
        }
    }

}
