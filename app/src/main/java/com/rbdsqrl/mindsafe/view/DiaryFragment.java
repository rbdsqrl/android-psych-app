package com.rbdsqrl.mindsafe.view;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rbdsqrl.mindsafe.R;
import com.rbdsqrl.mindsafe.databinding.FragmentDiaryBinding;
import com.rbdsqrl.mindsafe.pojo.Event;
import com.rbdsqrl.mindsafe.repo.DiaryPage;
import com.rbdsqrl.mindsafe.util.DateTimeUtil;
import com.rbdsqrl.mindsafe.viewmodel.DiaryPageViewModel;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class DiaryFragment extends BaseFragment {

    private static final String ADD_EVENT = "ADD-EVENT";
    FragmentDiaryBinding binding;
    DiaryPageViewModel diaryPageViewModel;

    @Override
    public View bindFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, getLayout(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onFragmentReady() {
        binding.tvDate.setPaintFlags(binding.tvDate.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        binding.setFragment(this);
        diaryPageViewModel = ViewModelProviders.of(this).get(DiaryPageViewModel.class);
        setObserver();
    }

    private void setObserver() {
        diaryPageViewModel.getPageLD(DateTimeUtil.getCurrentDateFormatted()).observe(this, new Observer<DiaryPage>() {
            @Override
            public void onChanged(@Nullable DiaryPage diaryPage) {
                loadDetails(diaryPage);
            }
        });
    }

    private void loadDetails(DiaryPage diaryPage) {
        if(diaryPage == null){
            Log.i("diaryPage", "null");
            diaryPage = new DiaryPage(DateTimeUtil.getCurrentDateFormatted(),new ArrayList<Event>(), null, null, null, null, null,DiaryPage.SubstanceUse.NONE);
            diaryPageViewModel.insert(diaryPage);
            diaryPage = diaryPageViewModel.getPage(DateTimeUtil.getCurrentDateFormatted());
        }
        binding.setDiaryPage(diaryPage);
        Log.i("diaryPage", diaryPage.getEvents().toString());
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_diary;
    }

    public void addNewEvent(final DiaryPage diaryPage){
        AddEventDialog dialog = AddEventDialog.newInstance();
        dialog.setAddEventListener(new AddEventDialog.AddEventListener() {
            @Override
            public void onEventAdded(Event event) {
                diaryPageViewModel.addEvent(diaryPage, event);
            }
        });
        dialog.show(getChildFragmentManager(),ADD_EVENT);
    }
}
