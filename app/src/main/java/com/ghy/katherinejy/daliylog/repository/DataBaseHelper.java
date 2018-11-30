package com.ghy.katherinejy.daliylog.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ghy.katherinejy.daliylog.CostBean;
import com.ghy.katherinejy.daliylog.model.WhenModel;
import com.ghy.katherinejy.daliylog.model.WhereModel;

public class DataBaseHelper extends SQLiteOpenHelper{

    public DataBaseHelper(Context context) {
        super(context,"daliy_log",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists cost ("+
                "id integer primary key,"+
                "cost_title varchar,"+
                "cost_date varchar,"+
                "cost_money varchar)");
        db.execSQL("create table if not exists when_items ("+
                "id integer primary key," +
                "name varchar," +
                "category varchar,"+
                "buy_date date,"+
                "open_date date,"+
                "expire date," +
                "is_opened integer )");
        db.execSQL("create table if not exists where_items ("+
                "id integer primary key," +
                "name varchar," +
                "position varchar,"+
                "buy_date date)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertCost(CostBean costBean) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("cost_title",costBean.costTitle);
        cv.put("cost_date",costBean.costDate);
        cv.put("cost_money",costBean.costMoney);
        database.insert("cost",null,cv);
    }

    public void insertWhen(WhenModel when) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",when.name);
        cv.put("category",when.category);
        cv.put("buy_date",when.buyDate.toString());
        cv.put("expire",when.expire.toString());
        cv.put("is_opened",when.isOpened);
        if (when.isOpened==1)
            cv.put("open_date",when.openDate.toString());
        database.insert("when_items",null,cv);
    }

    public void insertWhere(WhereModel where) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",where.name);
        cv.put("category",where.category);
        cv.put("position",where.position);
        database.insert("where_items",null,cv);
    }

    public Cursor getAllCostData() {
        SQLiteDatabase database = getWritableDatabase();
        return database.query("cost",null,null,null,null,null,"cost_date "+"ASC");
    }

    public Cursor getAllWhenData() {
        SQLiteDatabase database = getWritableDatabase();
        return database.query("when_items",null,null,null,null,null,null);
    }

    public Cursor getAllWhereData() {
        SQLiteDatabase database = getWritableDatabase();
        return database.query("where_items",null,null,null,null,null,null);
    }

    public void deleteAllCostData() {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("cost",null,null);
    }

    public void deleteAllWhenData() {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("when_items",null,null);
    }

    public void deleteAllWhereData() {
        SQLiteDatabase database = getWritableDatabase();
        database.delete("where_items",null,null);
    }
}
