package com.rbdsqrl.mindsafe.handler;

import android.view.View;
import android.widget.ImageView;

import com.rbdsqrl.mindsafe.pojo.Event;
import com.rbdsqrl.mindsafe.repo.DiaryPage;
import com.rbdsqrl.mindsafe.util.ViewUtil;
import com.rbdsqrl.mindsafe.view.AddEventDialog;
import com.rbdsqrl.mindsafe.viewmodel.DiaryPageViewModel;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class ClickHandler {

    private static final String ADD_EVENT = "ADD-EVENT";
    private Fragment fragment;

    public ClickHandler(Fragment fragment) {
        this.fragment = fragment;
    }

    public void showAddEventDialog(final DiaryPageViewModel diaryPageViewModel, final DiaryPage diaryPage){
        AddEventDialog dialog = AddEventDialog.newInstance();
        dialog.setAddEventListener(new AddEventDialog.AddEventListener() {
            @Override
            public void onEventAdded(Event event) {
                diaryPageViewModel.addEvent(diaryPage, event);
            }
        });
        dialog.show(fragment.getChildFragmentManager(),ADD_EVENT);
    }

    public void animateArrow(ImageView arrow, RecyclerView recyclerView){
        int visibility;
        float toDegree, fromDegree;
        if(recyclerView.getVisibility() == View.VISIBLE){
            toDegree = 0f;
            fromDegree = 180f;
            visibility = View.GONE;
        }else{
            toDegree = 180f;
            fromDegree = 0f;
            visibility = View.VISIBLE;
        }
        ViewUtil.rotateView(fromDegree, toDegree, arrow);
        ViewUtil.setVisibility(visibility, recyclerView);
    }
}
