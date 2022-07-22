package DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import JavaClass.History;

public class HistoryDAO {
    private SQLiteDatabase db;

    public HistoryDAO(Context context) {
        SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
        this.db = sqLiteHelper.getReadableDatabase();
    }

    @SuppressLint("Range")
    public List<History> getList(String sql, String... selectArgs) {
        List<History> list = new ArrayList<>();
        String queryString = "SELECT * FROM history";
        Cursor cursor = db.rawQuery(sql, selectArgs);
        while (cursor.moveToNext()) {
            History history = new History();
            history.setId(cursor.getInt(cursor.getColumnIndex("id")));
            history.setHinh(cursor.getInt(cursor.getColumnIndex("hinh")));
            history.setHinh2(cursor.getInt(cursor.getColumnIndex("hinh2")));

            String time = cursor.getString(cursor.getColumnIndex("thoigian"));
            Date date = null;
            try {
                date = new SimpleDateFormat("hh:mm:ss dd/MM//yyyy").parse(time);
                history.setTime(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            history.setTendoan(cursor.getString(cursor.getColumnIndex("tendoan")));
            history.setKetqua(cursor.getString(cursor.getColumnIndex("ketqua")));

            list.add(history);
        }
        return list;
    }

    public List<History> getAll() {
        String sql = "SELECT * FROM history";

        return getList(sql);
    }

    public long insertHistory(History history) {

        ContentValues contentValues = new ContentValues();
//        contentValues.put("id", history.getId());
        contentValues.put("hinh", history.getHinh());
        contentValues.put("hinh2", history.getHinh2());
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd/MM//yyyy");
        String strDate = dateFormat.format(history.getTime());
        contentValues.put("thoigian", strDate);
        contentValues.put("tendoan", history.getTendoan());
        contentValues.put("ketqua", history.getKetqua());
        return db.insert("history", null, contentValues);
    }

    public long updateHistory(History history) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("hinh", history.getHinh());
        contentValues.put("hinh2", history.getHinh2());
        DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss dd/MM//yyyy");
        String strDate = dateFormat.format(history.getTime());
        contentValues.put("thoigian", strDate);
        contentValues.put("tendoan", history.getTendoan());
        contentValues.put("ketqua", history.getKetqua());

        return db.update("history", contentValues, "id=?", new String[]{String.valueOf(history.getId())});
    }

    public int delete(String id) {
        try {
            return db.delete("history", "id = ?", new String[]{id});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
