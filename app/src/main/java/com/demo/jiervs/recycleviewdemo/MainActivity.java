package com.demo.jiervs.recycleviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private RecyclerView rv_demo;
    private ArrayList mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        rv_demo = (RecyclerView) findViewById(R.id.rv_demo);
        //rv_demo.setLayoutManager(new LinearLayoutManager(this));
        rv_demo.setAdapter(new HomeAdapter());
        rv_demo.addItemDecoration(new DividerGridItemDecoration(this));
        rv_demo.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
    }

    private void initData() {
        mData =new ArrayList<String>();
        for (int i = 'A';i < 'z';i++) {
            mData.add(""+ (char)i);
        }
    }

    public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder mHolder = new MyViewHolder(LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.item_home,parent,false));
            return mHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            int y = 100 + (int) (Math.random()*300);

            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) holder.tv.getLayoutParams();
            params.height = y;
            holder.tv.setLayoutParams(params);
            holder.tv.setText(mData.get(position).toString());
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        class MyViewHolder extends ViewHolder
        {
            public TextView tv;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }
}
