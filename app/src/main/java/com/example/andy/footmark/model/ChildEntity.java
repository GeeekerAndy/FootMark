package com.example.andy.footmark.model;

/**
 * Created by andy on 7/19/16.
 * ChildItem in ExpandableListView
 * ExpandableListView中的二级目录对象
 */
public class ChildEntity {

    private String childTitle;

    public ChildEntity(String childTitle) {
        this.childTitle = childTitle;
    }

    public String getChildTitle() {
        return childTitle;
    }
}
