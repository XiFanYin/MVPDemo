package xifuyin.tumour.com.a51ehealth.mvpdemo.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Administrator on 2018/5/10.
 */
@Table(database = db.class)
public class NewsDBTable  extends BaseModel{

    @PrimaryKey(autoincrement = true)
    @Column
    public int id;

    @Column
    public String tableName;


    @Column
    public  String tableId;


}
