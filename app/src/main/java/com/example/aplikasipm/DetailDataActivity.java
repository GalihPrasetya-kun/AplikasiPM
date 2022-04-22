package com.example.aplikasipm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

public class DetailDataActivity extends AppCompatActivity {
    TextView txtNoinduk, txtNoktp, txtNama, txtTgllahir, txtJkelamin, txtStatus, txtPendidikan, txtAgama, txtAlamat, txtAsrama, txtNohub, txtPjawab, txtTglmasuk;
    Button btnBack, btnDelete, btnEdit, btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);
        txtNoinduk = findViewById(R.id.txtNoinduk);
        txtNoktp = findViewById(R.id.txtNoktp);
        txtNama = findViewById(R.id.txtNama);
        txtTgllahir = findViewById(R.id.txtTglLahir);
        txtJkelamin = findViewById(R.id.txtJKelamin);
        txtStatus = findViewById(R.id.txtStatus);
        txtPendidikan = findViewById(R.id.txtPendidikan);
        txtAgama = findViewById(R.id.txtAgama);
        txtAlamat = findViewById(R.id.txtAlamat);
        txtAsrama = findViewById(R.id.txtAsrama);
        txtNohub = findViewById(R.id.txtNoHub);
        txtPjawab = findViewById(R.id.txtPJawab);
        txtTglmasuk = findViewById(R.id.txtTglMasuk);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), ListDataActivity.class));
        });

        btnDelete = findViewById(R.id.btn_delete);

        btnEdit = findViewById(R.id.btn_edit);
        btnEdit.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), EditDetailDataActivity.class));
        });

        btnCreate = findViewById(R.id.btn_create);
        btnCreate.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahCatatanDataActivity.class));
        });
    }
}