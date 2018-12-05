package com.example.ariamalkani.homecooked;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import static com.example.ariamalkani.homecooked.MainActivity.selfUserProfile;


public class ProfileFragment extends Fragment {
    private Switch vegan;
    private Switch public_profile;
    private ImageView profile_pic;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profile_pic = view.findViewById(R.id.profile_pic);
        profile_pic.setImageResource(selfUserProfile.getThumbnail());

        TextView name = view.findViewById(R.id.user_name);
        name.setText(selfUserProfile.getfName() + " " + selfUserProfile.getlName());

        TextView address = view.findViewById(R.id.address);
        address.setText(selfUserProfile.getAddress());

        TextView city = view.findViewById(R.id.city);
        city.setText(selfUserProfile.getCity());

        TextView state = view.findViewById(R.id.state);
        state.setText(selfUserProfile.getState().toString());

        TextView phone = view.findViewById(R.id.phone);
        phone.setText(selfUserProfile.getPhone());

        TextView email = view.findViewById(R.id.email);
        email.setText(selfUserProfile.getEmail());

        vegan = view.findViewById(R.id.vegan);
        if(selfUserProfile.isVegan() == true){
            vegan.setChecked(true);
        } else {
            vegan.setChecked(false);
        }


        vegan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                selfUserProfile.setVegan(isChecked);

            }
        });
        public_profile = view.findViewById(R.id.public_profile);
        if(selfUserProfile.isPublic() == true){
            public_profile.setChecked(true);
        } else {
            public_profile.setChecked(false);
        }

        public_profile.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
                selfUserProfile.setPublic(isChecked);
            }
        });

        final Button veri = view.findViewById(R.id.verificationButton);
        checkVeriButtonStatus(veri);

        veri.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(final View v) {
                if (selfUserProfile.isVerified() == false) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    selfUserProfile.setVerified(true);
                    builder.setMessage("Congrats, you're now verified");
                    checkVeriButtonStatus(veri);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    selfUserProfile.setVerified(true);
                    builder.setMessage("You're already verified!");
                    checkVeriButtonStatus(veri);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }
            }
        });

        return view;
    }

    private void checkVeriButtonStatus(Button veri){
        TypedValue coloredTV = new TypedValue();
        Context context = getContext();
        if(selfUserProfile.isVerified() == true){
            context.getTheme().resolveAttribute(R.attr.colorPrimary, coloredTV, true);
            veri.setBackgroundColor(coloredTV.data);
            veri.setText("Verified!");
        } else {
            context.getTheme().resolveAttribute(R.attr.colorSecondary, coloredTV, true);
            veri.setBackgroundColor(coloredTV.data);
            veri.setText("Get Verified!");
        }
    }
}
