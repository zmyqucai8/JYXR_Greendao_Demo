package com.example.zhangmengyun.greedaodemo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.Utils;
import com.example.zhangmengyun.greedaodemo.dao.DaoMaster;
import com.example.zhangmengyun.greedaodemo.dao.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by zhangmengyun on 2018/4/25.
 */

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        initDatabase();

        Utils.init(this);
//        SPUtils.getInstance()

    }

    private void initDatabase() {
        // 下面代码仅仅需要执行一次，一般会放在application
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "demo-db", null);

        db = helper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);


        mDaoSession = mDaoMaster.newSession();
//        在activity或者fragment中获取Dao对象
    }

    public static APP instances;

    /**
     * 获取实例
     *
     * @return
     */
    public static APP getInstances() {
        return instances;
    }

    DaoSession mDaoSession;
    SQLiteDatabase db;
    DaoMaster mDaoMaster;

    /**
     * 获取dao
     *
     * @return
     */
    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    /**
     * 获取db
     *
     * @return
     */
    public SQLiteDatabase getDb() {
        return db;
    }

}
