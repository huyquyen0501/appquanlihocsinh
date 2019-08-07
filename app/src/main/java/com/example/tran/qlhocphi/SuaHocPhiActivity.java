package com.example.tran.qlhocphi;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tran.qlhocphi.DAO.HocPhiDAO;
import com.example.tran.qlhocphi.DTO.HocPhiDTO;
import com.example.tran.qlhocphi.R;

public class SuaHocPhiActivity extends AppCompatActivity {
    EditText edtTenHP,edtSoTien,edtHocKy,edtNamHoc;
    Button btnSua,btnQuaylai;
    HocPhiDTO hocPhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_hoc_phi);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtTenHP.getText().length()==0){
                    Toast.makeText(getBaseContext(),"Nhập tên",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtSoTien.getText().length()==0){
                    Toast.makeText(getBaseContext(),"Nhập tiền",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtHocKy.getText().length()==0){
                    Toast.makeText(getBaseContext(),"Nhập học kì",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtNamHoc.getText().length()==0){
                    Toast.makeText(getBaseContext(),"Nhập năm",Toast.LENGTH_SHORT).show();
                    return;
                }
                HocPhiDAO hocPhiDAO = new HocPhiDAO(getBaseContext());
                hocPhi.setsTenHP(edtTenHP.getText().toString());
                hocPhi.setiSoTien(Integer.parseInt(edtSoTien.getText().toString()));
                hocPhi.setiHocKy(Integer.parseInt(edtHocKy.getText().toString()));
                hocPhi.setiNamHoc(Integer.parseInt(edtNamHoc.getText().toString()));
                int result = hocPhiDAO.UpdateHocPhi(hocPhi);
                if (result!=0){
                    Toast.makeText(getBaseContext(),"Sửa thành công",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getBaseContext(),"Sửa thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnQuaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    private void addControls() {
        edtTenHP = findViewById(R.id.edtSQLHPTenHP);
        edtSoTien = findViewById(R.id.edtSQLHPSoTien);
        edtHocKy = findViewById(R.id.edtSQLHPHocKy);
        edtNamHoc = findViewById(R.id.edtSQLHPNamHoc);
        btnSua = findViewById(R.id.btnSQLHPSua);
        btnQuaylai = findViewById(R.id.btnSQLHPQuayLai);
        Intent intent = getIntent();
        hocPhi = (HocPhiDTO) intent.getSerializableExtra("hocphi");
        edtTenHP.setText(hocPhi.getsTenHP());
        edtHocKy.setText(hocPhi.getiHocKy()+"");
        edtSoTien.setText(hocPhi.getiSoTien()+"");
        edtNamHoc.setText(hocPhi.getiNamHoc()+"");
    }
}
