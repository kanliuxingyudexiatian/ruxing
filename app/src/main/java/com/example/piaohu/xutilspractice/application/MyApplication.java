package com.example.piaohu.xutilspractice.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.example.piaohu.xutilspractice.model.DataModel;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;

/**
 * Created by piaohu on 2017/2/20.
 */

public class MyApplication extends Application {

    public static DbUtils mDbUtils;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * 创建数据库
     *
     * @param context 上下文
     * @return
     */
    public static DbUtils geInstanceDbUtils(Context context) {
        if (mDbUtils == null) {
            DbUtils.DaoConfig daoConfig = new DbUtils.DaoConfig(context);
            daoConfig.setDbName("mydata");//数据库名称
            daoConfig.setDbVersion(1);//数据库版本号
            //设置数据库更新的监听
            daoConfig.setDbUpgradeListener(new DbUtils.DbUpgradeListener() {
                //版本号不一致的时候会调用这个方法
                @Override
                public void onUpgrade(DbUtils db, int oldVersion, int newVersion) {
                    if (oldVersion != newVersion) {
                        //进行操作
                    }
                }
            });
            mDbUtils = DbUtils.create(daoConfig);
        }
        return mDbUtils;
    }
}
