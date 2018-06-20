package com.rbdsqrl.mindsafe.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rbdsqrl.mindsafe.R;
import com.rbdsqrl.mindsafe.databinding.FragmentTimelineBinding;
import com.rbdsqrl.mindsafe.repo.DiaryPage;
import com.rbdsqrl.mindsafe.viewmodel.DiaryPageViewModel;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;


public class TimelineFragment extends BaseFragment {

    private DiaryPageViewModel diaryPageViewModel;
    private FragmentTimelineBinding binding;
    private TimelineRVAdapter adapter;
    @Override
    public View bindFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayout(), container,false);
        return binding.getRoot();
    }

    @Override
    public void onFragmentReady() {
        diaryPageViewModel = ViewModelProviders.of(this).get(DiaryPageViewModel.class);
        setObserver();
        adapter  = new TimelineRVAdapter(diaryPage -> {
            //TODO on page selected
        });
        binding.rvTimeline.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        binding.rvTimeline.setAdapter(adapter);
    }

    private void setObserver() {
        diaryPageViewModel.getDiaryLiveData().observe(this, this::loadDiary);
    }

    private void loadDiary(List<DiaryPage> diaryPages) {
        adapter.setDiaryPages(diaryPages);
        adapter.notifyDataSetChanged();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_timeline;
    }
}
