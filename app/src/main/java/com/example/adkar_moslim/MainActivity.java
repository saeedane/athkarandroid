package com.example.adkar_moslim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adkar_moslim.Adapter.AdapterRecycler;
import com.example.adkar_moslim.Model.Athkar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    TextView title;
    RecyclerView recyclerView;
    AdapterRecycler adapterRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        adapterRecycler = new AdapterRecycler(this,getData());
        recyclerView.setAdapter(adapterRecycler);


    }
    private ArrayList<Athkar> getData(){
        ArrayList<Athkar> athkar = new ArrayList<>();
        String Citation_morning = getResources().getString(R.string.Citation_morning);
        String Evening_prayers = getResources().getString(R.string.Evening_prayers);
        String Supplications = getResources().getString(R.string.Supplications);
        athkar.add(new Athkar(Citation_morning,R.drawable.masah));
        athkar.add(new Athkar(Evening_prayers,R.drawable.sabah));
        athkar.add(new Athkar(Supplications,R.drawable.do3a));
        return athkar;

    }

    private void init() {
         title = findViewById(R.id.title);
        recyclerView = findViewById(R.id.recycler);


    }


}
