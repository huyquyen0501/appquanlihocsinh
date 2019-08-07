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

import com.example.tran.qlhocphi.Adapter.HocSinhAdapter;
import com.example.tran.qlhocphi.DAO.HocSinhDAO;

import com.example.tran.qlhocphi.DTO.HocSinhDTO;
import com.example.tran.qlhocphi.R;

import java.util.ArrayList;



public class QLHocSinhActivity extends AppCompatActivity {
    Button btnThem;
    EditText edtTimKiem;
    ListView lvHocSinh;
    ArrayList<HocSinhDTO> listHS;
    HocSinhAdapter hocSinhAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlhoc_sinh);
        addControls();
        addEvents();
        LoadData2LV();
    }

    private void LoadData2LV() {
        HocSinhDAO hocSinhDAO = new HocSinhDAO(getBaseContext());
        hocSinhAdapter.setArrylist(hocSinhDAO.getAll());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED){
            LoadData2LV();
        }
    }

    private void addEvents() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ThemHocSinhActivity.class);
                startActivityForResult(intent,1);
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
                    LoadData2LV();
                }else {
                    HocSinhDAO hocSinhDAO = new HocSinhDAO(getBaseContext());
                    hocSinhAdapter.setArrylist(hocSinhDAO.timKiem(edtTimKiem.getText().toString()));
                }
            }
        });
    }

    private void addControls() {
        listHS = new ArrayList<>();
        btnThem =findViewById(R.id.btnQLThemHocSinh);
        lvHocSinh = findViewById(R.id.lvDSHocSinh);
        edtTimKiem = findViewById(R.id.edtQLHSTimKiem);


        hocSinhAdapter = new HocSinhAdapter(this,listHS,R.layout.hocsinhcustom);
        lvHocSinh.setAdapter(hocSinhAdapter);
        registerForContextMenu(lvHocSinh);
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
                Intent intent = new Intent(getBaseContext(),SuaHocSinhActivity.class);
                intent.putExtra("hocsinh",hocSinhAdapter.get(possion));
                startActivityForResult(intent,1);
                break;
            case R.id.menuXoa:
                //xoá cái item đó
                int idHocSinh = hocSinhAdapter.get(possion).getiMaHS();
                HocSinhDAO hocSinhDAO = new HocSinhDAO(getBaseContext());
                boolean result = hocSinhDAO.XoaHocSinh(idHocSinh);
                if (result){
                    //Xoá thành công
                    Toast.makeText(getBaseContext(),"Xoá thành công",Toast.LENGTH_SHORT).show();
                    LoadData2LV();
                }else {
                    Toast.makeText(getBaseContext(),"Xoá thất bại",Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onContextItemSelected(item);

    }
}
