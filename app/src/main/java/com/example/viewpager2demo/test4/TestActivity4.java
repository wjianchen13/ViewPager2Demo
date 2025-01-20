package com.example.viewpager2demo.test4;

import static androidx.viewpager2.widget.ViewPager2.ORIENTATION_VERTICAL;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpager2demo.R;
import com.example.viewpager2demo.Utils;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 暂未实现
 */
public class TestActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);

        final List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Fragment TestFragment = new TestFragment4("卡" + i);
            fragments.add(TestFragment);
        }

        ViewPager2 vp = findViewById(R.id.vp2);
//        vp.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        vp.setOffscreenPageLimit(1);
        MyFragmentAdapter adapter = new MyFragmentAdapter(this, fragments);
        vp.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tablayout);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, vp, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TestFragment4 f = (TestFragment4) fragments.get(position);
                tab.setText(f.getTabTag());
            }
        });
        tabLayoutMediator.attach();
        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                Utils.log("===================> onPageScrolled position: " + position + "  positionOffset: " + positionOffset + "  positionOffsetPixels: " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
//                Utils.log("===================> onPageSelected position: " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        vp.setPageTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                Utils.log("transformPage page: " + page + "  position: " + position);
            }
        });

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