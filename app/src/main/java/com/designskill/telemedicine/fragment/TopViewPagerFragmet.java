package com.designskill.telemedicine.fragment;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.designskill.telemedicine.R;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class TopViewPagerFragmet extends Fragment {


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.top_view_pager_fragment, container, false);


        return rootView;
    }


}
