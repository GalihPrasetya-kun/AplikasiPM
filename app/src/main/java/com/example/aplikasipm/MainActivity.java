package com.example.aplikasipm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button btnTambah, btnPenerima, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTambah = findViewById(R.id.btn_tambah);
        btnPenerima = findViewById(R.id.btn_penerima);
        btnLogout = findViewById(R.id.btn_logout);

        btnTambah.setOnClickListener(v ->{

        });
        btnPenerima.setOnClickListener(v ->{

        });
        btnLogout.setOnClickListener(v ->{
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        });
    }
}