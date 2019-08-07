package com.example.tran.qlhocphi;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.tran.qlhocphi.DAO.HocSinhDAO;

import com.example.tran.qlhocphi.DTO.HocSinhDTO;
import com.example.tran.qlhocphi.R;


public class SuaHocSinhActivity extends AppCompatActivity {
    EditText edtHoTen,edtNgaySinh,edtDiaChi;
    RadioButton rdNam,rdNu;
    Button btnSua,btnQuayLai;
    HocSinhDTO hocSinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_hoc_sinh);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtHoTen.getText().length() == 0){
                    Toast.makeText(getBaseContext(),"Nhập họ tên",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtNgaySinh.getText().length() == 0){
                    Toast.makeText(getBaseContext(),"Nhập ngày sinh",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtDiaChi.getText().length() == 0){
                    Toast.makeText(getBaseContext(),"Nhập địa chỉ",Toast.LENGTH_SHORT).show();
                    return;
                }
                String gioiTinh = rdNam.isChecked()? "Nam":"Nữ";
                HocSinhDAO hocSinhDAO = new HocSinhDAO(getBaseContext());
                hocSinh.setsHoTen(edtHoTen.getText().toString());
                hocSinh.setsNgaySinh(edtNgaySinh.getText().toString());
                hocSinh.setsDiaChi(edtDiaChi.getText().toString());
                hocSinh.setsGioiTinh(gioiTinh);
                int result = hocSinhDAO.UpdateHocSinh(hocSinh);
                if (result!= 0){
                    Toast.makeText(getBaseContext(),"Sửa thành công",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getBaseContext(),"Sửa thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addControls() {
        edtHoTen = findViewById(R.id.edtSHSHoTen);
        edtNgaySinh = findViewById(R.id.edtSHSNgaySinh);
        edtDiaChi = findViewById(R.id.edtSHSDiaChi);
        rdNam = findViewById(R.id.rdSHSNam);
        rdNu = findViewById(R.id.rdSHSNu);
        btnQuayLai = findViewById(R.id.btnSHSQuayLai);
        btnSua = findViewById(R.id.btnSHSSua);

        Intent intent = getIntent();
        hocSinh = (HocSinhDTO) intent.getSerializableExtra("hocsinh");
        edtHoTen.setText(hocSinh.getsHoTen());
        edtDiaChi.setText(hocSinh.getsDiaChi());
        edtNgaySinh.setText(hocSinh.getsNgaySinh());
        if (hocSinh.getsGioiTinh().equals("Nam")){
            rdNam.setChecked(true);
        }else {
            rdNu.setChecked(true);
        }
    }
}
