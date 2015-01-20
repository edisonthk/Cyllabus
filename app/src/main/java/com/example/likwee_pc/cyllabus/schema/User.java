package com.example.likwee_pc.cyllabus.schema;

import java.io.Serializable;

/**
 * Created by edisonthk on 2015/01/17.
 */
public class User implements Serializable {

    public String id; // mongodb のidはアルファベットと数字の組み合わせ
    public String name;
    public String belongsTo;

    public User(String name, String belongsTo){
        this.name = name;
        this.belongsTo = belongsTo;
    }
}
