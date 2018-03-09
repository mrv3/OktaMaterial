package com.vic3e.app.oktamaterial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RandomFragment2 extends Fragment {

    private static final String KEY_TITLE = "title";

    public RandomFragment2() {
        // Required empty public constructor
    }

    public static RandomFragment2 newInstance(String title) {
        RandomFragment2 f = new RandomFragment2();

        Bundle args = new Bundle();

        args.putString(KEY_TITLE, title);
        f.setArguments(args);

        return (f);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // don't look at this layout it's just a listView to show how to handle the keyboard
        View view = inflater.inflate(R.layout.fragment_random_two, container, false);

     //   TextView textView = (TextView) view.findViewById(R.id.title);
   //     textView.setText(getArguments().getString(KEY_TITLE));

        return view;
    }

}
