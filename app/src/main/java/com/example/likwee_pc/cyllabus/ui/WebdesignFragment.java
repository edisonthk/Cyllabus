package com.example.likwee_pc.cyllabus.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.likwee_pc.cyllabus.R;
import com.example.likwee_pc.cyllabus.util.Utils;

/**
 * Created by LikWee-PC on 2015/01/18.
 */
public class WebDesignFragment extends ListpageActivity.PlaceholderFragment {

    private static final String TAG = WebDesignFragment.class.getName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_course, container, false);
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((ListpageActivity) activity).onSectionAttached(
                getArguments().getInt(ARG_SECTION_NUMBER));

        Log.i(TAG, "Attach " + getArguments().getInt(ARG_SECTION_NUMBER));
    }
}
