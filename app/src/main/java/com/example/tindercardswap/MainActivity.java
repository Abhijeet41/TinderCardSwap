package com.example.tindercardswap;

import android.content.Intent;
import android.os.Build;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tindercardswap.Adapter.CardsAdapter;
import com.example.tindercardswap.Adapter.RecyclerviewaAdapter;
import com.example.tindercardswap.Model.Product;

import java.util.ArrayList;
import java.util.List;

import link.fls.swipestack.SwipeStack;

import static com.example.tindercardswap.Constant.imageArraylist;
import static com.example.tindercardswap.Constant.nameArraylist;

public class MainActivity extends AppCompatActivity {

    private SwipeStack cardStack;
    private int currentPosition;
    private List<Product> loadProducts;
    CardsAdapter cardsAdapter;
    TextView commit_count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardStack = (SwipeStack) findViewById(R.id.container);
        currentPosition = 0;

        addDetails();

        cardStack.setListener(new SwipeStack.SwipeStackListener() {
            @Override
            public void onViewSwipedToLeft(int position) {

            }

            @Override
            public void onViewSwipedToRight(int position) {
                currentPosition = currentPosition + 1;
                Log.d("currentPosition", String.valueOf(currentPosition));
                commit_count.setText(String.valueOf(currentPosition));

                Log.d("test",Utils.loadProducts(MainActivity.this).get(position).getName());
                nameArraylist.add(Utils.loadProducts(MainActivity.this).get(position).getName());
                imageArraylist.add(Utils.loadProducts(MainActivity.this).get(position).getImageUrl());
                for (int i = 0; i<nameArraylist.size();i++)
                {
                    nameArraylist.get(i);
                }
                for (int i = 0; i<imageArraylist.size();i++)
                {
                    imageArraylist.get(i);
                }

                Log.d("TagArray", String.valueOf(nameArraylist));

            }

            @Override
            public void onStackEmpty() {

            }
        });

        Log.d("Total", String.valueOf(currentPosition));


    }



    private void addDetails() {


        cardsAdapter = new CardsAdapter(this, Utils.loadProducts(this.getApplicationContext()));
        cardStack.setAdapter(cardsAdapter);
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem item_notification = menu.findItem(R.id.cart);
        MenuItemCompat.setActionView(item_notification, (R.layout.action_bar_notifitcation_icon));
        View v = MenuItemCompat.getActionView(item_notification);


        commit_count = v.findViewById(R.id.notification_count);

        commit_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Productdetails.class);
                startActivity(intent);
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cart:

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            finishAffinity();
        }
        System.exit(0);

    }

}
