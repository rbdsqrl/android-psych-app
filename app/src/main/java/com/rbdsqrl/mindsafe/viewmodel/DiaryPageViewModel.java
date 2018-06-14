package com.rbdsqrl.mindsafe.viewmodel;

import android.app.Application;

import com.rbdsqrl.mindsafe.pojo.Event;
import com.rbdsqrl.mindsafe.repo.DiaryPage;
import com.rbdsqrl.mindsafe.repo.DiaryPageRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public class DiaryPageViewModel extends BaseViewModel {
    private DiaryPageRepository repository;
    private LiveData<List<DiaryPage>> diaryLD;
    private LiveData<DiaryPage> diaryPageLD;

    public DiaryPageViewModel(@NonNull Application application) {
        super(application);
        repository = new DiaryPageRepository(application);
    }

    public void insert(final DiaryPage diaryPage){
       repository.insert(diaryPage);
    }

    public void update(final DiaryPage diaryPage){
      repository.update(diaryPage);
    }

    public void insertAll(final List<DiaryPage> diaryPages){
       repository.insertAll(diaryPages);
    }

    public void delete(final DiaryPage diaryPage){
       repository.delete(diaryPage);
    }

    public List<DiaryPage> getAll(){
        return repository.getAll();
    }

    public LiveData<List<DiaryPage>> getAllLD(){
        if(diaryLD == null){
            diaryLD = repository.getAllLD();
        }
        return diaryLD;
    }

    public DiaryPage getPage(String diaryDate){
        return repository.getPage(diaryDate);
    }

    public LiveData<DiaryPage> getPageLD(String diaryDate){
        if(diaryPageLD == null)
            diaryPageLD = repository.getPageLD(diaryDate);
        return diaryPageLD;
    }

    public void addEvent(DiaryPage diaryPage, Event event){
        List<Event> events = diaryPage.getEvents();
        events.add(event);
        diaryPage.setEvents(events);
        update(diaryPage);
    }

}
