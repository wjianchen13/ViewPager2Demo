package com.example.viewpager2demo.test2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpager2demo.R;
import com.example.viewpager2demo.test1.TestFragment1;

import java.util.ArrayList;
import java.util.List;

/**
 * 暂未实现
 */
public class TestActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        final List<TestBean2> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TestBean2 bean = new TestBean2("", "test" + i);
            datas.add(bean);
        }

        ViewPager2 vp = findViewById(R.id.vp2);
        vp.setOffscreenPageLimit(1);
        TestAdapter2 adapter = new TestAdapter2(this, datas);
        vp.setAdapter(adapter);
    }

}