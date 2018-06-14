package com.rbdsqrl.mindsafe.repo;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface DiaryPageDao {
    @Insert(onConflict = REPLACE)
    long insert(DiaryPage diaryPage);

    @Insert(onConflict = REPLACE)
    void insertAll(List<DiaryPage> pages);

    @Update
    int update(DiaryPage page);

    @Query("SELECT * FROM DiaryPage")
    List<DiaryPage> getAll();

    @Query("SELECT * FROM DiaryPage")
    LiveData<List<DiaryPage>> getAllLD();

    @Delete
    void delete(DiaryPage coupon);

    @Query("SELECT * FROM DiaryPage WHERE diaryDate = :diaryDate")
    DiaryPage getPage(String diaryDate);

    @Query("SELECT * FROM DiaryPage WHERE diaryDate = :diaryDate")
    LiveData<DiaryPage> getPageLD(String diaryDate);
}
