package com.example.viewpager2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.viewpager2demo.test1.TestActivity1;
import com.example.viewpager2demo.test2.TestActivity2;
import com.example.viewpager2demo.test3.TestActivity3;
import com.example.viewpager2demo.test4.TestActivity4;
import com.example.viewpager2demo.test5.TestActivity5;

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

    /**
     * 垂直 ViewPager2 FragmentStateAdapter
     * @param v
     */
    public void onTest4(View v) {
        startActivity(new Intent(this, TestActivity4.class));
    }

    /**
     * 垂直 ViewPager2 RecyclerView.Adapter
     * @param v
     */
    public void onTest5(View v) {
        startActivity(new Intent(this, TestActivity5.class));
    }
}