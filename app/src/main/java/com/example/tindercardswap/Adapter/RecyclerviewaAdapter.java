package com.example.tindercardswap.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tindercardswap.Productdetails;
import com.example.tindercardswap.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class RecyclerviewaAdapter extends RecyclerView.Adapter<RecyclerviewaAdapter.MyViewHolder> {

    List<String> nameList,imageArraylist;
    Context context;

    public RecyclerviewaAdapter(Productdetails productdetails, List<String> nameArraylist, List<String> imageArraylist) {
        this.context = productdetails;
        this.nameList = nameArraylist;
        this.imageArraylist = imageArraylist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rowlayout, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.name.setText(nameList.get(i));
        loadImage(holder.img, imageArraylist.get(i));
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;// init the item view's
        ImageView img;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);
        }
    }
    InputStream inputstream;
    Drawable drawable;
    private void loadImage(ImageView imageView, String imageName) {
        try {
            inputstream = context.getAssets().open("images/" + imageName);
            drawable = Drawable.createFromStream(inputstream, null);
            imageView.setImageDrawable(drawable);
        } catch (Exception ex) {

        }
    }
}
