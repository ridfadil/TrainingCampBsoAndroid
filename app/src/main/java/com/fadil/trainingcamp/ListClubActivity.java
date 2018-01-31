package com.fadil.trainingcamp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListClubActivity extends AppCompatActivity {

    String [] titles = {"Persib Bandung","Persija Jakarta","Arema Malang","Psms Medan","Sriwijaya Palembang"};
    String [] descriptions = {"Club Asal Bandung,Merupakan Club Kebanggaan Orang Bandung",
            "Club Asal jakarta, Merupakan Club Kebanggaan Orang Jakarta",
            "Club Asal Malang, Merupakan Club Kebanggaan Orang Malang",
            "Club Asal medan, Merupakan Club Kebanggaan Orang Medan",
            "Club Asal palembang, Merupakan Club Kebanggaan Orang Palembang"};
    String [] jadwal = {"jadwal pertandingan 02/07/2018","jadwal pertandingan 03/07/2018","jadwal pertandingan 04/07/2018","jadwal pertandingan 05/07/2018","jadwal pertandingan 06/07/2018"};
    int [] images = {R.drawable.persib,R.drawable.persija,R.drawable.arema,R.drawable.psms,R.drawable.sriwijaya};
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_club);
        lv = findViewById(R.id.idListView);
        MyAdapter adapter = new MyAdapter(this,titles,descriptions,images,jadwal);
        lv.setAdapter(adapter);
    }
}

class MyAdapter extends ArrayAdapter {
    int [] imageArray;
    String [] titleArray;
    String [] descArray;
    String [] jadwalArray;
    public MyAdapter(Context context, String[] titles1, String[] descriptions1, int[] img1 ,String [] jadwal1){
        super(context, R.layout.custom_list_club,R.id.Title,titles1);
        this.imageArray=img1;
        this.jadwalArray=jadwal1;
        this.titleArray=titles1;
        this.descArray=descriptions1;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //inflating layout
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_list_club,parent,false);

        //Get reference to the view object
        ImageView myImage =  row.findViewById(R.id.idPic);
        TextView myTitle =  row.findViewById(R.id.Title);
        TextView myDescriptions =  row.findViewById(R.id.idDescription);
        TextView myJadwal =  row.findViewById(R.id.idJadwal);


        //Providing the element of array by speciping its position
        myImage.setImageResource(imageArray[position]);
        myTitle.setText(titleArray[position]);
        myDescriptions.setText(descArray[position]);
        myJadwal.setText(jadwalArray[position]);
        return  row;
    }
}