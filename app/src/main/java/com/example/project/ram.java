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

public class ram extends Fragment {
    Context context;
    RecyclerView recyclerView;

    String[] name,sub,price;

    int[] images={R.drawable.tridentz,R.drawable.maverik,R.drawable.royal_elite,R.drawable.sniper_x};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.context=container.getContext();
        View view =inflater.inflate(R.layout.ram_layout,container,false);
        initrecyclerView(view);

        return view;
    }
    private void initrecyclerView(View view){
        recyclerView =view.findViewById(R.id.Ram_products);
        name = getResources().getStringArray(R.array.Ram_Products_Name);
        price = getResources().getStringArray(R.array.Ram_Products_Prices);
        sub = getResources().getStringArray(R.array.Ram_description);
        GpuAdapter gpuAdapter = new GpuAdapter(context,name,price,sub,images);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(gpuAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
