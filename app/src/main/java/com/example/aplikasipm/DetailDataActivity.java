package com.example.aplikasipm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aplikasipm.Model.DataFirebaseHelper;
import com.example.aplikasipm.Model.DataListModel;

import java.util.List;

public class DetailDataActivity extends AppCompatActivity {
    TextView txtNoinduk, txtNoktp, txtNama, txtTgllahir, txtJkelamin, txtStatus, txtPendidikan, txtAgama, txtAlamat, txtAsrama, txtNohub, txtPjawab, txtTglmasuk;
    Button btnBack, btnDelete, btnEdit, btnCreate;

    String key, noinduk, noktp, nama, tgllahir, jkelamin, status, pendidikan, agama, alamat, asrama, nohub, pjawab, tglmasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);
        key = getIntent().getStringExtra("key");
        noinduk = getIntent().getStringExtra("noinduk");
        noktp = getIntent().getStringExtra("noktp");
        nama = getIntent().getStringExtra("nama");
        tgllahir = getIntent().getStringExtra("tgllahir");
        jkelamin = getIntent().getStringExtra("jkelamin");
        status = getIntent().getStringExtra("status");
        pendidikan = getIntent().getStringExtra("pendidikan");
        agama = getIntent().getStringExtra("agama");
        alamat = getIntent().getStringExtra("alamat");
        asrama = getIntent().getStringExtra("asrama");
        nohub = getIntent().getStringExtra("nohub");
        pjawab = getIntent().getStringExtra("pjawab");
        tglmasuk = getIntent().getStringExtra("tglmasuk");

        txtNoinduk = findViewById(R.id.txtNoinduk);
        txtNoinduk.setText(noinduk);
        txtNoktp = findViewById(R.id.txtNoktp);
        txtNoktp.setText(noktp);
        txtNama = findViewById(R.id.txtNama);
        txtNama.setText(nama);
        txtTgllahir = findViewById(R.id.txtTglLahir);
        txtTgllahir.setText(tgllahir);
        txtJkelamin = findViewById(R.id.txtJKelamin);
        txtJkelamin.setText(jkelamin);
        txtStatus = findViewById(R.id.txtStatus);
        txtStatus.setText(status);
        txtPendidikan = findViewById(R.id.txtPendidikan);
        txtPendidikan.setText(pendidikan);
        txtAgama = findViewById(R.id.txtAgama);
        txtAgama.setText(agama);
        txtAlamat = findViewById(R.id.txtAlamat);
        txtAlamat.setText(alamat);
        txtAsrama = findViewById(R.id.txtAsrama);
        txtAsrama.setText(asrama);
        txtNohub = findViewById(R.id.txtNoHub);
        txtNohub.setText(nohub);
        txtPjawab = findViewById(R.id.txtPJawab);
        txtPjawab.setText(pjawab);
        txtTglmasuk = findViewById(R.id.txtTglMasuk);
        txtTglmasuk.setText(tglmasuk);

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            finish();
            return;
        });

        btnDelete = findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DataFirebaseHelper().deleteData(key, new DataFirebaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<DataListModel> list, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(DetailDataActivity.this, "Data Berhasil Dihapus", Toast.LENGTH_SHORT).show();
                        finish();
                        return;
                    }
                });
            }
        });

        btnEdit = findViewById(R.id.btn_edit);
        btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(DetailDataActivity.this, EditDetailDataActivity.class);
            intent.putExtra("key", key);
            intent.putExtra("noinduk", txtNoinduk.getText().toString());
            intent.putExtra("noktp", txtNoktp.getText().toString());
            intent.putExtra("nama", txtNama.getText().toString());
            intent.putExtra("tgllahir", txtTgllahir.getText().toString());
            intent.putExtra("jkelamin", txtJkelamin.getText().toString());
            intent.putExtra("status", txtStatus.getText().toString());
            intent.putExtra("pendidikan", txtPendidikan.getText().toString());
            intent.putExtra("agama", txtAgama.getText().toString());
            intent.putExtra("alamat", txtAlamat.getText().toString());
            intent.putExtra("asrama", txtAsrama.getText().toString());
            intent.putExtra("nohub", txtNohub.getText().toString());
            intent.putExtra("pjawab", txtPjawab.getText().toString());
            intent.putExtra("tglmasuk", txtTglmasuk.getText().toString());
            startActivity(intent);
        });

        btnCreate = findViewById(R.id.btn_create);
        btnCreate.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), TambahCatatanDataActivity.class));
        });
    }
}