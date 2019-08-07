package com.example.tran.qlhocphi;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tran.qlhocphi.DAO.SoGhiDAO;
import com.example.tran.qlhocphi.DTO.SoGhiDTO;
import com.example.tran.qlhocphi.R;


public class SuaSoThuPhiActivity extends AppCompatActivity {
    EditText edtMaHs,edtMaHP,edtNgayLap;
    Button btnSua,btnQuaylai;
    SoGhiDTO soGhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_so_thu_phi);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnQuaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtMaHs.getText().length() == 0){
                    Toast.makeText(getBaseContext(),"Nhập mã hs",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtMaHP.getText().length() == 0){
                    Toast.makeText(getBaseContext(),"Nhập mã học phí",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtNgayLap.getText().length() == 0){
                    Toast.makeText(getBaseContext(),"Nhập ngày lập",Toast.LENGTH_SHORT).show();
                    return;
                }
                SoGhiDAO soGhiDAO = new SoGhiDAO(getBaseContext());
                soGhi.setiMaHS(Integer.parseInt(edtMaHs.getText().toString()));
                soGhi.setiMaHP(Integer.parseInt(edtMaHP.getText().toString()));
                soGhi.setsNgayLap(edtNgayLap.getText().toString());
                long result = soGhiDAO.UpdateThuHocPhi(soGhi);
                if (result != 0){
                    Toast.makeText(getBaseContext(),"Sửa thành công",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getBaseContext(),"Sửa thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addControls() {
        edtMaHs = findViewById(R.id.edtSQLTHPMaHS);
        edtMaHP = findViewById(R.id.edtSQLTHPMaHP);
        edtNgayLap = findViewById(R.id.edtSQLTHPNgayLap);
        btnQuaylai = findViewById(R.id.btnSQLTHPQuayLai);
        btnSua = findViewById(R.id.btnSQLTHPSua);
        Intent intent = getIntent();
        soGhi = (SoGhiDTO) intent.getSerializableExtra("soghi");
        edtMaHP.setText(soGhi.getiMaHP()+"");
        edtMaHs.setText(soGhi.getiMaHS()+"");
        edtNgayLap.setText(soGhi.getsNgayLap());
    }
}
