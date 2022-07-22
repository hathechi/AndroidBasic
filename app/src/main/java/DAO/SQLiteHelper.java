package DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "sqLiteHistory";
    public static final int DB_VERSION = 1;
    public static String ID = "id";
    public static String TENDOAN = "tendoan";
    public static String HINH = "hinh";
    public static String HINH2 = "hinh2";
    public static String KETQUA = "ketqua";
    public static String THOIGIAN = "thoigian";

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = String.format("CREATE TABLE history(%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s INTEGER, %s INTEGER, %s TEXT, %s DATETIME )", ID, HINH, HINH2, THOIGIAN, TENDOAN, KETQUA);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String droptable = "DROP TABLE IF EXISTS history";
        db.execSQL(droptable);
        onCreate(db);
    }
}
