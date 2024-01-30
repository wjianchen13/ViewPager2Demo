package com.example.viewpager2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.viewpager2demo.test1.TestActivity1;
import com.example.viewpager2demo.test2.TestActivity2;
import com.example.viewpager2demo.test3.TestActivity3;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * ViewPager2 FragmentStateAdapter
     * @param v
     */
    public void onTest1(View v) {
        startActivity(new Intent(this, TestActivity1.class));
    }

    /**
     * ViewPager2 RecyclerView.Adapter
     * @param v
     */
    public void onTest2(View v) {
        startActivity(new Intent(this, TestActivity2.class));
    }

    /**
     * ViewPager2 RecyclerView 事件冲突处理
     * @param v
     */
    public void onTest3(View v) {
        startActivity(new Intent(this, TestActivity3.class));
    }

}