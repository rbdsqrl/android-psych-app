package com.rbdsqrl.mindsafe.view;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rbdsqrl.mindsafe.R;
import com.rbdsqrl.mindsafe.databinding.CellTimelineBinding;
import com.rbdsqrl.mindsafe.repo.DiaryPage;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class TimelineRVAdapter extends RecyclerView.Adapter {

    private List<DiaryPage> diaryPages;
    PageListener listener;

    interface PageListener{
        void onPageSelected(DiaryPage diaryPage);
    }

    public void setDiaryPages(List<DiaryPage> diaryPages) {
        this.diaryPages = diaryPages;
    }

    private TimelineRVAdapter(List<DiaryPage> diaryPages, PageListener listener){
        this.diaryPages = diaryPages;
        this.listener = listener;
    }

    public TimelineRVAdapter(PageListener listener){
        this(new ArrayList<DiaryPage>(), listener);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CellTimelineBinding binding = DataBindingUtil.inflate(inflater, R.layout.cell_timeline, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        DiaryPage diaryPage = diaryPages.get(position);
        ((Holder) holder).bind(diaryPage);
    }

    @Override
    public int getItemCount() {
        return diaryPages.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private CellTimelineBinding binding;
        Holder(@NonNull CellTimelineBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(DiaryPage diaryPage){
            binding.setDiaryPage(diaryPage);
            binding.executePendingBindings();
        }
    }
}