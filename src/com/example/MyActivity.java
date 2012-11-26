package com.example;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.example.fragments.TitlesFragment;

import java.util.ArrayList;

public class MyActivity extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.container, new TitlesFragment()).commit();
        }

    }
}
