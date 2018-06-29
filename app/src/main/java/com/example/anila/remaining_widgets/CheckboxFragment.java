package com.example.anila.remaining_widgets;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

public class CheckboxFragment extends Fragment {

    private CheckBox mCheckBox;
    private RatingBar mRatingBar;
    private Button mButton;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_checkbox, container, false);
        mCheckBox = view.findViewById(R.id.checkBox);
        mButton=view.findViewById(R.id.rating_button);
        mRatingBar=view.findViewById(R.id.ratingBar);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer rating=Integer.valueOf((int) mRatingBar.getRating());
                if(rating==1)
                {
                    Toast.makeText(getContext(), "Hated it", Toast.LENGTH_SHORT).show();
                }
                else if(rating==2)
                {
                    Toast.makeText(getContext(), "Disliked it", Toast.LENGTH_SHORT).show();
                }
                else if(rating==3){Toast.makeText(getContext(), "It's OK", Toast.LENGTH_SHORT).show();}
                else if(rating==4){Toast.makeText(getContext(), "Liked it", Toast.LENGTH_SHORT).show();}

            }
        });
        mCheckBox.setOnClickListener(new View.OnClickListener() {
            AlertDialog.Builder alerDialogBuilder = new AlertDialog.Builder(getContext());

            @Override
            public void onClick(View view) {
                if (mCheckBox.isChecked()) {

                    alerDialogBuilder.setMessage("Allow data roaming? You may incur significant roaming charges!");
                    alerDialogBuilder.setIcon(R.drawable.ic_warning_icon);
                    alerDialogBuilder.setTitle("Warning!");
                    alerDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(getContext(), "Data roaming is enabled", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alerDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            mCheckBox.setChecked(false);
                        }
                    });

                    alerDialogBuilder.create();
                    alerDialogBuilder.show();
                }
            }

        });
        return view;
    }
}