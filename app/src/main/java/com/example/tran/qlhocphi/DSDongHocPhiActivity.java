package com.example.tran.qlhocphi;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.tran.qlhocphi.Adapter.HocSinhAdapter;
import com.example.tran.qlhocphi.DAO.HocSinhDAO;
import com.example.tran.qlhocphi.DTO.HocSinhDTO;
import com.example.tran.qlhocphi.R;

import java.util.ArrayList;



public class DSDongHocPhiActivity extends AppCompatActivity {
    EditText edtHocKy,edtNamHoc;
    RadioButton rdDaDong,rdChuaDong;
    ListView lvDanhSach;
    Button btnKiemTra;
    HocSinhAdapter hocSinhAdapter;
    ArrayList<HocSinhDTO> listHocSinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsdong_hoc_phi);
        addControls();
        addEvents();
    }


    private void addEvents() {
        btnKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something
                if (edtHocKy.getText().length() == 0) {
                    Toast.makeText(getBaseContext(), "Nhập học kỳ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (edtNamHoc.getText().length() == 0) {
                    Toast.makeText(getBaseContext(), "Nhập năm học", Toast.LENGTH_SHORT).show();
                    return;
                }
                int hocKy = Integer.parseInt(edtHocKy.getText().toString());
                int namHoc = Integer.parseInt(edtNamHoc.getText().toString());
                if (rdDaDong.isChecked()) {
                    //đã đóng
                    HocSinhDAO hocSinhDAO = new HocSinhDAO(getBaseContext());
                    hocSinhAdapter.setArrylist(hocSinhDAO.DaDongHocPhi(hocKy, namHoc));

                }  else {

                    //chưa đóng
                    HocSinhDAO hocSinhDAO = new HocSinhDAO(getBaseContext());
                    hocSinhAdapter.setArrylist(hocSinhDAO.ChuaDongHocPhi(hocKy, namHoc));


                }

            }
        });
    }

    private void addControls() {
        edtHocKy = findViewById(R.id.edtDSDHPHocKy);
        edtNamHoc = findViewById(R.id.edtDSDHPNamHoc);
        rdChuaDong = findViewById(R.id.rdChuaDong);
        rdDaDong = findViewById(R.id.rdDadong);
        btnKiemTra = findViewById(R.id.btnDSDHPKiemtra);
        lvDanhSach = findViewById(R.id.lvDongHocPhi);
        listHocSinh = new ArrayList<>();
        hocSinhAdapter = new HocSinhAdapter(this,listHocSinh,R.layout.hocsinhcustom);
        lvDanhSach.setAdapter(hocSinhAdapter);
    }
}
