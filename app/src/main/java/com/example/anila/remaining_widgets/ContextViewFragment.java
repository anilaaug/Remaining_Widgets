package com.example.anila.remaining_widgets;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ContextViewFragment extends Fragment {


    ListView mListView;
    String[] mcontacts = {"Varun", "Akhil", "Rahul", "Vineetha", "Alin", "isabel", "Hosana", "Ardra"};
    List mContactsList = Arrays.asList(mcontacts);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_context_view, container, false);
        mListView = view.findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mContactsList);
        mListView.setAdapter(adapter);
        registerForContextMenu(mListView);
        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select an action");
        menu.add(0, v.getId(), 0, "Call");
        menu.add(0, v.getId(), 0, "SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Call") {
            Toast.makeText(getContext(), "calling code", Toast.LENGTH_LONG).show();
        }
        if (item.getTitle() == "SMS") {
            Toast.makeText(getContext(), "SMS CODE", Toast.LENGTH_LONG).show();
        } else
            return false;
        return true;
    }
}
