package com.example.xiaolitongxue.wieying.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.SpeciallBean;
import com.example.xiaolitongxue.wieying.view.activity.SpecialClassifyActivity;

import java.util.List;

/**
 * author：石头 on 2018/5/18 11:22
 * E-mail：small_shitou@163.com
 * -------------------------------------------------
 * 还没结束，怎么能轻言认输？
 * 专题  适配器
 */
public class SpecialAdapter extends RecyclerView.Adapter<SpecialAdapter.MyHolder> {

    private List<SpeciallBean.RetBean> list;
    private Context context;

    public SpecialAdapter(List<SpeciallBean.RetBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.fragment_special_item, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        String[] shareURL = list.get(position).getList().get(position).getShareURL().split("\\|");
        Glide.with(context).load(shareURL[0]).into(holder.img);
//        点击图片进行跳转
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SpecialClassifyActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private final ImageView img;

        public MyHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
}
