package com.developer.corson.patchdatafromstudentsys.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.SQLException;
import com.developer.corson.patchdatafromstudentsys.utils.Res;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by le on 2016/4/29.
 */
public class DBAdapter {

    Context context;
    DatabaseHelper helper;
    SQLiteDatabase mDb = null;
    private String TAG = "DBAdapter";


    public DBAdapter(Context context){
        this.context = context;
        helper = new DatabaseHelper(context);


    }


    public DBAdapter open() throws SQLException{

        Log.d(TAG, "DB is opening...");
        if(mDb == null)
            mDb = helper.getReadableDatabase();

        return this;
    }

    public void close() {
        Log.d(TAG, "DB is close...");
        if(mDb != null)
            mDb = null;
        helper.close();
    }

    /**
     * 开启事务
     *
     * */
    public void beginTransaction(){
        mDb.beginTransaction();
    }


    /**
     * 提交事务
     *
     * */

    public void commitTransaction(){
        mDb.setTransactionSuccessful();
    }

    /**
     * 关闭事务
     * */
    public void closeTransaction(){
        mDb.endTransaction();
    }


    /**
     * 插入数据
     *
     * @param tableNm
     *
     * @param contentValues
     *          要插入列和对应的值
     *
     * */

    public boolean insert(String tableNm, ContentValues contentValues){

        return !(mDb.insert(tableNm, null, contentValues) == -1);

    }



    private class DatabaseHelper extends SQLiteOpenHelper{
        public DatabaseHelper(Context context) {

            super(context, Res.getConfig(context, "db_name"), null, Integer.valueOf(Res.getConfig(context, "db_version")));
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
