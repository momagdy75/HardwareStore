package com.example.project;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MbAdapter extends RecyclerView.Adapter<MbAdapter.MyViewHolder> {
    String[] name;
    String[] sub;
    String[] price;
    int[] images;
    Context context;
    public  MbAdapter(Context cx, String name[],String price[] ,String sub[], int images[]){
        context=cx;
        this.name=name;
        this.sub=sub;
        this.price=price;
        this.images=images;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View  view =inflater.inflate(R.layout.mb_product_row,viewGroup,false);
        final MyViewHolder holder = new MyViewHolder(view);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(name[i]);
        myViewHolder.price.setText(price[i]);
        myViewHolder.about.setText(sub[i]);
        myViewHolder.image.setImageResource(images[i]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView price;
        TextView about;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.mb_product_title);
            price=  itemView.findViewById(R.id.mb_product_price);
            about = itemView.findViewById(R.id.mb_product_about);
            image = itemView.findViewById(R.id.mb_product_image);
        }
    }

}
