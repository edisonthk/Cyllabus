package com.example.likwee_pc.cyllabus.schema;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by edisonthk on 2015/01/17.
 */
public class Course implements Serializable {

    public String id; // mongodb のidはアルファベットと数字の組み合わせ
    public String bitmapUrl;
    public Bitmap image;

    public String title;

    public Date lastUpdated;
    public User publisher;

    public Course( String title, String lastUpdated, User user, String bitmapUrl){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        this.bitmapUrl = bitmapUrl;
        this.title = title;
        try {
            this.lastUpdated = df.parse(lastUpdated);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.publisher = user;
    }

}
