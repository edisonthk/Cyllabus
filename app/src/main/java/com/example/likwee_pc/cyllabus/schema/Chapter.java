package com.example.likwee_pc.cyllabus.schema;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.likwee_pc.cyllabus.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LikWee-PC on 2015/01/20.
 */
public class Chapter implements Serializable {

    public enum Type {
        text, youtube, h1,h2,h3,h4, amazon, image
    }

    public enum Align {
        vertical, horizontal
    }

    public class Node implements Serializable{
        public Type type;
        public String content;

        public Align align;
        public String url, title, comment, index;
        public Node(Type type, String content){
            this.type = type;
            this.content = content;
        }
        public Node setImageInfo(Align align, String title, String comment, String index){
            this.url = this.content;
            this.align = align;
            this.title = title;
            this.comment = comment;
            this.index = index;
            return this;
        }
    }

    private ArrayList<Node> nodes;

    public Chapter(){
        nodes = new ArrayList<Node>();
    }

    public void addNode(Type type,String content) {
        nodes.add(new Node(type, content));
    }

    // 画像ノードの追加
    public void addImageNode(Align align, String url) {
        nodes.add(new Node(Type.image, url).setImageInfo(align, null , null, null));
    }
    public void addImageNode(Align align, String url, String title) {
        nodes.add(new Node(Type.image, url).setImageInfo(align, title , null, null));
    }
    public void addImageNode(Align align, String url, String title, String comment) {
        nodes.add(new Node(Type.image, url).setImageInfo(align, title , comment, null));
    }
    public void addImageNode(Align align, String url, String title, String comment,String index) {
        nodes.add(new Node(Type.image, url).setImageInfo(align, title , comment, index));
    }


    public ArrayList<Node> getNodes(){
        return nodes;
    }

    public ArrayList<View> parseToWebView(Activity activity){
        String baseUrl = "https://cyllabus.jp/assets/";

        ArrayList<View> wbs = new ArrayList<View>();


        // setStyleのような関数がありません
        // つまり、setPadding、setTextAppearanceなど一つ一つを設定しなかればいかせせん。
        for (Node node : getNodes()){

            TextView v;
            ImageView img;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            switch (node.type){
                case text:

                    v =new TextView(activity);
                    v.setText(node.content);
                    v.setTextSize(20);
                    v.setLayoutParams(layoutParams);
                    wbs.add(v);
                    break;
                case h3:

                    v =new TextView(activity);
                    v.setText(node.content);
                    v.setTextSize(25);
                    v.setTextColor(Color.parseColor("#46a6c3"));

                    layoutParams.setMargins(0,10,0,10);
                    v.setLayoutParams(layoutParams);

                    v.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.headline3_background));
                    v.setBackground(activity.getResources().getDrawable(R.drawable.headline3_background));

                    v.setPadding(10,0,0,0);

                    wbs.add(v);
                    break;
                case h4:
                    v =new TextView(activity);
                    v.setText(node.content);
                    v.setTextSize(20);

                    layoutParams.setMargins(0,10,0,10);
                    v.setLayoutParams(layoutParams);

                    v.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.headline4_background));
                    v.setBackground(activity.getResources().getDrawable(R.drawable.headline4_background));

                    wbs.add(v);
                    break;
                case image:
                    if(node.align == Align.horizontal){
                        // horizontal align
                        img = new ImageView(activity);
                        Picasso.with(activity).load(node.url).into(img);
                        wbs.add(img);

                        v =new TextView(activity);
                        v.setText(node.title);
                        wbs.add(v);

                        v =new TextView(activity);
                        v.setText(node.comment);
                        wbs.add(v);

                    }else{
                        // vertical align
                    }
                    break;
                case youtube:
                    break;
            }
        }

        return wbs;
    }

}
