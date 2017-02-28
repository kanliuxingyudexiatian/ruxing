package com.example.piaohu.xutilspractice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.piaohu.xutilspractice.R;
import com.lidroid.xutils.db.table.DbModel;

import java.util.List;

/**
 * Created by piaohu on 2017/2/27.
 */

public class DataAppointFieldsAdapter extends BaseAdapter {

    private List<DbModel> list;
    private Context context;

    public DataAppointFieldsAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<DbModel> list){
        this.list=list;
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return list == null || list.size() == 0 ? 0 : list.size();
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
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
            viewHolder.tv_id = (TextView) convertView.findViewById(R.id.tv_id);
            viewHolder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tv_singer = (TextView) convertView.findViewById(R.id.tv_singer);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_id.setText(list.get(position).getString("id"));
        viewHolder.tv_name.setText(list.get(position).getString("name"));
        viewHolder.tv_singer.setText(list.get(position).getString("singer"));

        return convertView;
    }

    class ViewHolder {
        private TextView tv_id;
        private TextView tv_name;
        private TextView tv_singer;
    }
}
