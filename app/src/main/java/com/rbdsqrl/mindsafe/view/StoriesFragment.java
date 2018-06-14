package com.rbdsqrl.mindsafe.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rbdsqrl.mindsafe.R;
import com.rbdsqrl.mindsafe.databinding.FragmentStoriesBinding;

import androidx.databinding.DataBindingUtil;

public class StoriesFragment extends BaseFragment {
    FragmentStoriesBinding binding;
    @Override
    public View bindFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, getLayout() ,container, false);
        return binding.getRoot();
    }

    @Override
    public void onFragmentReady() {

    }

    @Override
    public int getLayout() {
        return R.layout.fragment_stories;
    }
}
