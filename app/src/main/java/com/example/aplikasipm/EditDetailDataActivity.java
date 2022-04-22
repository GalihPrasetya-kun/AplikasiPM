package com.example.aplikasipm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class EditDetailDataActivity extends AppCompatActivity {
    Button btnSave, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_detail_data);
        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), DetailDataActivity.class));
        });

        btnSave = findViewById(R.id.btn_save);
    }
}