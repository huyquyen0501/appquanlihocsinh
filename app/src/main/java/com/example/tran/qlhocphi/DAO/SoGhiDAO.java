package com.example.tran.qlhocphi.DAO;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tran.qlhocphi.DTO.SoGhiDTO;
import com.example.tran.qlhocphi.Database.CreateDatabase;

import java.util.ArrayList;



public class SoGhiDAO {
    SQLiteDatabase database;

    public SoGhiDAO(Context context) {
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }
    public long InsertThuHocPhi(SoGhiDTO hocPhi){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_SOGHI_IMAHS,hocPhi.getiMaHS());
        contentValues.put(CreateDatabase.TB_SOGHI_IMAHP,hocPhi.getiMaHP());
        contentValues.put(CreateDatabase.TB_SOGHI_NGAYLAP,hocPhi.getsNgayLap());
        long result = database.insert(CreateDatabase.TB_SOGHI,null,contentValues);
        return result;
    }
    public int UpdateThuHocPhi(SoGhiDTO hocPhi){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_SOGHI_IMAHS,hocPhi.getiMaHS());
        contentValues.put(CreateDatabase.TB_SOGHI_IMAHP,hocPhi.getiMaHP());
        contentValues.put(CreateDatabase.TB_SOGHI_NGAYLAP,hocPhi.getsNgayLap());
        int result = database.update(CreateDatabase.TB_SOGHI,contentValues,CreateDatabase.TB_SOGHI_iMASOGHI +" = "+hocPhi.getiMaSoGhi(),null);
        return result;
    }
    public ArrayList<SoGhiDTO> getAll(){
        ArrayList<SoGhiDTO> arrayList = new ArrayList<>();
        String sql = "select * from " + CreateDatabase.TB_SOGHI;
        Cursor cursor = database.rawQuery(sql,null);
        if (cursor.getCount()!= 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                SoGhiDTO soGhi = new SoGhiDTO();
                soGhi.setiMaSoGhi(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_SOGHI_iMASOGHI)));
                soGhi.setiMaHS(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_SOGHI_IMAHS)));
                soGhi.setiMaHP(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_SOGHI_IMAHP)));
                soGhi.setsNgayLap(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_SOGHI_NGAYLAP)));
                arrayList.add(soGhi);
                cursor.moveToNext();
            }
        }
        return arrayList;
    }
    public boolean XoaSoGhi(int id){
        return database.delete(CreateDatabase.TB_SOGHI,CreateDatabase.TB_SOGHI_iMASOGHI+" = "+id,null) > 0;
    }
}
