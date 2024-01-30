package com.example.viewpager2demo.test3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.viewpager2demo.test1.TestFragment1;

class TestFragmentAdapter extends FragmentStateAdapter {

    private int mSize;

    public TestFragmentAdapter(@NonNull FragmentActivity fragmentActivity, int size) {
        super(fragmentActivity);
        this.mSize = size;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 1) {
            return new TestFragment3("卡" + 1);
        } else {
            return new TestFragment3("卡" + 0);
        }
    }

    @Override
    public int getItemCount() {
        return mSize;
    }
}
