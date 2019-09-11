package com.example.tindercardswap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.tindercardswap.Adapter.RecyclerviewaAdapter;

import static com.example.tindercardswap.Constant.imageArraylist;
import static com.example.tindercardswap.Constant.nameArraylist;

public class Productdetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetails);



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerviewaAdapter customAdapter = new RecyclerviewaAdapter(Productdetails.this,nameArraylist,imageArraylist);
        recyclerView.setAdapter(customAdapter);



    }
}
