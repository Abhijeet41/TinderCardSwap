package com.example.tindercardswap.Adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tindercardswap.Model.Product;
import com.example.tindercardswap.Productdetails;
import com.example.tindercardswap.R;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CardsAdapter extends BaseAdapter {

    private Activity activity;
    private List<Product> loadProducts;

    public CardsAdapter(Activity mainActivity, List<Product> loadProducts) {
        this.loadProducts = loadProducts;
        this.activity = mainActivity;

    }

    @Override
    public int getCount() {
        return loadProducts.size();
    }

    @Override
    public Object getItem(int position) {
        return loadProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.item_card, parent, false);

            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(loadProducts.get(position).getName());
     //   holder.avatar.setImageResource(data.get(position).getDrawableId());
        loadImage(holder.avatar, loadProducts.get(position).getImageUrl());

       holder.viewDetails.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final Dialog dialog = new Dialog(activity);
               // Include dialog.xml file
               dialog.setContentView(R.layout.dialog);
               // Set dialog title
               dialog.setTitle("Custom Dialog");

               // set values for custom dialog components - text, image and button
               TextView text = (TextView) dialog.findViewById(R.id.name);
               text.setText(loadProducts.get(position).getName());
               ImageView image = (ImageView) dialog.findViewById(R.id.image);
               loadImage(image,loadProducts.get(position).getImageUrl());

               TextView viewDetails = dialog.findViewById(R.id.viewDetails);
               viewDetails.setText(loadProducts.get(position).getDescription());

               TextView price = dialog.findViewById(R.id.price);
               price.setText(loadProducts.get(position).getPrice());
               dialog.show();

           }
       });

        return convertView;
    }

    InputStream inputstream;
    Drawable drawable;
    private void loadImage(ImageView imageView, String imageName) {
        try {
            inputstream = activity.getAssets().open("images/" + imageName);
            drawable = Drawable.createFromStream(inputstream, null);
            imageView.setImageDrawable(drawable);
        } catch (Exception ex) {

        }
    }

    private class ViewHolder {
        private ImageView avatar;
        private TextView name,viewDetails;



        public ViewHolder(View view) {
            avatar = (ImageView) view.findViewById(R.id.avatar);
            name = (TextView) view.findViewById(R.id.name);
            viewDetails = (TextView) view.findViewById(R.id.view);

        }
    }
}
