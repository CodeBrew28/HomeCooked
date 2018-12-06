package com.example.ariamalkani.homecooked;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static com.example.ariamalkani.homecooked.MainActivity.selfUserProfile;


public class HistoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<ReviewMeal> reviewMealList;
    private ReviewMealAdapter mAdapter;
    private TextView history_text;

    public HistoryFragment() {
        // Required empty public constructor
    }


    public static HistoryFragment newInstance() {
        HistoryFragment fragment = new HistoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        history_text = view.findViewById(R.id.meal_history_header);
        history_text.setText(selfUserProfile.getfName() + " " + selfUserProfile.getlName() + "'s Meal History");
        recyclerView = view.findViewById(R.id.history_recycler_view);
        reviewMealList = new ArrayList<>();
        addMeals();
        mAdapter = new ReviewMealAdapter(getActivity(), reviewMealList);

        recyclerView = view.findViewById(R.id.history_recycler_view);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    public void addMeals(){
        ReviewMeal m1 = new ReviewMeal(1, "Shady Bob's BBQ", true, false,
                3.1, "Avg. $7", R.drawable.bbq, "201 N Goodwin Ave", 5,5,5);
        ReviewMeal m2 = new ReviewMeal(2, "John's Vegan Heaven", true, true,
                4.7, "Avg. $20", R.drawable.vegan_steak, "603 E Daniel", 3 , 5, 4);
        ReviewMeal m3 = new ReviewMeal(3, "Burger Prince", false, false,
                4.7, "Avg. $10", R.drawable.burger, "1401 W Green St", 1, 2, 3);

        reviewMealList.add(m3);
        reviewMealList.add(m1);
        reviewMealList.add(m2);
    }
    class ReviewMealAdapter extends RecyclerView.Adapter<HistoryFragment.ReviewMealAdapter.MyViewHolder> {
        private Context context;
        private List<ReviewMeal> mealList;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView chefName, avgPrice, rating, vegan, verified, mealScore, politeScore, cleanScore;
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

                mealScore = view.findViewById(R.id.meal_score);
                politeScore = view.findViewById(R.id.polite_score);
                cleanScore = view.findViewById(R.id.clean_score);
                starBar = view.findViewById(R.id.review_overall_rating);
            }
        }

        public ReviewMealAdapter(Context context, List<ReviewMeal> mealList) {
            this.context = context;
            this.mealList = mealList;
        }

        @Override
        public HistoryFragment.ReviewMealAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.reviewmeal_card, parent, false);

            return new HistoryFragment.ReviewMealAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(HistoryFragment.ReviewMealAdapter.MyViewHolder holder, final int position) {
            final ReviewMeal meal = mealList.get(position);

            holder.heldView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v){
                    Intent intent = new Intent(v.getContext(), ReviewActivity.class);
                    //intent.putExtra("SERIALIZED_MEAL", meal);
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
            holder.rating.setText(meal.getRating()+"/5");
            holder.thumbnail.setImageResource(meal.getThumbnail());


            holder.mealScore.setText(Integer.toString(meal.getMealScore()));
            holder.politeScore.setText(Integer.toString(meal.getPoliteScore()));
            holder.cleanScore.setText(Integer.toString(meal.getCleanScore()));
            holder.starBar.setRating(new Float(meal.getRating()));
        }

        @Override
        public int getItemCount() {
            return mealList.size();
        }
    }
}
