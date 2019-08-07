package com.example.tran.qlhocphi.Database;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CreateDatabase extends SQLiteOpenHelper {
    //bảng users
    public static String TB_USERS = "tblUsers";
    public static String TB_USERS_ID = "iMaUser";
    public static String TB_USERS_TAIKHOAN = "sTaiKhoan";
    public static String TB_USERS_MATKHAU = "sMatKhau";
    //bảng học sinh
    public static String TB_HOCSINH = "tblHocSinh";
    public static String TB_HOCSINH_ID = "iMaHS";
    public static String TB_HOCSINH_HOTEN = "sHoTen";
    public static String TB_HOCSINH_NGAYSINH = "sNgaySinh";
    public static String TB_HOCSINH_GIOITINH = "sGioiTinh";
    public static String TB_HOCSINH_DIACHI = "sDiaChi";

    //bảng học phí
    public static String TB_HOCPHI = "tblHocPhi";
    public static String TB_HOCPHI_ID = "iMaHP";
    public static String TB_HOCPHI_TENHP = "sTenHP";
    public static String TB_HOCPHI_SOTIEN = "iSoTien";
    public static String TB_HOCPHI_HOCKY = "iHocKy";
    public static String TB_HOCPHI_NAMHOC = "iNamHOC";

    //bảng Sổ ghi
    public static String TB_SOGHI = "tblSoGhi";
    public static String TB_SOGHI_iMASOGHI = "iMaSoGhi";
    public static String TB_SOGHI_IMAHS = "iMaHS";
    public static String TB_SOGHI_IMAHP = "iMaHP";
    public static String TB_SOGHI_NGAYLAP = "sNgayLap";


    public CreateDatabase(Context context) {
        super(context, "QuanLyHocPhi", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tblUser = "create table " + TB_USERS +" ( " +TB_USERS_ID + " integer primary key autoincrement, "
                + TB_USERS_TAIKHOAN+" text, "+TB_USERS_MATKHAU+" text )";
        String tblHocSinh = "create table " + TB_HOCSINH +" ( " +TB_HOCSINH_ID + " integer primary key autoincrement, "
                + TB_HOCSINH_HOTEN+" text, "+TB_HOCSINH_NGAYSINH+" text, " + TB_HOCSINH_GIOITINH + " text, "
                + TB_HOCSINH_DIACHI + " text )";
        String tblHocPhi = "create table " + TB_HOCPHI +" ( " +TB_HOCPHI_ID + " integer primary key autoincrement, "
                + TB_HOCPHI_TENHP+" text, "
                +TB_HOCPHI_SOTIEN+" integer, "
                + TB_HOCPHI_HOCKY+ " integer, "
                + TB_HOCPHI_NAMHOC+ " integer )";
        String tblSoGhi = "create table " + TB_SOGHI +" ( "+TB_SOGHI_iMASOGHI +" integer primary key autoincrement, "
                +TB_SOGHI_IMAHS + " integer, "
                +TB_SOGHI_IMAHP+" integer, "
                +TB_SOGHI_NGAYLAP + " text) ";

        db.execSQL(tblUser);
        db.execSQL(tblHocSinh);
        db.execSQL(tblHocPhi);
        db.execSQL(tblSoGhi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public SQLiteDatabase open(){
        return this.getWritableDatabase();
    }
}

