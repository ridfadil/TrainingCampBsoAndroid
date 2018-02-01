package com.fadil.trainingcamp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by fadil on 2/1/18.
 */

public class ListPertandinganAdapter extends RecyclerView.Adapter<ListPertandinganAdapter.ListPertandinganViewHolder> {

    //deklarasi global variabel
    private Context context;
    private final LinkedList<ModelPertandingan> listPertandingan;

    //konstruktor untuk menerima data adapter
    public ListPertandinganAdapter(Context context, LinkedList<ModelPertandingan> listPertandingan) {
        this.context = context;
        this.listPertandingan = listPertandingan;
    }

    //view holder berfungsi untuk setting list item yang digunakan
    @Override
    public ListPertandinganViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pertandingan, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mItemView.setLayoutParams(layoutParams);

        return new ListPertandinganViewHolder(mItemView, this);
    }

    //bind view holder berfungsi untuk set data ke view yang ditampilkan pada list item
    @Override
    public void onBindViewHolder(ListPertandinganViewHolder holder, int position) {
        final ModelPertandingan mCurrent = listPertandingan.get(position);
        holder.tvTimSatu.setText(mCurrent.getTimSatu());
        holder.tvTimDua.setText(mCurrent.getTimDua());
        holder.logoTimSatu.setImageResource(mCurrent.getLogoTimSatu());
        holder.logoTimDua.setImageResource(mCurrent.getLogoTimDua());
        holder.away.setText("Away");
        holder.home.setText("Home");
        holder.tvVs.setText("VS");
    }

    //untuk menghitung jumlah data yang ada pada list
    @Override
    public int getItemCount() {
        return listPertandingan.size();
    }

    public class ListPertandinganViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvTimSatu, tvTimDua, tvVs, home, away;
        private ImageView logoTimSatu, logoTimDua;

        final ListPertandinganAdapter mAdapter;

        //untuk casting view yang digunakan pada list item
        public ListPertandinganViewHolder(View itemView, ListPertandinganAdapter adapter) {
            super(itemView);
            home = (TextView) itemView.findViewById(R.id.home);
            away = (TextView) itemView.findViewById(R.id.away);
            tvTimSatu = (TextView) itemView.findViewById(R.id.tv_tim_satu);
            tvTimDua = (TextView) itemView.findViewById(R.id.tv_tim_dua);
            tvVs = (TextView) itemView.findViewById(R.id.tv_vs);
            logoTimSatu = (ImageView) itemView.findViewById(R.id.logo_tim_satu);
            logoTimDua = (ImageView) itemView.findViewById(R.id.logo_tim_dua);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        //untuk menambah action click pada list item
        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
            ModelPertandingan element = listPertandingan.get(mPosition);

            //intent ke main activity dengan passing data
            Intent i = new Intent(context, CounterActivity.class);
            i.putExtra("namTimSatu", element.getTimSatu());
            i.putExtra("namaTimDua", element.getTimDua());
            i.putExtra("logoTimSatu", element.getLogoTimSatu());
            i.putExtra("logoTimDua", element.getLogoTimDua());
            context.startActivity(i);
            mAdapter.notifyDataSetChanged();
        }
    }
}
