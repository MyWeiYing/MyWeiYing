package com.example.xiaolitongxue.wieying.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private Activity activity;

    public JianJieAdapter(List<SpeciallBean.RetBean.ListBean> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public JianJieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.fragment_jianjie_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(JianJieAdapter.ViewHolder holder, final int position) {
        Glide.with(activity).load(list.get(position).getPic()).into(holder.jianjieimg);
        holder.titletext.setText(list.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,JinxuanxiangqingActivity.class);
                Log.d("intent===",""+intent);
                if(list.get(position).getDescription()!=null){
                    intent.putExtra("description",list.get(position).getDescription());
                }
               if(list.get(position).getPic()!=null){
                   intent.putExtra("pic",list.get(position).getPic());
               }
                if(list.get(position).getTitle()!=null){
                    intent.putExtra("title",list.get(position).getTitle());
                }
                if(list.get(position).getShareURL()!=null){
                    Log.d("test","不为空");
                    intent.putExtra("videourl",list.get(position).getShareURL());
                }
                String shareURL = list.get(position).getShareURL();
                Log.d("test",shareURL);
                activity.startActivity(intent);
                activity.finish();
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
