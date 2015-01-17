package com.example.likwee_pc.cyllabus.ui;

import com.example.likwee_pc.cyllabus.schema.Course;
import com.example.likwee_pc.cyllabus.schema.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by edisonthk on 2015/01/17.
 */
public class Test {



    public User a = new User("さいわき",null);
    public User b = new User("おおはたけん",null);
    public User c = new User("@in_north",null);

    public List<Course> lists = Arrays.asList(
            new Course("データとは? - ER図の書き方","2014-09-17",a,"https://cyllabus-production.s3.amazonaws.com/uploads/course/background_image/102/a890bd89-c652-4eae-aa22-7ce5d0f41a20.jpg"),
            new Course("C言語基礎テスト","2015-01-17",b,"https://cyllabus-production.s3.amazonaws.com/uploads/course/background_image/1853/9939c6c3-4fe6-4fc2-bcb7-c06fa9fa93f0.jpg"),
            new Course("PCCS明度&彩度スケール","2014-10-30",a,"https://cyllabus-production.s3.amazonaws.com/uploads/course/background_image/81/9b5c3a9e-c4bd-4456-95a4-de8ee249f98f.jpg"),
            new Course("デザイン初心者のための基礎知識","2014-11-18",c,"https://cyllabus.jp/assets/dc-back.png"),
            new Course("ゲーミフィケーションを下敷きにウェブコミュニティ開発を考える","2014-11-10",a,"https://cyllabus-production.s3.amazonaws.com/uploads/course/background_image/110/4905df77-a615-4086-ad91-f9c54e37f555.jpg")

    );

}
