package com.example.aplikasipm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class TambahDataActivity extends AppCompatActivity {
    EditText etNoinduk, etNoktp, etNama, etTgllahir, etJkelamin, etStatus, etPendidikan, etAgama, etAlamat, etAsrama, etNohub, etPjawab, etTglmasuk;
    Button btnSave, btnBack;
    DatabaseReference mRef;

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

        mRef = FirebaseDatabase.getInstance().getReference();

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });

        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(v -> {
            createData();
        });
    }

    private void createData() {
        Map<String, Object> map = new HashMap<>();
        map.put("no induk", etNoinduk.getText().toString());
        map.put("no ktp", etNoktp.getText().toString());
        map.put("nama", etNama.getText().toString());
        map.put("tempat tanggal lahir", etTgllahir.getText().toString());
        map.put("jenis kelamin", etJkelamin.getText().toString());
        map.put("status", etStatus.getText().toString());
        map.put("pendidikan", etPendidikan.getText().toString());
        map.put("agama", etAgama.getText().toString());
        map.put("alamat", etAlamat.getText().toString());
        map.put("asrama", etAsrama.getText().toString());
        map.put("no hub", etNohub.getText().toString());
        map.put("penanggung jawab", etPjawab.getText().toString());
        map.put("tanggal masuk", etTglmasuk.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Penerima").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(TambahDataActivity.this, "Data berhasil tersimpan", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(TambahDataActivity.this, "Data gagal tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}