package com.fadil.trainingcamp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CounterActivity extends AppCompatActivity {

    Button point_persija, point_persib, reset, min_persib, min_persija,show_news,show_maps,list_club;
    TextView txt_persija, txt_persib,txt_persija_list,txt_persib_list;
    int pointPersija = 0, pointPersib = 0;
    String convertPoint;
    ImageView detail_persib, detail_persija;
    ImageView logoTimSatu, logoTimDua;
    TextView namaTimSatu, namaTimDua;

    int scorePersib, scorePersija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        point_persib = findViewById(R.id.point_persib);
        point_persija = findViewById(R.id.point_persija);
        txt_persib = findViewById(R.id.txt_persib);
        txt_persija = findViewById(R.id.txt_persija);
        detail_persija = findViewById(R.id.detail_persija);
        detail_persib = findViewById(R.id.detail_persib);
        reset = findViewById(R.id.reset);
        min_persib = findViewById(R.id.min_persib);
        min_persija = findViewById(R.id.min_persija);
        show_news = findViewById(R.id.show_news);
        show_maps = findViewById(R.id.show_maps);
        list_club = findViewById(R.id.list_club);
        txt_persib_list = findViewById(R.id.txt_persib_list);
        txt_persija_list = findViewById(R.id.txt_persija_list);

        //untuk enampilkan back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Counter Board");

        //untuk mengatur view dan menerima passing data dari intent sebelumnya
        txt_persija_list.setText(getIntent().getStringExtra("namTimSatu"));
        txt_persib_list.setText(getIntent().getStringExtra("namaTimDua"));
        detail_persija.setImageResource(getIntent().getIntExtra("logoTimSatu",0));
        detail_persib.setImageResource(getIntent().getIntExtra("logoTimDua",0));



        point_persija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PointPersija();
                convertPoint = String.valueOf(pointPersija);
                txt_persija.setText(convertPoint);
            }
        });

        point_persib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PointPersib();
                convertPoint = String.valueOf(pointPersib);
                txt_persib.setText(convertPoint);
            }
        });

        detail_persib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CounterActivity.this, DetailPersibActivity.class);
                startActivity(intent);
                Toast.makeText(CounterActivity.this, "Anda melihat Detail Persib", Toast.LENGTH_SHORT).show();
            }
        });

        detail_persija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CounterActivity.this, DetailPersijaActivity.class);
                startActivity(intent);
                Toast.makeText(CounterActivity.this, "Anda Melihat Deatail Persija", Toast.LENGTH_SHORT).show();
            }
        });

        min_persib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minpointpersib();
                convertPoint = String.valueOf(pointPersib);
                txt_persib.setText(convertPoint);
            }
        });

        min_persija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minpointpersija();
                convertPoint = String.valueOf(pointPersija);
                txt_persija.setText(convertPoint);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetpointpersija();
                resetpointpersib();
                String i = "0";
                txt_persib.setText(i);
                txt_persija.setText(i);
            }
        });
        show_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                String URL = "https://sport.detik.com/sepakbola/liga-indonesia";
                i.setData(Uri.parse(URL));
                startActivity(i);
            }
        });

        show_maps.setOnClickListener(new View.OnClickListener() {
            String name ="Pertandingan berlangsung di glora Bungkarno";
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=-6.219839,106.802525 (" + name + ")"));
                startActivity(intent);
            }
        });
        list_club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CounterActivity.this, ListClubActivity.class);
                startActivity(intent);
                Toast.makeText(CounterActivity.this, "Anda Melihat list Club Liga Indonesia", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public int PointPersija() {
        pointPersija++;
        return pointPersija;
    }

    public int PointPersib() {
        pointPersib++;
        return pointPersib;
    }

    public int resetpointpersib() {
        pointPersib = 0;
        return pointPersib;
    }

    public int resetpointpersija() {
        pointPersija = 0;
        return pointPersija;
    }

    public int minpointpersija() {
        if (pointPersija > 0) {
            pointPersija--;
        } else {
            Toast.makeText(CounterActivity.this, "Wrong Point", Toast.LENGTH_SHORT).show();
        }
        return pointPersija;
    }

    public int minpointpersib() {
        if (pointPersib > 0) {
            pointPersib--;
        } else {
            Toast.makeText(CounterActivity.this, "Wrong Point", Toast.LENGTH_SHORT).show();
        }
        return pointPersib;
    }
    //fungsi back ketika tombol back diklik
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
