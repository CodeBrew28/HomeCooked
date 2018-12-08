// Cite: Bottom navigation and recycler view learned from here https://www.androidhive.info/2017/12/android-working-with-bottom-navigation/

package com.example.ariamalkani.homecooked;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link BrowseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrowseFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Meal> mealList;
    private MealAdapter mAdapter;

    public BrowseFragment() {
        // Required empty public constructor
    }

    public static BrowseFragment newInstance(String param1, String param2) {
        BrowseFragment fragment = new BrowseFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_browse, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        mealList = new ArrayList<>();
        addMeals();
        mAdapter = new MealAdapter(getActivity(), mealList);

        recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    private void addMeals() {
        Meal m1 = new Meal(1,"Shady Bob's BBQ", true, false,
                3.1, "Avg. $7", R.drawable.bbq, "201 N Goodwin Ave");
        Meal m2 = new Meal(2,"John's Vegan Heaven", true, true,
                2.2 , "Avg. $20", R.drawable.vegan_steak, "603 E Daniel");
        Meal m3 = new Meal(3,"Burger Prince", false, false,
                4.7, "Avg. $10", R.drawable.burger, "1401 W Green St");

        mealList.add(m1);
        mealList.add(m2);
        mealList.add(m3);
    }

    class MealAdapter extends RecyclerView.Adapter<MealAdapter.MyViewHolder> {
        private Context context;
        private List<Meal> mealList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView chefName, avgPrice, rating, vegan, verified;
            public ImageView thumbnail;
            public View heldView;
            public RatingBar starBar;

            public MyViewHolder(View view) {
                super(view);
                heldView = view;
                chefName = view.findViewById(R.id.chef_name);
                avgPrice = view.findViewById(R.id.avg_price);
                rating = view.findViewById(R.id.rating);
                vegan = view.findViewById(R.id.vegan);
                verified = view.findViewById(R.id.verified);
                thumbnail = view.findViewById(R.id.thumbnail);
                starBar = view.findViewById(R.id.meal_overall_rating);
            }
        }

        public MealAdapter(Context context, List<Meal> mealList) {
            this.context = context;
            this.mealList = mealList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.meal_card, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            final Meal meal = mealList.get(position);

            holder.heldView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v){
                    Intent intent = new Intent(v.getContext(), ScheduleActivity.class);
                    intent.putExtra("SERIALIZED_MEAL", meal);
                    startActivity(intent);
                }
            });

            holder.chefName.setText(meal.getChefName());
            if (meal.getVerified()) {
                holder.verified.setText("Verified");
            } else {
                holder.verified.setText("Unverified");
                holder.verified.setTextColor(Color.BLACK);
            }
            if (meal.getVegan()) {
                holder.vegan.setText("Vegan");
            }
            holder.avgPrice.setText(meal.getAvgPrice());
            holder.rating.setText(meal.getRating() + "/5");
            holder.thumbnail.setImageResource(meal.getThumbnail());
            holder.starBar.setRating(new Float(meal.getRating()));
        }

        @Override
        public int getItemCount() {
            return mealList.size();
        }
    }

}
