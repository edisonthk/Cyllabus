package com.example.likwee_pc.cyllabus.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.likwee_pc.cyllabus.R;
import com.example.likwee_pc.cyllabus.schema.Chapter;
import com.example.likwee_pc.cyllabus.schema.Course;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by LikWee-PC on 2015/01/18.
 */
public class CourseFragment extends ListpageActivity.PlaceholderFragment {

    private static final String TAG = CourseFragment.class.getName();

    private Course mCourse;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(!getArguments().containsKey(ARG_COURSE)){
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.container, new CourseListFragment())
                    .commit();

        }

        mCourse = (Course)getArguments().getSerializable(ARG_COURSE);
        Log.i(TAG, "Course title: "+mCourse.title);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_course, container, false);

        ImageView img = (ImageView)view.findViewById(R.id.fragment_course_parallaximage);
        String url = "https://cyllabus-production.s3.amazonaws.com/uploads/course/background_image/1740/cc9cfe94-2826-47e6-afa8-cb093787be3d.jpg";
        Picasso.with(getActivity()).load(url).into(img);

        LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.fragment_course_content);

        TextView titleView = (TextView)view.findViewById(R.id.fragment_course_title);
        titleView.setText(mCourse.title);


        Chapter dummyChpater = Test.getTestChapter();
        ArrayList<View> wvs = dummyChpater.parseToWebView(getActivity());

        for (View v : wvs){
            linearLayout.addView(v);
        }

        return view;
    }

}
