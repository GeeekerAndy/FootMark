package com.example.andy.footmark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

/**
 * 显示帐号的Activity
 */
public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //自定义toolbar
        Toolbar accountToolbar = (Toolbar)findViewById(R.id.tb_account);
        setSupportActionBar(accountToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
