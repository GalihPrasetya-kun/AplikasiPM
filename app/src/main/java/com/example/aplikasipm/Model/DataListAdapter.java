package com.example.aplikasipm.Model;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipm.DetailDataActivity;
import com.example.aplikasipm.R;

import java.util.ArrayList;

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.myViewHolder> {

    Context context;
    ArrayList<DataListModel> list;

    public DataListAdapter(Context context, ArrayList<DataListModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DataListAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_data, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataListAdapter.myViewHolder holder, int position) {
        DataListModel data = list.get(position);
        holder.txtNoinduk.setText(data.getNoinduk());
        holder.txtNama.setText(data.getNama());
        holder.txtNoktp.setText(data.getNoktp());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtNoinduk, txtNama, txtNoktp;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNoinduk = itemView.findViewById(R.id.txtNoinduk);
            txtNama = itemView.findViewById(R.id.txtNama);
            txtNoktp = itemView.findViewById(R.id.txtKtp);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = this.getAdapterPosition();
            DataListModel data = list.get(position);
            String noinduk = data.getNoinduk();
            String nama = data.getNama();
            String noktp = data.getNoktp();

            Intent intent = new Intent(context, DetailDataActivity.class);
            intent.putExtra("no induk", noinduk);
            intent.putExtra("nama", nama);
            intent.putExtra("no ktp", noktp);
            context.startActivity(intent);
        }
    }
}
