package com.aspect.demo.model;


import com.aspect.demo.base.BaseBean;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Administrator on 2016/4/7.
 */
public class ImageInfo extends RealmObject implements BaseBean {
    @PrimaryKey
    public String objectId;
    public String image;
    public String article;
    public String author;
    public String title;
    public String type;
    public String createdAt;

    @Override
    public String getObjectId() {
        return objectId;
    }
}
