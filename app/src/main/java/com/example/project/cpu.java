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

public class cpu extends Fragment {
    Context context;
    RecyclerView recyclerView;

    String[] name,sub,price;
    int[] images={R.drawable.i99th,R.drawable.i78th,R.drawable.i7x,R.drawable.i57th};
    @Nullable
    @Override



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.context=container.getContext();
        View view =inflater.inflate(R.layout.cpu_layout,container,false);
        initrecyclerView(view);

        return view;

    }
    private void initrecyclerView(View view){
        recyclerView =view.findViewById(R.id.Cpu_products);
        name = getResources().getStringArray(R.array.Cpu_Products_Name);
        price = getResources().getStringArray(R.array.Cpu_Products_Prices);
        sub = getResources().getStringArray(R.array.Cpu_description);
        Cpu_Adapter cpuAdapter = new Cpu_Adapter(context,name,price,sub,images);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(cpuAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
