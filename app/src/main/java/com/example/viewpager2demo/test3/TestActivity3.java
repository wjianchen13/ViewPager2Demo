package com.example.viewpager2demo.test3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpager2demo.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * ViewPager2 RecyclerView 事件冲突处理
 */
public class TestActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);

        ViewPager2 vp = findViewById(R.id.vp2);
        vp.setOffscreenPageLimit(1);
        TestFragmentAdapter adapter = new TestFragmentAdapter(this, 2);
        vp.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tablayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, vp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText("卡" + position);
            }
        });
        tabLayoutMediator.attach();
    }

}