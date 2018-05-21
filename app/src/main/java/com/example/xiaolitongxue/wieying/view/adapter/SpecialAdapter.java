package com.example.xiaolitongxue.wieying.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.SpeciallBean;
import com.example.xiaolitongxue.wieying.view.activity.SpecialClassifyActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * author：石头 on 2018/5/18 11:22
 * E-mail：small_shitou@163.com
 * -------------------------------------------------
 * 还没结束，怎么能轻言认输？
 * 专题  适配器
 */
public class SpecialAdapter extends RecyclerView.Adapter<SpecialAdapter.MyHolder> {

    private List<SpeciallBean.RetBean.ListBean> list;
    private Context context;

    public SpecialAdapter(List<SpeciallBean.RetBean.ListBean> list, Context context) {
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
    public void onBindViewHolder(MyHolder holder, final int position) {

//        Glide.with(context).load(list.get(position).getPic()).placeholder(R.drawable.ic_launcher).into(holder.special_img);
        String image_url = list.get(position).getPic().split("\\|")[0];
        holder.special_img.setImageURI(image_url);
        holder.special_text.setText(list.get(position).getTitle());
//        点击图片进行跳转
        holder.special_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, SpecialClassifyActivity.class);
                intent.putExtra("title",list.get(position).getTitle());
                intent.putExtra("loadURL",list.get(position).getLoadURL());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView special_img;
        private final TextView special_text;

        public MyHolder(View itemView) {
            super(itemView);
            special_img = itemView.findViewById(R.id.special_img);
            special_text = itemView.findViewById(R.id.special_text);
            // 设置imageview透明度
            // img.setAlpha(150);
        }
    }
}
