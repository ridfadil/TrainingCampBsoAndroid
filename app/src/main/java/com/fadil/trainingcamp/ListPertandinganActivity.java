package com.fadil.trainingcamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class ListPertandinganActivity extends AppCompatActivity {

    private final LinkedList<Pertandingan> listPertandingan = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private ListPertandinganAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pertandingan);

        //set data
        listPertandingan.addLast(new Pertandingan("Persija","Persib", R.drawable.persib, R.drawable.persija));
        listPertandingan.addLast(new Pertandingan("Persib","PSM", R.drawable.persib, R.drawable.persija));
        listPertandingan.addLast(new Pertandingan("Persib","Persipura", R.drawable.persib, R.drawable.persija));
        listPertandingan.addLast(new Pertandingan("Persib","Sriwijaya FC", R.drawable.persib, R.drawable.persija));

        mRecyclerView = (RecyclerView) findViewById(R.id.list_pertandingan_cyc);

        mAdapter = new ListPertandinganAdapter(ListPertandinganActivity.this, listPertandingan);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
