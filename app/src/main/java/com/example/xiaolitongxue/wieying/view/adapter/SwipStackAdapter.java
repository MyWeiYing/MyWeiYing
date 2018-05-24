package com.example.xiaolitongxue.wieying.view.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiaolitongxue.wieying.R;
import com.example.xiaolitongxue.wieying.model.bean.ChoicenessBean;
import com.example.xiaolitongxue.wieying.model.bean.FindBean;

import java.util.List;

public class SwipStackAdapter extends BaseAdapter {

    private List<FindBean.RetBean.ListBean> list;
    private Context context;

    public SwipStackAdapter(List<FindBean.RetBean.ListBean> list,Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.swip_stack_item,null);
            holder.title = convertView.findViewById(R.id.swip_stack_title);
            holder.content = convertView.findViewById(R.id.swip_stack_content);
            holder.img = convertView.findViewById(R.id.swip_stack_img);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(list.get(position).getTitle());
        holder.content.setText("\u3000\u3000" + list.get(position).getDescription());
        Glide.with(context).load(Uri.parse(list.get(position).getPic())).placeholder(R.drawable.ic_launcher).into(holder.img);

        return convertView;
    }

    class ViewHolder{
        TextView title;
        TextView content;
        ImageView img;
    }

}
