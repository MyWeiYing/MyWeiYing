package com.example.xiaolitongxue.wieying.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.MyBean;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private List<MyBean> myBeanList;
    private Context context;

    public MyRecyclerAdapter(List<MyBean> myBeanList, Context context) {
        this.myBeanList = myBeanList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_recycler_layout, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(myBeanList.get(position).getTitle());
        holder.img.setImageResource(myBeanList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return myBeanList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView img;
        private final TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.my_recycler_img);
            title = itemView.findViewById(R.id.myrecycler_title);
        }
    }

}
