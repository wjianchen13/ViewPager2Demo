package com.example.viewpager2demo.test1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpager2demo.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 暂未实现
 */
public class TestActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        final List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Fragment TestFragment = new TestFragment1("卡" + i);
            fragments.add(TestFragment);
        }

        ViewPager2 vp = findViewById(R.id.vp2);
        vp.setOffscreenPageLimit(1);
        MyFragmentAdapter adapter = new MyFragmentAdapter(this, fragments);
        vp.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tablayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, vp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TestFragment1 f = (TestFragment1) fragments.get(position);
                tab.setText(f.getTabTag());
            }
        });
        tabLayoutMediator.attach();
    }

    private class MyFragmentAdapter extends FragmentStateAdapter {
        private List<Fragment> fragments;

        public MyFragmentAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> list) {
            super(fragmentActivity);
            this.fragments = list;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragments.get(position);
        }

        @Override
        public int getItemCount() {
            return fragments.size();
        }
    }

}