package com.example.androidretrofitandokhttp.app;

import android.app.Application;

import androidx.room.Room;

import com.example.androidretrofitandokhttp.BuildConfig;
import com.example.androidretrofitandokhttp.data.Constants;
import com.example.androidretrofitandokhttp.data.roomdb.LocalServisEntry;
import com.example.androidretrofitandokhttp.data.roomdb.PersonalDataBase;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import timber.log.Timber;

public class App extends Application {
    private static Gson gson;
    public static LocalServisEntry localDB;
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        localDB = provideEntryDataBase();
    }

    static Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.setLenient().create();
    }

    public static Gson gson() {
        return gson;
    }

    private LocalServisEntry provideEntryDataBase() {
        PersonalDataBase dataBase = Room.databaseBuilder(this, PersonalDataBase.class, Constants.NAME_DAO)
                .allowMainThreadQueries()
                .build();
        return dataBase.getPersonalDAO();
    }


}
