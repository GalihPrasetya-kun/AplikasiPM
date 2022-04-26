package com.example.aplikasipm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplikasipm.Model.DataFirebaseHelper;
import com.example.aplikasipm.Model.DataListModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TambahDataActivity extends AppCompatActivity {
    EditText etNoinduk, etNoktp, etNama, etTgllahir, etJkelamin, etStatus, etPendidikan, etAgama, etAlamat, etAsrama, etNohub, etPjawab, etTglmasuk;
    Button btnSave, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_data);
        etNoinduk = findViewById(R.id.etNoinduk);
        etNoktp = findViewById(R.id.etNoktp);
        etNama = findViewById(R.id.etNama);
        etTgllahir = findViewById(R.id.etTglLahir);
        etJkelamin = findViewById(R.id.etJKelamin);
        etStatus = findViewById(R.id.etStatus);
        etPendidikan = findViewById(R.id.etPendidikan);
        etAgama = findViewById(R.id.etAgama);
        etAlamat = findViewById(R.id.etAlamat);
        etAsrama = findViewById(R.id.etAsrama);
        etNohub = findViewById(R.id.etNoHub);
        etPjawab = findViewById(R.id.etPJawab);
        etTglmasuk = findViewById(R.id.etTglMasuk);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            finish();
            return;
        });

        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(v -> {
            DataListModel listData = new DataListModel();
            listData.setNoinduk(etNoinduk.getText().toString());
            listData.setNoktp(etNoktp.getText().toString());
            listData.setNama(etNama.getText().toString());
            listData.setTgllahir(etTgllahir.getText().toString());
            listData.setJkelamin(etJkelamin.getText().toString());
            listData.setStatus(etStatus.getText().toString());
            listData.setPendidikan(etPendidikan.getText().toString());
            listData.setAgama(etAgama.getText().toString());
            listData.setAlamat(etAlamat.getText().toString());
            listData.setAsrama(etAsrama.getText().toString());
            listData.setNohub(etNohub.getText().toString());
            listData.setPjawab(etPjawab.getText().toString());
            listData.setTglmasuk(etTglmasuk.getText().toString());
            new DataFirebaseHelper().addData(listData, new DataFirebaseHelper.DataStatus() {
                @Override
                public void DataIsLoaded(List<DataListModel> list, List<String> keys) {

                }

                @Override
                public void DataIsInserted() {
                    Toast.makeText(TambahDataActivity.this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void DataIsUpdated() {

                }

                @Override
                public void DataIsDeleted() {

                }
            });
        });
    }
}