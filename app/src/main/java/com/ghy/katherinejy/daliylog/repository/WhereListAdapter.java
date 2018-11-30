package com.ghy.katherinejy.daliylog.repository;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ghy.katherinejy.daliylog.R;
import com.ghy.katherinejy.daliylog.model.WhenModel;
import com.ghy.katherinejy.daliylog.model.WhereModel;

import java.util.List;

public class WhereListAdapter extends BaseAdapter {

    private List<WhereModel> mList;
    private Context context;
    private LayoutInflater mLayoutInflater;

    public WhereListAdapter(Context context, List<WhereModel> list) {
        this.context = context;
        this.mList = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WhereListAdapter.ViewHolder viewHolder;
        if (convertView==null) {
            viewHolder = new WhereListAdapter.ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.where_list_item,null);
            viewHolder.mName = convertView.findViewById(R.id.tv_where_name);
            viewHolder.mCategory = convertView.findViewById(R.id.tv_where_category);
            viewHolder.mPosition = convertView.findViewById(R.id.tv_where_position);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (WhereListAdapter.ViewHolder) convertView.getTag();
        }
        WhereModel where = mList.get(position);
        viewHolder.mName.setText(where.name);
        viewHolder.mCategory.setText(where.category);
        viewHolder.mPosition.setText(where.position);
        return convertView;
    }

    private static class ViewHolder {
        public TextView mName;
        public TextView mCategory;
        public TextView mPosition;
    }
}
