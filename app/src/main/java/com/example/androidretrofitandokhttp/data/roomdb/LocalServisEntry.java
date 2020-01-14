package com.example.androidretrofitandokhttp.data.roomdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface LocalServisEntry {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Entry entry);

    @Query("SELECT * FROM entry")
    Single<List<Entry>> queryList();

    @Query("DELETE FROM entry WHERE id = :id")
    Completable delete(long id);
}
