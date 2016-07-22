package com.example.andy.footmark;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andy.footmark.model.ChildEntity;
import com.example.andy.footmark.model.GroupEntity;

import java.util.List;

/**
 * Created by andy on 7/19/16.
 * ExpandableListView的适配器
 */

public class MyAdapter extends BaseExpandableListAdapter {
    private LayoutInflater inflater = null;
    private List<GroupEntity> groupList;
    private Context context;

    /**
     * 构造方法
     */

    public MyAdapter(Context context, List<GroupEntity> group_list) {
        this.context = context;
        this.groupList = group_list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 返回一级目录Group的总数
     */

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    /**
     * 返回二级目录Child的总数
     */

    @Override
    public int getChildrenCount(int groupPosition) {
        if(groupList.get(groupPosition).getChildEntities() == null) {
            return 0;
        } else {
            return groupList.get(groupPosition).getChildEntities().size();
        }
    }

    /**
     * 获取一级目录Group的内容
     */

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    /**
     * 获取二级目录Child的内容
     */

    @Override
    public ChildEntity getChild(int groupPosition, int childPosition) {
        return groupList.get(groupPosition).getChildEntities().get(childPosition);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    /**
     * 获取一级目录Group的view
     */

    @Override
    public View getGroupView(final int groupPosition,boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder = new GroupViewHolder();
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.group_status_item_date, null);
        }
        holder.groupName = (TextView)convertView.findViewById(R.id.tv_one_status_name);
        holder.groupName.setText(groupList.get(groupPosition).getGroupName());
        return convertView;
    }

    /**
     * 获取二级目录Group的view
     */

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder viewHolder = null;
        ChildEntity entity = getChild(groupPosition, childPosition);
        if(convertView != null) {
            viewHolder = (ChildViewHolder)convertView.getTag();
        } else {
            viewHolder = new ChildViewHolder();
            convertView = inflater.inflate(R.layout.child_status_item_one_activity, null);
            viewHolder.childTitle = (TextView)convertView.findViewById(R.id.tv_title);
            if(entity != null) {
                viewHolder.childTitle.setText(entity.getChildTitle());
            }
            convertView.setTag(viewHolder);
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        //true为点击二级目录有反应
        return true;
    }

    /**
     * Group类
     */

    static class GroupViewHolder {
        public TextView groupName;
    }

    /**
     * Child类
     */

    static class ChildViewHolder {
        public TextView childTitle;
    }
}
