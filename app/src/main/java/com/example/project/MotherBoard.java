package com.example.project;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MotherBoard extends Fragment {
    Context context;
    RecyclerView recyclerView;

    String[] name,sub,price;
    int[] images={R.drawable.b660_aorus,R.drawable.b660_ds3h,R.drawable.prime_z690_a,R.drawable.z690_plus_wifi};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.context=container.getContext();
        View view =inflater.inflate(R.layout.motherboard_layout,container,false);
        initrecyclerView(view);
        return view;
    }
    private void initrecyclerView(View view){
        recyclerView =view.findViewById(R.id.mb_products);
        name = getResources().getStringArray(R.array.Mb_Products_Name);
        price = getResources().getStringArray(R.array.Mb_Products_Prices);
        sub = getResources().getStringArray(R.array.Mb_description);
        MbAdapter mbAdapter = new MbAdapter(context,name,price,sub,images);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(mbAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
