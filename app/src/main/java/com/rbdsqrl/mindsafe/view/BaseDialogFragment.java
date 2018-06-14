package com.rbdsqrl.mindsafe.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;

public abstract class BaseDialogFragment extends DialogFragment {
    Context context;
    FragmentActivity activity;
    private DialogParams dialogParams;

    public BaseDialogFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogParams = getParams();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try {
            AppView.setWindowProps(getDialog(),dialogParams.isCancelable,dialogParams.windowFeature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bindFragmentView(inflater, container, savedInstanceState);
    }

    public abstract View bindFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    @Override
    public void onResume() {
        super.onResume();
        try {
            AppView.setWindowDimens(getDialog(),dialogParams.widthFactor,dialogParams.gravity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        context = this.getContext();
        activity = this.getActivity();
        onDialogReady(savedInstanceState);
    }

    protected abstract void onDialogReady(Bundle savedInstanceState);

    public abstract int getLayout();

    public abstract DialogParams getParams();

    public void closeDialog() {
        dismiss();
    }

    class DialogParams{
        private Double widthFactor;
        private Boolean isCancelable;
        private int windowFeature;
        private int gravity;

        DialogParams(Double widthFactor, Boolean isCancelable, int windowFeature, int gravity) {
            this.widthFactor = widthFactor;
            this.isCancelable = isCancelable;
            this.windowFeature = windowFeature;
            this.gravity = gravity;
        }
    }
}
