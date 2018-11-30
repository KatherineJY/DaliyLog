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

import java.util.List;

public class WhenListAdapter extends BaseAdapter {

    private List<WhenModel> mList;
    private Context context;
    private LayoutInflater mLayoutInflater;

    public WhenListAdapter(Context context, List<WhenModel> list) {
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
        WhenListAdapter.ViewHolder viewHolder;
        if (convertView==null) {
            viewHolder = new WhenListAdapter.ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.when_list_item,null);
            viewHolder.mName = convertView.findViewById(R.id.tv_when_name);
            viewHolder.mCategory = convertView.findViewById(R.id.tv_when_category);
            viewHolder.mBuyDate = convertView.findViewById(R.id.tv_buy_date);
            viewHolder.mOpenDate = convertView.findViewById(R.id.tv_open_date);
            viewHolder.mExpire = convertView.findViewById(R.id.tv_expire);
            viewHolder.mIsOpened = convertView.findViewById(R.id.cb_is_opened);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (WhenListAdapter.ViewHolder) convertView.getTag();
        }
        WhenModel when = mList.get(position);
        viewHolder.mName.setText(when.name);
        viewHolder.mCategory.setText(when.category);
        viewHolder.mBuyDate.setText(when.buyDate.toString());
        viewHolder.mExpire.setText(when.expire.toString());
        viewHolder.mIsOpened.setChecked(when.isOpened==1);
        if (when.isOpened==1)
            viewHolder.mOpenDate.setText(when.openDate.toString());
        else
            viewHolder.mOpenDate.setText("Unopened");
        return convertView;
    }

    private static class ViewHolder {
        public TextView mName;
        public TextView mCategory;
        public TextView mBuyDate;
        public TextView mOpenDate;
        public TextView mExpire;
        public CheckBox mIsOpened;
    }
}
