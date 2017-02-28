package com.example.piaohu.xutilspractice.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.piaohu.xutilspractice.R;
import com.example.piaohu.xutilspractice.adapter.DataAdapter;
import com.example.piaohu.xutilspractice.adapter.DataAppointFieldsAdapter;
import com.example.piaohu.xutilspractice.model.DataModel;
import com.example.piaohu.xutilspractice.utils.DataUtils;
import com.lidroid.xutils.db.sqlite.DbModelSelector;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.db.table.DbModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv_data;
    private DataAdapter adapter_model_data;
    private DataAppointFieldsAdapter adapter_db_model_data;
    private List<DataModel> list_data;
    private List<DbModel> list_dbModel_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_data = (ListView) findViewById(R.id.lv_list);
        adapter_model_data = new DataAdapter(this);
        adapter_db_model_data = new DataAppointFieldsAdapter(this);
        list_data = new ArrayList<>();
        list_dbModel_data = new ArrayList<>();

        //添加单条数据-更新
        //addSingleData();
        //添加多条数据-更新
        addAllData();
        //添加数据-不更新
        //addNoUpDateData();
        //添加多条数据-不更新
        //addNoUpdateAllData();
        //删除指定条件的数据
        //deleteConditionTableData();
        //删除单条数据
        //deleteSingleData();
        //删除多条数据
        //deleteAllData();
        //删除指定表中所有数据
        //deleteTableAllData();
        //查询指定表中所有数据
        queryTableAllData();
        //查询表中指定条件的所有字段数据
        //queryConditionAllFieldsData();
        //查询表中指定条件下的指定字段
        //queryConditionAppointFieldsData();
        //查询表中指定条件下指定字段的第一条数据
        //queryConditionAppointFieldsFirstData();

        //DataModel的时候使用
        lv_data.setAdapter(adapter_model_data);
        adapter_model_data.setData(list_data);

        //DbModel的时候使用
        //lv_data.setAdapter(adapter_db_model_data);
        //adapter_db_model_data.setData(list_dbModel_data);
    }

    /**
     * 添加单条数据
     */
    private void addSingleData() {

        DataModel model1 = new DataModel();
        model1.setId("1");
        model1.setName("金玉良缘");
        model1.setSinger("李琦");
        DataUtils.getInstance().addOrUpdateData(this, model1);

        DataModel model2 = new DataModel();
        model2.setId("2");
        model2.setName("来生");
        model2.setSinger("李琦");
        DataUtils.getInstance().addOrUpdateData(this, model2);

        DataModel model3 = new DataModel();
        model3.setId("3");
        model3.setName("天若有情");
        model3.setSinger("alin");
        DataUtils.getInstance().addOrUpdateData(this, model3);

        DataModel model4 = new DataModel();
        model4.setId("4");
        model4.setName("隐形的翅膀");
        model4.setSinger("张韶涵");
        DataUtils.getInstance().addOrUpdateData(this, model4);

        DataModel model5 = new DataModel();
        model5.setId("5");
        model5.setName("可惜没有如果");
        model5.setSinger("林俊杰");
        DataUtils.getInstance().addOrUpdateData(this, model5);


    }

    /**
     * 添加多条数据
     */
    private void addAllData() {
        List<DataModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DataModel model = new DataModel();
            model.setId(i + "");
            model.setName("来生" + i);
            model.setSinger("李琦" + i);
            list.add(model);
        }
        for (int i = 10; i < 20; i++) {
            DataModel model = new DataModel();
            model.setId(i + "");
            model.setName("我们可不可以不勇敢");
            model.setSinger("范玮琪");
            list.add(model);
        }
        DataUtils.getInstance().addOrUpdateAllData(this, list);
    }

    private void addNoUpDateData() {
        DataModel model = new DataModel();
        model.setId("20");
        model.setName("遗失的美好");
        model.setSinger("张韶涵");
        DataUtils.getInstance().addNoUpdateData(this, model);
    }

    private void addNoUpdateAllData() {
        List<DataModel> list = new ArrayList<>();
        for (int i = 9; i < 10; i++) {
            DataModel model = new DataModel();
            model.setId(i + "");
            model.setName("天若有情");
            model.setSinger("alin");
            list.add(model);
        }
        DataUtils.getInstance().addNoUpdateAllData(this, list);
    }

    /**
     * 删除指定条件的数据
     */
    private void deleteConditionTableData() {
        WhereBuilder whereBuilder1 = WhereBuilder.b("singer", "=", "李琦0");
        WhereBuilder whereBuilder2 = WhereBuilder.b();
        whereBuilder2.and("singer", "=", "李琦1");
        whereBuilder2.or("singer", "=", "李琦2");
        DataUtils.getInstance().deleteConditionTableData(this, DataModel.class, whereBuilder2);
    }

    /**
     * 删除单条数据
     */
    private void deleteSingleData() {
        DataModel model = new DataModel();
        model.setId("20");
        model.setName("遗失的美好");
        model.setSinger("张韶涵");
        DataUtils.getInstance().deleteSingleData(this, model);
    }

    /**
     * 删除多条数据
     */
    private void deleteAllData() {
        List<DataModel> list = new ArrayList<>();
        for (int i = 4; i < 10; i++) {
            DataModel model = new DataModel();
            model.setId(i + "");
            model.setName("来生" + i);
            model.setSinger("李琦" + i);
            list.add(model);
        }
        DataUtils.getInstance().deleteAllData(this, list);
    }

    private void deleteTableAllData() {
        DataUtils.getInstance().deleteTableAllData(this, DataModel.class);
    }

    /**
     * 查询指定表中所有数据
     */
    private void queryTableAllData() {
        list_data = DataUtils.getInstance().queryTableAllData(this, DataModel.class);
    }

    /**
     * 查询表中指定条件所有字段的数据
     */
    private void queryConditionAllFieldsData() {
        Selector selector = Selector.from(DataModel.class).where("singer", "=", "范玮琪");
        list_data = DataUtils.getInstance().queryConditionAllFieldsData(this, selector);
    }

    /**
     * 查询表中指定条件指定字段的数据
     */
    private void queryConditionAppointFieldsData() {
        DbModelSelector dbModelSelector = Selector.from(DataModel.class).select("id", "name", "singer").where("singer", "=", "范玮琪");
        list_dbModel_data = DataUtils.getInstance().queryConditionAppointFieldsData(this, dbModelSelector);

    }

    /**
     * 查询指定条件指定字段的一条数据
     */
    private void queryConditionAppointFieldsFirstData() {
        DbModelSelector dbModelSelector = Selector.from(DataModel.class).select("id", "singer").where("singer", "=", "范玮琪");
        DbModel dbModel = DataUtils.getInstance().queryConditionAppointFieldsFirstData(this, dbModelSelector);
        list_dbModel_data.add(dbModel);
    }


}
