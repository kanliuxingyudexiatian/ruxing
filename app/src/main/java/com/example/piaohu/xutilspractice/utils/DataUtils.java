package com.example.piaohu.xutilspractice.utils;

import android.content.Context;

import com.example.piaohu.xutilspractice.application.MyApplication;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.DbModelSelector;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.db.table.DbModel;
import com.lidroid.xutils.exception.DbException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruxing on 2017/2/20.
 */

public class DataUtils<T> {

    private static DataUtils dataUtils;

    /**
     * 创建一个实例
     *
     * @return
     */
    public static DataUtils getInstance() {
        if (dataUtils == null) {
            dataUtils = new DataUtils();
        }
        return dataUtils;
    }

    /**
     * 获取DbUtils实例
     *
     * @param context
     * @return
     */
    public DbUtils getInstanceDbUtils(Context context) {
        return MyApplication.geInstanceDbUtils(context);
    }

    /**
     * 创建表
     *
     * @param context
     * @param c
     */
    public void createTable(Context context, Class c) {
        try {
            getInstanceDbUtils(context).createTableIfNotExist(c);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除表
     *
     * @param context
     * @param c
     */
    public void deleteTable(Context context, Class c) {
        try {
            getInstanceDbUtils(context).dropTable(c);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加或修改数据-单条(如果没有表，会先创建表)
     * 根据id进行判断，要增加的数据id在表中存在，修改数据,修改的数据会放在最后
     * 要增加的数据在表中不存在，增加数据，增加的数据放在最后
     */
    public void addOrUpdateData(Context context, T t) {
        try {
            getInstanceDbUtils(context).saveOrUpdate(t);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }


    /**
     * 增加或修改数据-多条(如果没有表，会先创建表)
     * * 根据id进行判断，要增加的数据id在表中存在，修改数据,修改的数据会放在最后
     * 要增加的数据在表中不存在，增加数据，增加的数据放在最后
     */
    public void addOrUpdateAllData(Context context, List<T> list) {
        try {
            getInstanceDbUtils(context).saveOrUpdateAll(list);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加数据，如果要增加的数据id在表中已经存在，就不会添加进去了，也不会修改表中的数据
     *
     * @param context
     * @param t
     */
    public void addNoUpdateData(Context context, T t) {
        try {
            getInstanceDbUtils(context).save(t);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 增加所有数据，如果要增加的数据id在表中已经存在，就不会添加进去了，也不会修改表中的数据
     * 要增加的数据id只要有一个在表中存在，整个List中的数据就都不会添加
     *
     * @param context
     * @param list
     */
    public void addNoUpdateAllData(Context context, List<T> list) {
        try {
            getInstanceDbUtils(context).saveAll(list);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除指定条件下指定表中的数据
     */
    public void deleteConditionTableData(Context context, Class c, WhereBuilder whereBuilder) {
        try {
            getInstanceDbUtils(context).delete(c, whereBuilder);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除单条数据
     *
     * @param context
     * @param t
     */
    public void deleteSingleData(Context context, T t) {
        try {
            getInstanceDbUtils(context).delete(t);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除多条数据
     *
     * @param context
     * @param list
     */
    public void deleteAllData(Context context, List<T> list) {
        try {
            getInstanceDbUtils(context).deleteAll(list);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除指定表中所有数据
     *
     * @param context
     * @param c
     */
    public void deleteTableAllData(Context context, Class c) {
        try {
            getInstanceDbUtils(context).deleteAll(c);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }


    /**
     * 查询指定表的所有数据(查询到的是表中所有字段)
     */
    public List<T> queryTableAllData(Context context, Class c) {
        List<T> list = new ArrayList<>();
        try {
            list = getInstanceDbUtils(context).findAll(c);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询指定条件下表中所有字段的所有数据
     *
     * @param context
     * @return
     */
    public List<T> queryConditionAllFieldsData(Context context, Selector selector) {
        List<T> list = new ArrayList<>();
        try {
            list = getInstanceDbUtils(context).findAll(selector);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询指定条件下表中指定字段的所有数据
     *
     * @param context
     * @return
     */
    public List<DbModel> queryConditionAppointFieldsData(Context context, DbModelSelector dbModelSelector) {
        List<DbModel> list = new ArrayList<>();
        try {
            list = getInstanceDbUtils(context).findDbModelAll(dbModelSelector);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询指定条件下表中指定字段的第一条数据
     *
     * @param context
     * @param dbModelSelector
     * @return
     */
    public DbModel queryConditionAppointFieldsFirstData(Context context, DbModelSelector dbModelSelector) {
        try {
            return getInstanceDbUtils(context).findDbModelFirst(dbModelSelector);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return null;
    }

}
