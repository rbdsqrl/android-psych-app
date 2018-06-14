package com.rbdsqrl.mindsafe.repo;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

public class DiaryPageRepository extends Repository {

    private DiaryPageDao dao;

    public DiaryPageRepository(Application application) {
        super(application);
        dao = appDatabase.getDiaryPageDao();
    }

    public void insert(final DiaryPage diaryPage){
        DBOperation.asyncTask(new DBOperation() {
            @Override
            void run() {
                dao.insert(diaryPage);
            }
        });
    }

    public void update(final DiaryPage diaryPage){
        DBOperation.asyncTask(new DBOperation() {
            @Override
            void run() {
                dao.update(diaryPage);
            }
        });
    }

    public void insertAll(final List<DiaryPage> diaryPages){
        DBOperation.asyncTask(new DBOperation() {
            @Override
            void run() {
                dao.insertAll(diaryPages);
            }
        });
    }

    public void delete(final DiaryPage diaryPage){
        DBOperation.asyncTask(new DBOperation() {
            @Override
            void run() {
                dao.delete(diaryPage);
            }
        });
    }

    public List<DiaryPage> getAll(){
        return dao.getAll();
    }

    public LiveData<List<DiaryPage>> getAllLD(){
        return dao.getAllLD();
    }

    public DiaryPage getPage(String diaryDate){
        return dao.getPage(diaryDate);
    }

    public LiveData<DiaryPage> getPageLD(String diaryDate){
        return dao.getPageLD(diaryDate);
    }
}
