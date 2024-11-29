package com.example.shiyan3;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class MenuTest extends AppCompatActivity {

    private TextView testTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_test);

        testTextView = findViewById(R.id.test_text_view); // 假设你有一个 TextView 用于显示测试文本

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        // 启用菜单
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_font_size_small) {
            testTextView.setTextSize(10);
        } else if (id == R.id.action_font_size_medium) {
            testTextView.setTextSize(16);
        } else if (id == R.id.action_font_size_large) {
            testTextView.setTextSize(20);
        } else if (id == R.id.action_common) {
            Toast.makeText(this, "普通菜单项被点击", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_font_color_red) {
            testTextView.setTextColor(getResources().getColor(R.color.red));
        } else if (id == R.id.action_font_color_black) {
            testTextView.setTextColor(getResources().getColor(R.color.black));
        }

        return super.onOptionsItemSelected(item);
    }
}