package com.example.viewpager2demo.test5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpager2demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 暂未实现
 */
public class TestActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test5);

        final List<TestBean5> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TestBean5 bean = new TestBean5("", "test" + i);
            datas.add(bean);
        }

        ViewPager2 vp = findViewById(R.id.vp2);
        vp.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        vp.setOffscreenPageLimit(1);
        TestAdapter5 adapter = new TestAdapter5(this, datas);
        vp.setAdapter(adapter);
    }

}