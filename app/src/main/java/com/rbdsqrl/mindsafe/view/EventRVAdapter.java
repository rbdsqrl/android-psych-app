package com.rbdsqrl.mindsafe.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rbdsqrl.mindsafe.R;
import com.rbdsqrl.mindsafe.databinding.CellEventBinding;
import com.rbdsqrl.mindsafe.pojo.Event;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class EventRVAdapter extends RecyclerView.Adapter {
    private List<Event> events;

    private EventRVAdapter(List<Event> events){
        this.events = events;
    }

    public EventRVAdapter(){
        this(new ArrayList<Event>());
    }

    public void setEvents(List<Event> events) {
        this.events = events;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CellEventBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.cell_event, parent, false);
        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Event event = events.get(position);
        ((Holder) holder).bind(event);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        private CellEventBinding binding;
        Holder(@NonNull CellEventBinding binding) {
            super(binding.getRoot());
            this.binding =  binding;
        }

        void bind(Event event){
            if(event == null)
                return;
            binding.setEvent(event);
            binding.executePendingBindings();
        }
    }


}
