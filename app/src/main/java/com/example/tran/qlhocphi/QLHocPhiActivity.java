package com.example.tran.qlhocphi;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tran.qlhocphi.Adapter.HocPhiAdapter;
import com.example.tran.qlhocphi.DAO.HocPhiDAO;
import com.example.tran.qlhocphi.DTO.HocPhiDTO;
import com.example.tran.qlhocphi.R;

import java.util.ArrayList;


public class QLHocPhiActivity extends AppCompatActivity {
    EditText edtTenHP,edtSoTien,edtHocKy,edtNamHoc,edtTimKiem;
    Button btnThem;
    ListView lvHocPhi;
    HocPhiAdapter hocPhiAdapter;
    ArrayList<HocPhiDTO> listHocPhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlhoc_phi);
        addControls();
        addEvents();
        LoadHcPhi2Listview();
    }

    private void LoadHcPhi2Listview() {
        HocPhiDAO hocPhiDAO = new HocPhiDAO(getBaseContext());
        hocPhiAdapter.setArrylist(hocPhiDAO.getAll());
    }

    private void addEvents() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HocPhiDAO hocPhiDAO = new HocPhiDAO(getBaseContext());
                HocPhiDTO hocPhi = new HocPhiDTO();
                hocPhi.setsTenHP(edtTenHP.getText().toString());
                hocPhi.setiSoTien(Integer.parseInt(edtSoTien.getText().toString()));
                hocPhi.setiHocKy(Integer.parseInt(edtHocKy.getText().toString()));
                hocPhi.setiNamHoc(Integer.parseInt(edtNamHoc.getText().toString()));
                long result = hocPhiDAO.InsertHocPhi(hocPhi);
                if (result!=0){
                    Toast.makeText(getBaseContext(),"Thêm thành công",Toast.LENGTH_SHORT).show();
                    LoadHcPhi2Listview();
                }
            }
        });
        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edtTimKiem.getText().length() == 0){
                    LoadHcPhi2Listview();
                }else {
                    HocPhiDAO hocPhiDAO = new HocPhiDAO(getBaseContext());
                    hocPhiAdapter.setArrylist(hocPhiDAO.timKiem(edtTimKiem.getText().toString()));
                }
            }
        });
    }


    private void addControls() {
        edtTenHP = findViewById(R.id.edtQLHPTenHP);
        edtSoTien = findViewById(R.id.edtQLHPSoTien);
        edtHocKy = findViewById(R.id.edtQLHPHocKy);
        edtNamHoc = findViewById(R.id.edtQLHPNamHoc);
        edtTimKiem = findViewById(R.id.edtQLHPTimKiem);
        btnThem = findViewById(R.id.btnQLHPThem);
        lvHocPhi = findViewById(R.id.lvHocPhi);
        listHocPhi = new ArrayList<>();
        hocPhiAdapter = new HocPhiAdapter(this,listHocPhi,R.layout.hocphicustom);
        lvHocPhi.setAdapter(hocPhiAdapter);
        registerForContextMenu(lvHocPhi);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int possion = info.position; // lấy ra vị trí item mình chọn

        int id = item.getItemId(); // id của item
        switch (id){
            case R.id.menuSua:
                //nhảy đến chỗ sửa
                Intent intent = new Intent(getBaseContext(),SuaHocPhiActivity.class);
                intent.putExtra("hocphi",hocPhiAdapter.get(possion));
                startActivityForResult(intent,1);
                break;
            case R.id.menuXoa:
                //xoá cái item đó
                int idHocPhi = hocPhiAdapter.get(possion).getiMaHP();
                HocPhiDAO hocPhiDAO = new HocPhiDAO(getBaseContext());
                boolean result = hocPhiDAO.XoaHocPhi(idHocPhi);
                if (result){
                    //Xoá thành công
                    Toast.makeText(getBaseContext(),"Xoá thành công",Toast.LENGTH_SHORT).show();
                    LoadHcPhi2Listview();
                }else {
                    Toast.makeText(getBaseContext(),"Xoá thất bại",Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onContextItemSelected(item);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_CANCELED){
            LoadHcPhi2Listview();
        }
    }
}
