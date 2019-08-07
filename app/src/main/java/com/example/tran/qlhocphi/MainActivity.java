package com.example.tran.qlhocphi;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.tran.qlhocphi.R;


public class MainActivity extends AppCompatActivity {
    Button btnQLHS,btnQLHP,btnQLThuHP,btnDongHocPhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }
    private void addEvents() {
        btnQLHS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),QLHocSinhActivity.class);
                startActivity(intent);
            }
        });
        btnQLHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),QLHocPhiActivity.class);
                startActivity(intent);
            }
        });
        btnQLThuHP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),QLThuHocPhiActivity.class);
                startActivity(intent);
            }
        });
        btnDongHocPhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),DSDongHocPhiActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        btnQLHS = findViewById(R.id.btnMainQLHS);
        btnQLHP = findViewById(R.id.btnMainQLHP);
        btnQLThuHP =findViewById(R.id.btnMainQLThuHP);
        btnDongHocPhi = findViewById(R.id.btnMainDSDongHP);
    }

}

