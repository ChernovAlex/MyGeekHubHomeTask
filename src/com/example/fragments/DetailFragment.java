package com.example.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.R;

public class DetailFragment extends Fragment {

    public static final String TEXT_MESS = "";

    private static final int NUMBER = 0;

    private View view;
    private String text;

    public static DetailFragment newInstance(String text) {
        DetailFragment f = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(TEXT_MESS, text);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            text = args.getString(TEXT_MESS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.detail_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            text = savedInstanceState.getString("text");
        }

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView tv = (TextView) view.findViewById(R.id.text);
                tv.setText(text);
            }
        });

        Button replace = (Button) view.findViewById(R.id.details_btn);
        replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RandomNumberFragment numberFragment = RandomNumberFragment.newInstance(text);
                numberFragment.setTargetFragment(DetailFragment.this, NUMBER);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.container, numberFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", text);
    }
}
