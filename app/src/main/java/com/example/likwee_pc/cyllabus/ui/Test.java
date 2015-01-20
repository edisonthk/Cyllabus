package com.example.likwee_pc.cyllabus.ui;

import com.example.likwee_pc.cyllabus.schema.Chapter;
import com.example.likwee_pc.cyllabus.schema.Course;
import com.example.likwee_pc.cyllabus.schema.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by edisonthk on 2015/01/17.
 */
public class Test {



    public static User a = new User("さいわき",null);
    public static User b = new User("おおはたけん",null);
    public static User c = new User("@in_north",null);

    public static List<Course> lists = Arrays.asList(
            new Course("データとは? - ER図の書き方","2014-09-17",a,"https://cyllabus-production.s3.amazonaws.com/uploads/course/background_image/102/a890bd89-c652-4eae-aa22-7ce5d0f41a20.jpg"),
            new Course("C言語基礎テスト","2015-01-17",b,"https://cyllabus-production.s3.amazonaws.com/uploads/course/background_image/1853/9939c6c3-4fe6-4fc2-bcb7-c06fa9fa93f0.jpg"),
            new Course("PCCS明度&彩度スケール","2014-10-30",a,"https://cyllabus-production.s3.amazonaws.com/uploads/course/background_image/81/9b5c3a9e-c4bd-4456-95a4-de8ee249f98f.jpg"),
            new Course("デザイン初心者のための基礎知識","2014-11-18",c,"https://cyllabus.jp/assets/dc-back.png"),
            new Course("ゲーミフィケーションを下敷きにウェブコミュニティ開発を考える","2014-11-10",a,"https://cyllabus-production.s3.amazonaws.com/uploads/course/background_image/110/4905df77-a615-4086-ad91-f9c54e37f555.jpg")

    );

    public static Chapter getTestChapter(){
        Chapter c = new Chapter();
        c.addNode(Chapter.Type.h4, "affectとeffectの違い");
        c.addNode(Chapter.Type.text, "In this lesson, we are looking at the difference between “affect” and “effect.”\n" +
                "                    このレッスンでは affect と effect の違いを見ていきます。\n The main difference is that “affect” is used as a verb（動詞）,\n" +
                "                    and “effect” is used as a noun（名詞）. 語源に注目して見てみましょう！");

        c.addNode(Chapter.Type.h3, "語源と意味");
        c.addNode(Chapter.Type.h4, "affect　￼￼￼￼直接的に影響を与える");
        c.addNode(Chapter.Type.text, "◉語源:af(to: 向かって)+fect(make: 作る)=何かに向かって直接作る\n" +
                "                    ◉意味:影響する、感動させる\n ◉定義:to produce a change in something");

        c.addNode(Chapter.Type.h4, "effect　間接的な影響、結果");
        c.addNode(Chapter.Type.text, "◉語源:ef(ex: 外に)+fect(make: 作る)=外に出て作られるもの\n◉意味:結果、効果、影響\n◉定義:a change that something causes in something else; a\n" +
                "                    result");
        c.addNode(Chapter.Type.h3, "語源がわからない人はチェック！");
        c.addImageNode(Chapter.Align.horizontal, "https://cyllabus-production.s3.amazonaws.com/uploads/course_image/image/4327/541a9696-96c1-49f6-b698-5511b3c6eae6.png", "英単語の語源とは？", "「鯨」という漢字を見たときに「魚」という関連があるということがわかるように英単語にもへんや作りのようなものがあります。１つの語源を覚えることで数多くの単語を一挙に覚えることが可能となります。");
        c.addNode(Chapter.Type.text,"affectとeffectに共通しているfectは「作る」という語源があります。\nfic, fac, fecは「作る」ということ語源です。\nfactory（工場）＝作る場所\nmanufacture（製造）＝manu(手)＋fac（作る）\nfiction（フィクション）＝作られたもの\t\t\t\t\t\n" +
                "                    \nなどなどがあります。\naffectのafは「〜に向かって」というイメージ。look atやstare atのatと同じイメージです。\n" +
                "                    effectのefは「外に」という接頭語です。exit（出口）のexと同じイメージです。");

        return c;
    }

}
