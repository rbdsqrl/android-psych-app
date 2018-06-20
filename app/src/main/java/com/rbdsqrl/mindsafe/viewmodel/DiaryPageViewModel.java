package com.rbdsqrl.mindsafe.viewmodel;

import android.app.Application;

import com.rbdsqrl.mindsafe.pojo.Event;
import com.rbdsqrl.mindsafe.repo.DiaryPage;
import com.rbdsqrl.mindsafe.repo.DiaryPageRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

public class DiaryPageViewModel extends BaseViewModel {
    public DiaryPageRepository repository;
    public LiveData<List<DiaryPage>> diaryLiveData;
    public LiveData<DiaryPage> pageLiveData;

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

    public LiveData<List<DiaryPage>> getDiaryLiveData(){
        if(diaryLiveData == null){
            diaryLiveData = repository.getAllLD();
        }
        return diaryLiveData;
    }

    public DiaryPage getPage(String diaryDate){
        return repository.getPage(diaryDate);
    }

    public LiveData<DiaryPage> getPageLiveData(String diaryDate){
        if(pageLiveData == null)
            pageLiveData = repository.getPageLD(diaryDate);
        return pageLiveData;
    }

    public void addEvent(DiaryPage diaryPage, Event event){
        List<Event> events = diaryPage.getEvents();
        events.add(event);
        diaryPage.setEvents(events);
        update(diaryPage);
    }

}
