package com.example.tran.qlhocphi.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tran.qlhocphi.DTO.HocSinhDTO;
import com.example.tran.qlhocphi.Database.CreateDatabase;

import java.util.ArrayList;


public class                                                                                                                                                            HocSinhDAO {
    SQLiteDatabase database;

    public HocSinhDAO(Context context) {
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }
    public long InsertHocSinh(HocSinhDTO hocSinh){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_HOCSINH_HOTEN,hocSinh.getsHoTen());
        contentValues.put(CreateDatabase.TB_HOCSINH_NGAYSINH,hocSinh.getsNgaySinh());
        contentValues.put(CreateDatabase.TB_HOCSINH_GIOITINH,hocSinh.getsGioiTinh());
        contentValues.put(CreateDatabase.TB_HOCSINH_DIACHI,hocSinh.getsDiaChi());
        long result = database.insert(CreateDatabase.TB_HOCSINH,null,contentValues);
        return result;
    }

    public int UpdateHocSinh(HocSinhDTO hocSinh){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_HOCSINH_HOTEN,hocSinh.getsHoTen());
        contentValues.put(CreateDatabase.TB_HOCSINH_NGAYSINH,hocSinh.getsNgaySinh());
        contentValues.put(CreateDatabase.TB_HOCSINH_GIOITINH,hocSinh.getsGioiTinh());
        contentValues.put(CreateDatabase.TB_HOCSINH_DIACHI,hocSinh.getsDiaChi());
        int result = database.update(CreateDatabase.TB_HOCSINH,contentValues,CreateDatabase.TB_HOCSINH_ID+ " = " +hocSinh.getiMaHS(),null);
        return result;
    }
    public ArrayList<HocSinhDTO> getAll(){
        ArrayList<HocSinhDTO> arrayList = new ArrayList<>();
        String sql = "select * from " + CreateDatabase.TB_HOCSINH;
        Cursor cursor = database.rawQuery(sql,null);
        if (cursor.getCount()!= 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                HocSinhDTO hocSinh = new HocSinhDTO();
                hocSinh.setiMaHS(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_ID)));
                hocSinh.setsHoTen(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_HOTEN)));
                hocSinh.setsNgaySinh(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_NGAYSINH)));
                hocSinh.setsGioiTinh(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_GIOITINH)));
                hocSinh.setsDiaChi(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_DIACHI)));
                arrayList.add(hocSinh);
                cursor.moveToNext();
            }
        }
        return arrayList;
    }
    public ArrayList<HocSinhDTO> timKiem(String ten){
        ArrayList<HocSinhDTO> arrayList = new ArrayList<>();
        String sql = "select * from " + CreateDatabase.TB_HOCSINH +" where "+CreateDatabase.TB_HOCSINH_HOTEN +" like '%"+ten+"%'";
        Cursor cursor = database.rawQuery(sql,null);
        if (cursor.getCount()!= 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                HocSinhDTO hocSinh = new HocSinhDTO();
                hocSinh.setiMaHS(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_ID)));
                hocSinh.setsHoTen(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_HOTEN)));
                hocSinh.setsNgaySinh(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_NGAYSINH)));
                hocSinh.setsGioiTinh(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_GIOITINH)));
                hocSinh.setsDiaChi(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_DIACHI)));
                arrayList.add(hocSinh);
                cursor.moveToNext();
            }
        }
        return arrayList;
    }
    public ArrayList<HocSinhDTO> DaDongHocPhi(int hocky, int namhoc){
        ArrayList<HocSinhDTO> arrayList = new ArrayList<>();
        String sql = "select * from " + CreateDatabase.TB_HOCSINH +" where "+CreateDatabase.TB_HOCSINH_ID +" in ( "
                + " select " +CreateDatabase.TB_HOCSINH_ID + " from " +CreateDatabase.TB_SOGHI +","+CreateDatabase.TB_HOCPHI+
                " where " +CreateDatabase.TB_SOGHI+"." +CreateDatabase.TB_SOGHI_IMAHP + " = " + CreateDatabase.TB_HOCPHI+"."+CreateDatabase.TB_HOCPHI_ID +
                " and " + CreateDatabase.TB_HOCPHI_HOCKY+ " = '" +hocky +"' and " +CreateDatabase.TB_HOCPHI_NAMHOC + " = '"
                + namhoc +"' )";

//        select *
//                from dbo.tblHocSinh
//        where iMaHS in  (
//                select iMaHS from dbo.tblSoGhi,dbo.tblHocPhi
//        where dbo.tblSoGhi.iMaHP = dbo.tblHocPhi.iMaHp
//        and iHocKy = 1 and iNamhoc = 2018
//)
        Cursor cursor = database.rawQuery(sql,null);
        if (cursor.getCount()!= 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                HocSinhDTO hocSinh = new HocSinhDTO();
                hocSinh.setiMaHS(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_ID)));
                hocSinh.setsHoTen(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_HOTEN)));
                hocSinh.setsNgaySinh(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_NGAYSINH)));
                hocSinh.setsGioiTinh(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_GIOITINH)));
                hocSinh.setsDiaChi(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_DIACHI)));
                arrayList.add(hocSinh);
                cursor.moveToNext();
            }
        }
        return arrayList;
    }

    public ArrayList<HocSinhDTO> ChuaDongHocPhi(int hocky, int namhoc){
        ArrayList<HocSinhDTO> arrayList = new ArrayList<>();
        String sql = "select * from " + CreateDatabase.TB_HOCSINH +" where "+CreateDatabase.TB_HOCSINH_ID +" not in ( "
                + " select " +CreateDatabase.TB_HOCSINH_ID + " from " +CreateDatabase.TB_SOGHI +","+CreateDatabase.TB_HOCPHI+
                " where " +CreateDatabase.TB_SOGHI+"." +CreateDatabase.TB_SOGHI_IMAHP + " = " + CreateDatabase.TB_HOCPHI+"."+CreateDatabase.TB_HOCPHI_ID +
                " and " + CreateDatabase.TB_HOCPHI_HOCKY+ " = '" +hocky +"' and " +CreateDatabase.TB_HOCPHI_NAMHOC + " = '"
                + namhoc +"' )";

//        select *
//                from dbo.tblHocSinh
//        where iMaHS in  (
//                select iMaHS from dbo.tblSoGhi,dbo.tblHocPhi
//        where dbo.tblSoGhi.iMaHP = dbo.tblHocPhi.iMaHp
//        and iHocKy = 1 and iNamhoc = 2018
//)

        Cursor cursor = database.rawQuery(sql,null);
        if (cursor.getCount()!= 0){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                HocSinhDTO hocSinh = new HocSinhDTO();
                hocSinh.setiMaHS(cursor.getInt(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_ID)));
                hocSinh.setsHoTen(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_HOTEN)));
                hocSinh.setsNgaySinh(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_NGAYSINH)));
                hocSinh.setsGioiTinh(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_GIOITINH)));
                hocSinh.setsDiaChi(cursor.getString(cursor.getColumnIndex(CreateDatabase.TB_HOCSINH_DIACHI)));
                arrayList.add(hocSinh);
                cursor.moveToNext();
            }
        }
        return arrayList;
    }

    public boolean XoaHocSinh(int id){
        return database.delete(CreateDatabase.TB_HOCSINH,CreateDatabase.TB_HOCSINH_ID+" = "+id,null) > 0;
    }
}
