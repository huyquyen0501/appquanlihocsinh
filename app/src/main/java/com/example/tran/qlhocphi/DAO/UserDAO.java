package com.example.tran.qlhocphi.DAO;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tran.qlhocphi.DTO.UserDTO;
import com.example.tran.qlhocphi.Database.CreateDatabase;


public class UserDAO {
    SQLiteDatabase database;

    public UserDAO(Context context) {
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open();
    }
    public long InsertUser(UserDTO user){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_USERS_TAIKHOAN,user.getsTaiKhoan());
        contentValues.put(CreateDatabase.TB_USERS_MATKHAU,user.getsMatKhau());
        long result = database.insert(CreateDatabase.TB_USERS,null,contentValues);
        return result;
    }

    public boolean KiemTraDangNhap(String taiKhoan,String matKhau){
        String sql = "select * from tblUsers where "+CreateDatabase.TB_USERS_TAIKHOAN + " = '" +taiKhoan +"' and "
                + CreateDatabase.TB_USERS_MATKHAU + " = '" +matKhau +"'";
        Cursor cursor = database.rawQuery(sql,null);
        if (cursor.getCount() !=0){
            return true;
        }else {
            return false;
        }
    }
}

