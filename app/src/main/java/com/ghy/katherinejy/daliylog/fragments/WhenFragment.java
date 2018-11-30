package com.ghy.katherinejy.daliylog.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ghy.katherinejy.daliylog.R;
import com.ghy.katherinejy.daliylog.model.WhenModel;
import com.ghy.katherinejy.daliylog.repository.DataBaseHelper;
import com.ghy.katherinejy.daliylog.repository.WhenListAdapter;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class WhenFragment extends Fragment {

    private List<WhenModel> mWhenItems;
    private DataBaseHelper dataBaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.when_fragment,container,false);
        ListView whenList = v.findViewById(R.id.lv_when);
        initWhenData();
//        mWhenItems = new ArrayList<WhenModel>();
//        WhenModel when = new WhenModel();
//        when.name = "mock";
//        when.category = "cate";
//        when.buyDate = new Date();
//        when.openDate = new Date();
//        when.expire = new Date();
//        when.isOpened = 0;
//        mWhenItems.add(when);
        whenList.setAdapter(new WhenListAdapter(getActivity() ,mWhenItems));
        return v;
    }

    private void initWhenData() {
        dataBaseHelper = new DataBaseHelper(getActivity());
        mWhenItems = new ArrayList<WhenModel>();
        for (int i=0;i<6;i++) {
            WhenModel when = new WhenModel();
            when.name = "mock"+i;
            when.category = "cate"+i;
            when.buyDate = new Date();
            when.openDate = new Date();
            when.expire = new Date();
            when.isOpened = 0;
            mWhenItems.add(when);
            dataBaseHelper.insertWhen(when);
        }
//        Cursor cursor = dataBaseHelper.getAllWhenData();
//        if (cursor!=null) {
//            while (cursor.moveToNext()) {
//                WhenModel when = new WhenModel();
//                when.name = cursor.getString(cursor.getColumnIndex("name"));
//                when.category = cursor.getString(cursor.getColumnIndex("category"));
//                when.buyDate = new Date(cursor.getString(cursor.getColumnIndex("buy_date")));
//                when.expire = new Date(cursor.getString(cursor.getColumnIndex("expire")));
//                when.isOpened = cursor.getInt(cursor.getColumnIndex("is_opened"));
//                if (when.isOpened==1)
//                    when.openDate = new Date(cursor.getString(cursor.getColumnIndex("open_date")));
//            }
//        }
//        cursor.close();
    }

}
