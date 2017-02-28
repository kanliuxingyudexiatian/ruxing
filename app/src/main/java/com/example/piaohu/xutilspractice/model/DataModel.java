package com.example.piaohu.xutilspractice.model;

import java.io.Serializable;

/**
 * Created by piaohu on 2017/2/20.
 */

public class DataModel extends BaseModel{

    private String id;//必须有这个字段
    private String name;
    private String singer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
