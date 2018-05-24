package com.example.xiaolitongxue.wieying.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.ChoicenessBean;
import com.example.xiaolitongxue.wieying.model.bean.SpeciallBean;
import com.example.xiaolitongxue.wieying.view.activity.JinxuanxiangqingActivity;

import java.util.List;

public class JianJieAdapter extends RecyclerView.Adapter<JianJieAdapter.ViewHolder>{
    private List<SpeciallBean.RetBean.ListBean> list;
    private Context context;

    public JianJieAdapter(List<SpeciallBean.RetBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public JianJieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_jianjie_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(JianJieAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getPic()).into(holder.jianjieimg);
        holder.titletext.setText(list.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView jianjieimg;
        private final TextView titletext;

        public ViewHolder(View itemView) {
            super(itemView);
            jianjieimg = itemView.findViewById(R.id.jianjieimg);
            titletext = itemView.findViewById(R.id.titletext);
        }
    }
}
