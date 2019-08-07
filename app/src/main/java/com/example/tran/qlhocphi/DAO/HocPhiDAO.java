package com.example.tran.qlhocphi.DAO;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tran.qlhocphi.DTO.HocPhiDTO;
import com.example.tran.qlhocphi.Database.CreateDatabase;

import java.util.ArrayList;



public class HocPhiDAO {
    SQLiteDatabase database;

    public HocPhiDAO(Context context) {
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }
    public long InsertHocPhi(HocPhiDTO hocPhi){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_HOCPHI_TENHP,hocPhi.getsTenHP());
        contentValues.put(CreateDatabase.TB_HOCPHI_SOTIEN,hocPhi.getiSoTien());
        contentValues.put(CreateDatabase.TB_HOCPHI_HOCKY,hocPhi.getiHocKy());
        contentValues.put(CreateDatabase.TB_HOCPHI_NAMHOC,hocPhi.getiNamHoc());
        long result = database.insert(CreateDatabase.TB_HOCPHI,null,contentValues);
        return result;
    }

    public int UpdateHocPhi(HocPhiDTO hocPhi){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_HOCPHI_TENHP,hocPhi.getsTenHP());
        contentValues.put(CreateDatabase.TB_HOCPHI_SOTIEN,hocPhi.getiSoTien());
        contentValues.put(CreateDatabase.TB_HOCPHI_HOCKY,hocPhi.getiHocKy());
        contentValues.put(CreateDatabase.TB_HOCPHI_NAMHOC,hocPhi.getiNamHoc());
        int result = database.update(CreateDatabase.TB_HOCPHI,contentValues,CreateDatabase.TB_HOCPHI_ID +" = "+hocPhi.getiMaHP(),null);
        return result;
    }
    public ArrayList<HocPhiDTO> getAll(){
        ArrayList<HocPhiDTO> arrayList = new ArrayList<>();
        String sql = "select * from " + CreateDatabase.TB_HOCPHI;
        Cursor cursor = database.rawQuery(sql,null);
        if (cursor.getCount()!= 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                HocPhiDTO hocPhi = new HocPhiDTO();
                hocPhi.setiMaHP(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_HOCPHI_ID)));
                hocPhi.setsTenHP(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCPHI_TENHP)));
                hocPhi.setiSoTien(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_HOCPHI_SOTIEN)));
                hocPhi.setiHocKy(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_HOCPHI_HOCKY)));
                hocPhi.setiNamHoc(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_HOCPHI_NAMHOC)));
                arrayList.add(hocPhi);
                cursor.moveToNext();
            }
        }
        return arrayList;
    }
    public ArrayList<HocPhiDTO> timKiem(String ten){
        ArrayList<HocPhiDTO> arrayList = new ArrayList<>();
        String sql = "select * from " + CreateDatabase.TB_HOCPHI +" where "+CreateDatabase.TB_HOCPHI_TENHP +" like '%"+ten+"%'";
        Cursor cursor = database.rawQuery(sql,null);
        if (cursor.getCount()!= 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                HocPhiDTO hocPhi = new HocPhiDTO();
                hocPhi.setiMaHP(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_HOCPHI_ID)));
                hocPhi.setsTenHP(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCPHI_TENHP)));
                hocPhi.setiSoTien(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_HOCPHI_SOTIEN)));
                hocPhi.setiHocKy(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_HOCPHI_HOCKY)));
                hocPhi.setiNamHoc(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_HOCPHI_NAMHOC)));
                arrayList.add(hocPhi);
                cursor.moveToNext();
            }
        }
        return arrayList;
    }
    public boolean XoaHocPhi(int id){
        return database.delete(CreateDatabase.TB_HOCPHI,CreateDatabase.TB_HOCPHI_ID+" = "+id,null) > 0;
    }
}

