package com.example.viewpager2demo.test3;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpager2demo.R;

import java.util.ArrayList;
import java.util.List;

public class TestFragment3 extends Fragment {
    private boolean bUserVisible = false;

    private String tag = null;
    private String LOG = "生命周期->";
    private RecyclerView rvTest;
    private TestAdapter3 adapter;
    private List<String> datas = new ArrayList<>();

    private LinearLayoutManager layoutManager;

    public TestFragment3(String tag) {
        this.tag = tag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG + tag, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_test_fragment3, container, false);
        rvTest = view.findViewById(R.id.rv_test);
        initRv();
        return view;
    }

    public void initRv(){
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvTest.setLayoutManager(layoutManager);
        rvTest.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.top = 20;
                outRect.bottom = 20;
            }
        });
        for(int i = 0; i < 30; i ++) {
            datas.add("test" + i);
        }
        adapter = new TestAdapter3(datas);
        rvTest.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG + tag, "onActivityCreated");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(LOG + tag, "onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(LOG + tag, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG + tag, "onResume");

        //当前Fragment用户可见了
        //可以启动网络加载或绘图工作了。
        bUserVisible = true;
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(LOG + tag, "onPause");

        // 当前Fragment用户不可见了，
        // 如果有网络数据加载或绘图工作，可以停止了。
        bUserVisible = false;
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(LOG + tag, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG + tag, "onDestroy");
    }

    public String getTabTag() {
        return tag;
    }

    /**
     * 当前Fragment是否可见（用户在手机屏幕看得见？）。
     *
     * @return
     */
    public boolean isCurFragmentVisible() {
        return bUserVisible;
    }
}