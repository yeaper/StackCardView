package com.yyp.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * 主界面
 *
 * Created by yyp on 2019/2/20
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.left_stack:
                startActivity(new Intent(MainActivity.this, StackCardLeftActivity.class));
                break;
            case R.id.right_stack:
                startActivity(new Intent(MainActivity.this, StackCardRightActivity.class));
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
