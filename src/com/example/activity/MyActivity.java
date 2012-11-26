package com.example.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.example.R;
import com.example.fragments.MyListFragment;

public class MyActivity extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.list_frag, new MyListFragment()).commit();
        }
    }
}
