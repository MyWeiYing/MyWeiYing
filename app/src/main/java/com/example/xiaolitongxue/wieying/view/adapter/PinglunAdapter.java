package com.example.xiaolitongxue.wieying.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.SpeciallBean;
import com.example.xiaolitongxue.wieying.model.bean.VideoPinglunBean;

import java.util.List;

public class PinglunAdapter extends RecyclerView.Adapter<PinglunAdapter.ViewHolder>{
    private List<VideoPinglunBean.RetBean.ListBean> list;
    private Context context;

    public PinglunAdapter(List<VideoPinglunBean.RetBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public PinglunAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_pinglun_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PinglunAdapter.ViewHolder holder, int position) {
//        Glide.with(context).load().into(new BitmapImageViewTarget(myimg) {
//            @Override
//            protected void setResource(Bitmap resource) {
//                RoundedBitmapDrawable circularBitmapDrawable =
//                        RoundedBitmapDrawableFactory.create(UserZliaoActivity.this.getResources(), resource);
//                circularBitmapDrawable.setCircular(true);
//                myimg.setImageDrawable(circularBitmapDrawable);
//            }
//        });
        holder.userid.setText(list.get(position).getDataId());
        holder.useruptime.setText(list.get(position).getTime());
        holder.userpinglun.setText(list.get(position).getMsg());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView useruptime;
        private final TextView userid;
        private final TextView userpinglun;

        public ViewHolder(View itemView) {
            super(itemView);
            userid = itemView.findViewById(R.id.userid);
            useruptime = itemView.findViewById(R.id.useruptime);
            userpinglun = itemView.findViewById(R.id.userpinglun);
        }
    }
}
