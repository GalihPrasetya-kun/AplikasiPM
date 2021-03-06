package com.example.aplikasipm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aplikasipm.Model.DataFirebaseHelper;
import com.example.aplikasipm.Model.DataListModel;
import com.example.aplikasipm.Model.DataRecyclerAdapter;

import java.util.List;

public class ListDataActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        mRecyclerView = findViewById(R.id.recyclerView);
        new DataFirebaseHelper().readData(new DataFirebaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<DataListModel> list, List<String> keys) {
                findViewById(R.id.progressBar).setVisibility(View.GONE);
                new DataRecyclerAdapter().setConfig(mRecyclerView, ListDataActivity.this, list, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        });
    }
}