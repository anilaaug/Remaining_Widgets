package com.example.anila.remaining_widgets;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleFragment extends Fragment {
    private ToggleButton mtoggleButton;
    public ToggleFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_toggle,container,false);
        mtoggleButton= view.findViewById(R.id.toggleButton);
        mtoggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {


                 Toast.makeText(getContext(), "ToggleButton is  "+mtoggleButton.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }




}
