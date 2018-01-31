package com.fadil.trainingcamp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailPersibActivity extends AppCompatActivity {
    TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_persib);
        res = findViewById(R.id.res_persib);

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                String URL = "https://en.wikipedia.org/wiki/Persib_Bandung";
                i.setData(Uri.parse(URL));
                startActivity(i);
            }
        });
    }
}
