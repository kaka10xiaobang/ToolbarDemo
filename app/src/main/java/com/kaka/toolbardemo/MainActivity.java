package com.kaka.toolbardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);//利用Toolbar代替ActionBar
        //设置导航Button点击事件
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"点击导航栏",Toast.LENGTH_SHORT).show();
            }
        });
        //设置移除图片  如果不设置会默认使用系统灰色的图标
//        mToolbar.setOverflowIcon(getResources().getDrawable(R.drawable.icon_action));
        mToolbar.inflateMenu(R.menu.toolbar_menu);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_settings:
                        Toast.makeText(MainActivity.this,"action_settings",Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.action_share:
                        Toast.makeText(MainActivity.this,"action_share",Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.action_search:
                        Toast.makeText(MainActivity.this,"action_search",Toast.LENGTH_SHORT).show();

                        break;
                        default:
                            break;
                }
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    public void onCustomView(View view) {
        startActivity(new Intent(this,CustomToolBarAct.class));
    }
}
