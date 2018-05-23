package com.example.xiaolitongxue.wieying.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.ChoicenessBean;
import com.example.xiaolitongxue.wieying.view.activity.JinxuanxiangqingActivity;

import java.util.List;

public class JIngxuanAdapter extends RecyclerView.Adapter<JIngxuanAdapter.ViewHolder> {
   private List<ChoicenessBean.RetBean.ListBean.ChildListBean> list;
   private Context context;
    private ViewHolder viewHolder;




    public JIngxuanAdapter(List<ChoicenessBean.RetBean.ListBean.ChildListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public JIngxuanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_choiceness_item,null);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(JIngxuanAdapter.ViewHolder holder, final int position) {
        if(list.get(position).getPic()!=null){
            Glide.with(context).load(list.get(position).getPic()).into(holder.imglog);
        }
//
        holder.cchoicenesstextview.setText(list.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context,""+list.get(position).getShareURL(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context,JinxuanxiangqingActivity.class);
                intent.putExtra("title",list.get(position).getTitle());
                intent.putExtra("videourl",list.get(position).getShareURL());
                intent.putExtra("pic",list.get(position).getPic());
                intent.putExtra("description",list.get(position).getDescription());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


//


    class ViewHolder extends RecyclerView.ViewHolder{


        private final TextView cchoicenesstextview;
        private final ImageView imglog;

        public ViewHolder(View itemView) {
            super(itemView);
            imglog = itemView.findViewById(R.id.imglog);
            cchoicenesstextview = itemView.findViewById(R.id.cchoicenesstextview);
        }
    }
}
