package com.example.viewpager2demo.test2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewpager2demo.R;

import java.util.List;

/**
 * Viewpager2 使用RecyclerView.Adapter
 */
public class TestAdapter2 extends RecyclerView.Adapter {

    private Context mContext;
    private List<TestBean2> mData;

    public TestAdapter2(Context context, List<TestBean2> data) {
        this.mContext = context;
        this.mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext != null) {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.view_test2, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tvTest.setText(mData.get(position).getTip());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgvTest;
        TextView tvTest;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgvTest = itemView.findViewById(R.id.imgv_test);
            tvTest = itemView.findViewById(R.id.tv_test);
            tvTest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, tvTest.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
