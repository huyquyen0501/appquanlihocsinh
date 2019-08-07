package com.example.tran.qlhocphi;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tran.qlhocphi.DAO.UserDAO;
import com.example.tran.qlhocphi.DTO.UserDTO;
import com.example.tran.qlhocphi.R;


public class DangKyActivity extends AppCompatActivity {
    Button btnThoat,btnDangKy;
    EditText edtTaiKhoan,edtMatKhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtTaiKhoan.getText().length() == 0){
                    Toast.makeText(getBaseContext(),"Nhập tài khoản",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtMatKhau.getText().length() == 0){
                    Toast.makeText(getBaseContext(),"Nhập mật khẩu",Toast.LENGTH_SHORT).show();
                    return;
                }
                UserDAO userDAO = new UserDAO(getBaseContext());
                UserDTO user = new UserDTO(edtTaiKhoan.getText().toString(),edtMatKhau.getText().toString());
                long result = userDAO.InsertUser(user);
                if(result != 0){
                    Toast.makeText(getBaseContext(),"Đăng ký tài khoản thành công",Toast.LENGTH_LONG).show();
                    finish();
                }else {
                    Toast.makeText(getBaseContext(),"Đăng ký thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addControls() {
        btnThoat = findViewById(R.id.btnDKThoat);
        btnDangKy = findViewById(R.id.btnDKDangKy);
        edtTaiKhoan = findViewById(R.id.edtDKTaiKhoan);
        edtMatKhau = findViewById(R.id.edtDKMatKhau);
    }
}
