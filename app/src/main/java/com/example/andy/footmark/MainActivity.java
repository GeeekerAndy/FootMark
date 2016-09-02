package com.example.andy.footmark;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.andy.footmark.model.ChildEntity;
import com.example.andy.footmark.model.GroupEntity;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.RunnableFuture;

/**
 * 简介：FootMark是一款照片共享应用，用户创建/加入群组，创建/加入活动，同一群组成员共享活动照片
 * 作者：贾胄，姜燕，刘培庆，王庆伟，吴光楠，赵一帆（字母顺序，不分先后）
 * Created by andy on 7/17/16.
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ExpandableListView expandableListView;
    private List<GroupEntity> lists;
    private ExpandableLIstAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView(); //Initialize main view. 初始化界面

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_sort_white_48px);
        setSupportActionBar(toolbar);
        toolbar.setOverflowIcon(drawable); //Change Overflow icon. 更换Overflow图标

        //Create or join an activity. 此按钮创建或加入一个活动
        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        final com.getbase.floatingactionbutton.FloatingActionButton actionA = (com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.action_a);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //选择群组

                String[] groupNames = {"群组1", "群组2", "群组3", "群组4", "群组5", "群组6", "群组7", "群组8", "群组9"};

                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("选择群组");
                builder.setSingleChoiceItems(groupNames, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {     //创建活动
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        EditText editText = new EditText(MainActivity.this);
                        editText.setMaxLines(1);
                        editText.setHint("活动名称");
                        editText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_SUBJECT);

                        AlertDialog.Builder subBuilder = new AlertDialog.Builder(MainActivity.this);
                        subBuilder.setTitle("创建活动");
                        subBuilder.setView(editText);
                        subBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "创建成功", Toast.LENGTH_LONG).show();
                            }
                        });
                        subBuilder.show();
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();

                menuMultipleActions.collapse();

             }
        });
        final com.getbase.floatingactionbutton.FloatingActionButton actionB = (com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.action_b);
        actionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {    //加入群组

                EditText editText = new EditText(MainActivity.this);
                editText.setMaxLines(1);
                editText.setHint("请输入ID");
                editText.setInputType(android.text.InputType.TYPE_CLASS_TEXT | android.text.InputType.TYPE_TEXT_VARIATION_EMAIL_SUBJECT);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("群组ID");
                builder.setView(editText);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "加入成功", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();

                menuMultipleActions.collapse();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        //刷新活动
//        SwipeRefreshLayout refreshActivities = (SwipeRefreshLayout)findViewById(R.id.srl_refresh_activities);
//        refreshActivities.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//
//            }
//        });
    }

    /**
     * Initialize ExpandableListView
     * 初始化ExpandableListView界面
     */
    private void initView() {
        lists = initList();
        adapter = new ExpandableLIstAdapter(this, lists);
        expandableListView = (ExpandableListView)findViewById(R.id.expandable_list_view);
        expandableListView.setAdapter(adapter);
        expandableListView.expandGroup(adapter.getGroupCount() - 1, true); //Expand the last group as default. 默认展开最后一组
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                return false;
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Intent intent = new Intent(MainActivity.this, ShowPhotosActivity.class);
                startActivity(intent);

                return false;
            }
        });
    }

    /**
     * Get the contents of GroupItem and ChildItem to initialize ExpandableView from local cache or server.
     * 获取初始化ExpandableListView的一级二级目录的内容
     * 将来从服务器和本地获取信息
     */
    private List<GroupEntity> initList() {
        List<GroupEntity> groupList;
        //一级目录内容
        String[] groupArray = new String[]{"2014.04", "2015.05", "2016.06"};
        //二级目录内容
        String[][] childItemArray = new String[][]{
                {"群组a+活动1", "群组b+活动1", "群组c+活动1"},
                {"群组a+活动2"}, {"群组b+活动2", "群组c+活动3"}};
        groupList = new ArrayList<>();
        for(int i = 0; i < groupArray.length; i++) {
            GroupEntity groupEntity = new GroupEntity(groupArray[i]);
            List<ChildEntity> childList = new ArrayList<>();
            for(int j = 0; j < childItemArray[i].length; j++) {
                ChildEntity childStatusEntity = new ChildEntity(childItemArray[i][j]);
                childList.add(childStatusEntity);
            }
            groupEntity.setChildEntities(childList);
            groupList.add(groupEntity);
        }
        return groupList;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if(id == R.id.ascending) {
            return true;
        }
        if(id == R.id.descending) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 侧边栏
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_account) {
            Intent intent = new Intent(MainActivity.this, AccountActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_groups) {
            Intent intent = new Intent(MainActivity.this, GroupActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_setting) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
