package com.vic3e.app.oktamaterial;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class RandomFragment extends Fragment {

    private static final String KEY_TITLE = "title";

    public RandomFragment() {
        // Required empty public constructor
    }

    public static RandomFragment newInstance(String title) {
        RandomFragment f = new RandomFragment();

        Bundle args = new Bundle();

        args.putString(KEY_TITLE, title);
        f.setArguments(args);

        return (f);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // don't look at this layout it's just a listView to show how to handle the keyboard
        View view = inflater.inflate(R.layout.fragment_random, container, false);

     //   TextView textView = (TextView) view.findViewById(R.id.title);
   //     textView.setText(getArguments().getString(KEY_TITLE));

        return view;
    }

}
