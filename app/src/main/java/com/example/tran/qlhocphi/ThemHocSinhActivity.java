package com.example.tran.qlhocphi;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.tran.qlhocphi.DAO.HocSinhDAO;

import com.example.tran.qlhocphi.DTO.HocSinhDTO;
import com.example.tran.qlhocphi.R;


public class ThemHocSinhActivity extends AppCompatActivity {
    EditText edtHoTen,edtNgaySinh,edtDiaChi;
    RadioButton rdNam,rdNu;
    Button btnThem,btnQuayLai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hoc_sinh);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnThem.setOnClickListener(new View.OnClickListener() {
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
                HocSinhDTO hocSinh = new HocSinhDTO();
                hocSinh.setsHoTen(edtHoTen.getText().toString());
                hocSinh.setsNgaySinh(edtNgaySinh.getText().toString());
                hocSinh.setsDiaChi(edtDiaChi.getText().toString());
                hocSinh.setsGioiTinh(gioiTinh);
                long result = hocSinhDAO.InsertHocSinh(hocSinh);
                if (result!= 0){
                    Toast.makeText(getBaseContext(),"Thêm thành công",Toast.LENGTH_SHORT).show();
                    edtHoTen.setText("");
                    edtNgaySinh.setText("");
                    edtDiaChi.setText("");
                    edtHoTen.requestFocus();
                }else {
                    Toast.makeText(getBaseContext(),"Thêm thất bại",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }

    private void addControls() {
        edtHoTen = findViewById(R.id.edtTHSHoTen);
        edtNgaySinh = findViewById(R.id.edtTHSNgaySinh);
        edtDiaChi = findViewById(R.id.edtTHSDiaChi);
        rdNam = findViewById(R.id.rdTHSNam);
        rdNu = findViewById(R.id.rdTHSNu);
        btnQuayLai = findViewById(R.id.btnTHSQuayLai);
        btnThem = findViewById(R.id.btnTHSThem);
    }
}
