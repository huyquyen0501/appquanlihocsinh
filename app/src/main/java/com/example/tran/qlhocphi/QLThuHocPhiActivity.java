package com.example.tran.qlhocphi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tran.qlhocphi.Adapter.SoGhiAdapter;
import com.example.tran.qlhocphi.DAO.SoGhiDAO;
import com.example.tran.qlhocphi.DTO.SoGhiDTO;
import com.example.tran.qlhocphi.R;

import java.util.ArrayList;



public class QLThuHocPhiActivity extends AppCompatActivity {
    EditText edtMaHs,edtMaHP,edtNgayLap;
    Button btnThem;
    ListView lvThuHP;
    ArrayList<SoGhiDTO> list;
    SoGhiAdapter soGhiAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qlthu_hoc_phi);
        addControls();
        addEvents();
        LoadData2Lv();
    }

    private void LoadData2Lv() {
        SoGhiDAO soGhiDAO = new SoGhiDAO(getBaseContext());
        soGhiAdapter.setArrylist(soGhiDAO.getAll());
    }

    private void addEvents() {
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoGhiDAO soGhiDAO = new SoGhiDAO(getBaseContext());
                SoGhiDTO soGhi = new SoGhiDTO();
                soGhi.setiMaHS(Integer.parseInt(edtMaHs.getText().toString()));
                soGhi.setiMaHP(Integer.parseInt(edtMaHP.getText().toString()));
                soGhi.setsNgayLap(edtNgayLap.getText().toString());
                long result = soGhiDAO.InsertThuHocPhi(soGhi);
                if (result != 0){
                    Toast.makeText(getBaseContext(),"Thêm thành công",Toast.LENGTH_SHORT).show();
                    LoadData2Lv();
                }
            }
        });
    }

    private void addControls() {
        list = new ArrayList<>();

        edtMaHs = findViewById(R.id.edtQLTHPMaHS);
        edtMaHP = findViewById(R.id.edtQLTHPMaHP);
        edtNgayLap = findViewById(R.id.edtQLTHPNgayLap);
        btnThem = findViewById(R.id.btnQLTHPThem);

        lvThuHP = findViewById(R.id.lvThuHocPhi);
        soGhiAdapter = new SoGhiAdapter(this,list,R.layout.soghicustom);
        lvThuHP.setAdapter(soGhiAdapter);
        registerForContextMenu(lvThuHP);
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
                Intent intent = new Intent(getBaseContext(),SuaSoThuPhiActivity.class);
                intent.putExtra("soghi",soGhiAdapter.get(possion));
                startActivityForResult(intent,1);
                break;
            case R.id.menuXoa:
                //xoá cái item đó
                int idSoGhi = soGhiAdapter.get(possion).getiMaSoGhi();
                SoGhiDAO soGhiDAO = new SoGhiDAO(getBaseContext());
                boolean result = soGhiDAO.XoaSoGhi(idSoGhi);
                if (result){
                    //Xoá thành công
                    Toast.makeText(getBaseContext(),"Xoá thành công",Toast.LENGTH_SHORT).show();
                    LoadData2Lv();
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
            LoadData2Lv();
        }
    }
}
