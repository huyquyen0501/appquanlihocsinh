package com.example.tran.qlhocphi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tran.qlhocphi.DAO.UserDAO;
import com.example.tran.qlhocphi.R;


public class DangNhapActivity extends AppCompatActivity {
    TextView tvDangKy;
    EditText edtTaiKhoan,edtMatKhau;
    Button btnDangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        addControls();
        addEvents();
    }

    private void addEvents() {
        tvDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),DangKyActivity.class);
                startActivity(intent);
            }
        });
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDAO userDAO = new UserDAO(getBaseContext());
                boolean result = userDAO.KiemTraDangNhap(edtTaiKhoan.getText().toString(),edtMatKhau.getText().toString());
                if (result){
                    Intent intent = new Intent(getBaseContext(),MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getBaseContext(),"Sai tài khoản hoặc mật khẩu",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addControls() {
        tvDangKy = findViewById(R.id.tvDangKy);
        btnDangNhap = findViewById(R.id.btnDNDangNhap);
        edtTaiKhoan = findViewById(R.id.edtDNTaiKhoan);
        edtMatKhau = findViewById(R.id.edtDNMatKhau);
    }
}
