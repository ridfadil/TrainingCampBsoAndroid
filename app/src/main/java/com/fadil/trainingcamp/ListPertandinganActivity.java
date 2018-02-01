package com.fadil.trainingcamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class ListPertandinganActivity extends AppCompatActivity {

    private final LinkedList<ModelPertandingan> listPertandingan = new LinkedList<>();

    private RecyclerView mRecyclerView;
    private ListPertandinganAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pertandingan);

        //set data
        listPertandingan.addLast(new ModelPertandingan("Persija"," Persib", R.drawable.persija, R.drawable.persib));
        listPertandingan.addLast(new ModelPertandingan("Psms","Arema", R.drawable.psms, R.drawable.arema));
        listPertandingan.addLast(new ModelPertandingan("Sriwijaya","Persib", R.drawable.sriwijaya, R.drawable.persib));

        mRecyclerView = (RecyclerView) findViewById(R.id.list_pertandingan_cyc);

        mAdapter = new ListPertandinganAdapter(ListPertandinganActivity.this, listPertandingan);

        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
