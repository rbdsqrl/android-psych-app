package com.rbdsqrl.mindsafe.view;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.rbdsqrl.mindsafe.R;
import com.rbdsqrl.mindsafe.databinding.DialogAddEventBinding;
import com.rbdsqrl.mindsafe.pojo.Event;
import com.rbdsqrl.mindsafe.util.MEvent;
import com.rbdsqrl.mindsafe.util.ViewUtil;

import androidx.databinding.DataBindingUtil;

public class AddEventDialog extends BaseDialogFragment {

    DialogAddEventBinding binding;
    AddEventListener listener;

    public interface AddEventListener {
        void onEventAdded(Event event);
    }

    public static AddEventDialog newInstance() {
        return new AddEventDialog();
    }

    public void setAddEventListener(AddEventListener listener) {
        this.listener = listener;
    }

    @Override
    public View bindFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayout(), container, false);
        binding.setDialog(this);
        return binding.getRoot();
    }

    @Override
    protected void onDialogReady(Bundle savedInstanceState) {

    }

    @Override
    public int getLayout() {
        return R.layout.dialog_add_event;
    }

    @Override
    public DialogParams getParams() {
        return new DialogParams(0.8, true, Window.FEATURE_NO_TITLE, Gravity.CENTER);
    }

    public void addEvent() {
        if (ViewUtil.isEmptyText(binding.etEventName, binding.etEventDesc)) {
            return;
        }
        Event event = MEvent.createEvent(binding.etEventDesc.getText().toString(), binding.etEventName.getText().toString(), "", "");
        listener.onEventAdded(event);
        closeDialog();
    }
}
