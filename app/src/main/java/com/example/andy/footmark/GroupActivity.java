package com.example.andy.footmark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class GroupActivity extends AppCompatActivity {

    private ListView createdListView;
    private ListView addedListView;
    private Button createdButton;
    private Button addedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);

        Toolbar toolbar = (Toolbar)findViewById(R.id.tb_group);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createdListView = (ListView)findViewById(R.id.lv_created_groups);
        String[] createdGroupsString = {"我创建的群组1", "我创建的群组2", "我创建的群组3", "我创建的群组4", "我创建的群组5"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, createdGroupsString);
        createdListView.setAdapter(adapter1);
        createdListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        createdButton = (Button)findViewById(R.id.bt_created_groups);
        createdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(createdListView.getVisibility() == View.VISIBLE) {

                } else {
                    createdListView.setVisibility(View.VISIBLE);
                    addedListView.setVisibility(View.INVISIBLE);
                }
            }
        });

        addedListView = (ListView)findViewById(R.id.lv_added_groups);
        String[] addedGroupsString = {"我加入的群组1", "我加入的群组2", "我加入的群组3", "我加入的群组4", "我加入的群组5"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, addedGroupsString);
        addedListView.setAdapter(adapter2);
        addedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        addedButton = (Button)findViewById(R.id.bt_added_groups);
        addedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addedListView.getVisibility() == View.VISIBLE) {

                } else {
                    addedListView.setVisibility(View.VISIBLE);
                    createdListView.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
