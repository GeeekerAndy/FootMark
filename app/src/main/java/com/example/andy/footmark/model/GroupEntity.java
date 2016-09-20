package com.example.andy.footmark.model;

import java.util.List;

/**
 * Created by andy on 7/19/16.
 * GroupItem in ExpandableListView
 * ExpandableListView中的一级目录对象
 */
public class GroupEntity {

    public String groupName;
    private List<ChildEntity> childEntities;

    public GroupEntity(String groupName) {
        this.groupName = groupName;
    }

    public List<ChildEntity> getChildEntities() {
        return childEntities;
    }

    public void setChildEntities(List<ChildEntity> childEntities) {
        this.childEntities = childEntities;
    }

    public String getGroupName() {
        return groupName;
    }

}