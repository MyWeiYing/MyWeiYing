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
import com.example.xiaolitongxue.wieying.model.bean.SpeciallClassifyBean;
import com.example.xiaolitongxue.wieying.view.activity.SpecialClassifyActivity;
import com.example.xiaolitongxue.wieying.view.activity.VideoParticularsActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * author：石头 on 2018/5/18 11:22
 * E-mail：small_shitou@163.com
 * -------------------------------------------------
 * 还没结束，怎么能轻言认输？
 * 专题  适配器
 */
public class SpecialClassifyAdapter extends RecyclerView.Adapter<SpecialClassifyAdapter.MyHolder> {

    private List<SpeciallClassifyBean.RetBean.ListBean> list;
    private Context context;

    public SpecialClassifyAdapter(List<SpeciallClassifyBean.RetBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.fragment_special__classify_item, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {

//        Glide.with(context).load(list.get(0).getChildList().get(position).getPic()).placeholder(R.drawable.ic_launcher).into(holder.special_jump_img);
        String image_url = list.get(0).getChildList().get(position).getPic().split("\\|")[0];
        holder.special_jump_img.setImageURI(image_url);
        holder.special_jump_text.setText(list.get(0).getChildList().get(position).getTitle());
//        点击图片进行跳转
        holder.special_jump_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, VideoParticularsActivity.class);
                intent.putExtra("ShareURL",list.get(position).getChildList().get(position).getShareURL());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.get(0).getChildList().size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView special_jump_img;
        private final TextView special_jump_text;

        public MyHolder(View itemView) {
            super(itemView);
            special_jump_img = itemView.findViewById(R.id.special_jump_img);
            special_jump_text = itemView.findViewById(R.id.special_jump_text);
            // 设置imageview透明度
            // img.setAlpha(150);
        }
    }
}
