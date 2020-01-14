package com.example.androidretrofitandokhttp.domain;

import com.example.androidretrofitandokhttp.data.repository.IRepository;
import com.example.androidretrofitandokhttp.data.repository.Repository;

public class MainInteractor implements MainIInteractor {
    private IRepository repository;

    public MainInteractor() {
        this.repository = new Repository();
    }
}
