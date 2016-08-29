package com.example.andy.footmark;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.andy.footmark.model.ChildEntity;
import com.example.andy.footmark.model.GroupEntity;

import java.util.List;

/**
 * Created by andy on 7/19/16.
 * Adapter of ExpandableListView.
 * ExpandableListView的适配器
 */
public class ExpandableLIstAdapter extends BaseExpandableListAdapter {
    private LayoutInflater inflater = null;
    private List<GroupEntity> groupList;
    private Context context;

    /**
     * Construction method.
     * 构造方法
     */
    public ExpandableLIstAdapter(Context context, List<GroupEntity> group_list) {
        this.context = context;
        this.groupList = group_list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * Return total number of GroupItems.
     * 返回一级目录Group的总数
     */
    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    /**
     * Return total number of ChildItems.
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
     * Get the content of GroupItem.
     * 获取一级目录Group的内容
     */
    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    /**
     * Get the content of ChildItem
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
     * Get the view of GroupItem.
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
     * Get the view of ChildItem
     * 获取二级目录Child的view
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
        //If true, child item can be selected. true为点击二级目录有反应
        return true;
    }

    /**
     * Content in Group view.
     * Group内容
     */
    static class GroupViewHolder {
        public TextView groupName;
    }

    /**
     * Content in Child view.
     * Child内容
     */
    static class ChildViewHolder {
        public TextView childTitle;
    }
}
