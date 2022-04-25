package com.example.aplikasipm.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipm.R;

import java.util.List;

public class DataRecyclerAdapter {
    Context mContext;
    DataListAdapter mDataAdapter;

    public void setConfig(RecyclerView recyclerView, Context context, List<DataListModel> list, List<String> keys){
        mContext = context;
        mDataAdapter = new DataListAdapter(list, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mDataAdapter);
    }

    class DataListView extends RecyclerView.ViewHolder{
        TextView txtNoinduk, txtNama, txtNoktp;
        String key;

        public DataListView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.item_data, parent, false));
            txtNoinduk = (TextView) itemView.findViewById(R.id.txtNoinduk);
            txtNama = (TextView) itemView.findViewById(R.id.txtNama);
            txtNoktp = (TextView) itemView.findViewById(R.id.txtNoktp);
        }

        public void bind(DataListModel listData, String key){
            txtNoinduk.setText(listData.getNoinduk());
            txtNama.setText(listData.getNama());
            txtNoktp.setText(listData.getNoktp());
            this.key = key;
        }
    }

    class DataListAdapter extends RecyclerView.Adapter<DataListView>{
        List<DataListModel> mlist;
        List<String> mkeys;

        public DataListAdapter(List<DataListModel> mlist, List<String> mkeys) {
            this.mlist = mlist;
            this.mkeys = mkeys;
        }

        @NonNull
        @Override
        public DataListView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new DataListView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull DataListView holder, int position) {
            holder.bind(mlist.get(position), mkeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }
    }
}
