package com.example.brian.fyp115494258;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.brian.fyp115494258.Model.Restaurant;
import com.example.brian.fyp115494258.ViewHolder.MenuViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class RestaurantDetail extends AppCompatActivity {

    TextView restaurant_name, restaurant_location, restaurant_description;
    ImageView restaurant_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    //FloatingActionButton btnCart;
    ElegantNumberButton numberButton;
    FirebaseDatabase database;
    DatabaseReference restaurant;
    Restaurant currentRestaurant;

    String RestaurantId = "";
    FirebaseRecyclerAdapter<Restaurant, MenuViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);


        //Firebase
        database = FirebaseDatabase.getInstance();
        restaurant = database.getReference("Restaurant");

        //Init View
        numberButton = (ElegantNumberButton) findViewById(R.id.number_button);
        //btnCart = (FloatingActionButton) findViewById(R.id.btnCart);

        /*

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Database(getBaseContext()).addToCart(new Order(
                        foodId,
                        currentFood.getName(),
                        numberButton.getNumber(),
                        currentFood.getPrice(),
                        currentFood.getDiscount()
                ));


            }
        });

        */

        restaurant_description = (TextView) findViewById(R.id.restaurant_description);
        restaurant_name = (TextView) findViewById(R.id.restaurant_name);
        restaurant_location = (TextView) findViewById(R.id.restaurant_location);
        restaurant_image = (ImageView) findViewById(R.id.img_restaurant);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);

        //Get food ID from Intent
        if(getIntent() != null)
            RestaurantId = getIntent().getStringExtra("RestaurantId");
        if(!RestaurantId.isEmpty()){
            getDetailFood(RestaurantId);
        }

    }

    private void getDetailFood(String foodId) {
        restaurant.child(foodId).addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                currentRestaurant = dataSnapshot.getValue(Restaurant.class);

                //Set Image
                Picasso.with(getBaseContext()).load(currentRestaurant.getImage()).into(restaurant_image);

                collapsingToolbarLayout.setTitle(currentRestaurant.getName());

                restaurant_location.setText(currentRestaurant.getLocation());

                restaurant_name.setText(currentRestaurant.getName());

                restaurant_description.setText(currentRestaurant.getDescription());

            }

            @Override
            public void onCancelled(DatabaseError databaseError){

            }
        });

    }
}
