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
import android.widget.Button;

public class gpu extends Fragment  {


    Context context;
    RecyclerView recyclerView;

    String[] name,sub,price;

    int[] images={R.drawable.rtx3090,R.drawable.rtx3080ti,R.drawable.rtx3080,R.drawable.rtx3070ti,R.drawable.rtx3070,R.drawable.rtx3060ti,R.drawable.gtx1660ti,R.drawable.gtx1650};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.context=container.getContext();
        View view =inflater.inflate(R.layout.gpu_layout,container,false);
        initrecyclerView(view);

        return view;


    }
    private void initrecyclerView(View view){
        recyclerView =view.findViewById(R.id.Gpu_products);
        name = getResources().getStringArray(R.array.Gpu_Products_Name);
        price = getResources().getStringArray(R.array.Gpu_Products_Prices);
        sub = getResources().getStringArray(R.array.Gpu_description);
        GpuAdapter gpuAdapter = new GpuAdapter(context,name,price,sub,images);
        LinearLayoutManager layoutManager =new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(gpuAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }




}
