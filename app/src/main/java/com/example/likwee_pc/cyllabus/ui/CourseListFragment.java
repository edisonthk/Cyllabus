package com.example.likwee_pc.cyllabus.ui;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.likwee_pc.cyllabus.R;
import com.example.likwee_pc.cyllabus.schema.Course;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by LikWee-PC on 2015/01/18.
 */
public class CourseListFragment extends ListpageActivity.PlaceholderFragment implements ListView.OnItemClickListener {

    private static final String TAG = CourseListFragment.class.getName();

    private ListView mListView;
    private List<Course> mCoursesList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_courseslist, container, false);

        mListView = (ListView) view.findViewById(R.id.fragment_courseslist_listview);


        // DUMMY: リストを実装
        mCoursesList = Test.lists;

        CourseAdapter adapter = new CourseAdapter (getActivity());

        mListView.setOnItemClickListener(this);
        mListView.setAdapter(adapter);

        new FetchCourse().execute();

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        ((ListpageActivity) activity).onSectionAttached(
//                getArguments().getInt(ARG_SECTION_NUMBER));
//
//        Log.i(TAG, "Attach " + getArguments().getInt(ARG_SECTION_NUMBER));
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Course c = mCoursesList.get(position);

        CourseFragment frag = new CourseFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_COURSE, c);
        frag.setArguments(bundle);


        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, frag)
                .commit();

    }

    private class FetchCourse extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
//            try {
//                String rst = new HttpRequest("GET","http://example.com").send();
//                Log.i(TAG, rst);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            return null;
        }
    }

    public class CourseAdapter extends BaseAdapter {

        private Activity mContext;

        public CourseAdapter (Activity context) {
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return mCoursesList.size();
        }

        @Override
        public Course getItem(int position) {
            return mCoursesList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        private class ViewHolder {
            public final ImageView thumbView;
            public final TextView titleView, userView,organizationView;

            public ViewHolder(ImageView thumbView, TextView titleView,TextView userView, TextView organizationView) {
                this.thumbView = thumbView;
                this.titleView = titleView;
                this.userView = userView;
                this.organizationView = organizationView;
            }
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView thumbView;
            TextView titleView,userView,organizationView ;
		/*
		 * If convertView is not null, tried reuse it
		 * else create LayoutInflater to pack up the row view
		 */
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.courses_item_layout, parent, false);
                thumbView = (ImageView) convertView.findViewById(R.id.courses_item_image);
                titleView = (TextView) convertView.findViewById(R.id.courses_item_title);
                userView = (TextView) convertView.findViewById(R.id.courses_item_user);
                organizationView = (TextView) convertView.findViewById(R.id.courses_item_organization);
                convertView.setTag(new ViewHolder(thumbView, titleView, userView, organizationView));

            } else {
                ViewHolder holder = (ViewHolder) convertView.getTag();
                thumbView = holder.thumbView;
                titleView = holder.titleView;
                userView = holder.userView;
                organizationView = holder.organizationView;
            }


            Course c = getItem(position);
            titleView.setText(c.title);
            Picasso.with(getActivity()).load(c.bitmapUrl).into(thumbView);


            userView.setText(c.publisher.name);
            if(c.publisher.belongsTo == null || c.publisher.belongsTo.isEmpty()){
                // res/values/strings.xmlの中で定義しています。
                organizationView.setText(R.string.no_organization);
            }else{
                organizationView.setText(c.publisher.belongsTo);
            }



            return convertView;
        }

    }
}
