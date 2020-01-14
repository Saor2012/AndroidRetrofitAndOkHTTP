package com.example.androidretrofitandokhttp.data.roomdb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Entry.class}, version = 1, exportSchema = false)
public abstract class PersonalDataBase extends RoomDatabase {
    public abstract LocalServisEntry getPersonalDAO();
}
