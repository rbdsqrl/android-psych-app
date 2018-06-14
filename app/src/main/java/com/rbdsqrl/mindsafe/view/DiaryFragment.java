package com.rbdsqrl.mindsafe.view;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rbdsqrl.mindsafe.R;
import com.rbdsqrl.mindsafe.databinding.FragmentDiaryBinding;
import com.rbdsqrl.mindsafe.handler.ClickHandler;
import com.rbdsqrl.mindsafe.pojo.Event;
import com.rbdsqrl.mindsafe.repo.DiaryPage;
import com.rbdsqrl.mindsafe.util.DateTimeUtil;
import com.rbdsqrl.mindsafe.util.ViewUtil;
import com.rbdsqrl.mindsafe.viewmodel.DiaryPageViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class DiaryFragment extends BaseFragment {
    private FragmentDiaryBinding binding;
    private DiaryPageViewModel diaryPageViewModel;
    private EventRVAdapter eventRVAdapter;
    private String diaryDate;

    @Override
    public View bindFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayout(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onFragmentReady() {
        diaryDate = DateTimeUtil.getCurrentDateFormatted();
        binding.tvDate.setPaintFlags(binding.tvDate.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        ClickHandler handler =  new ClickHandler(this);
        diaryPageViewModel = ViewModelProviders.of(this).get(DiaryPageViewModel.class);
        //setting binding variables
        binding.setHandler(handler);
        binding.setViewModel(diaryPageViewModel);
        setRecyclerView();
        setObserver();
    }

    private void setRecyclerView() {
        eventRVAdapter =  new EventRVAdapter();
        binding.rvEvents.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        binding.rvEvents.setAdapter(eventRVAdapter);
    }

    private void setObserver() {
        diaryPageViewModel.getPageLD(diaryDate).observe(this, new Observer<DiaryPage>() {
            @Override
            public void onChanged(@Nullable DiaryPage diaryPage) {
                loadDetails(diaryPage);
            }
        });
    }

    private void loadDetails(DiaryPage diaryPage) {
        if(diaryPage == null){
            diaryPage = MPage.createPage(diaryDate,new ArrayList<Event>(), null, null, null, null, null,DiaryPage.SubstanceUse.NONE);
            diaryPageViewModel.insert(diaryPage);
            diaryPage = diaryPageViewModel.getPage(diaryDate);
        }
        binding.setDiaryPage(diaryPage);
        setEvent(diaryPage.getEvents());
    }

    private void setEvent(List<Event> events) {
        eventRVAdapter.setEvents(events);
        if(events.size() == 0){
            ViewUtil.setVisibility(View.GONE, binding.llEvents);
        }else{
            ViewUtil.setVisibility(View.VISIBLE, binding.llEvents);
        }
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_diary;
    }

}
