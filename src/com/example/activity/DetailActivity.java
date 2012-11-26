package com.example.activity;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.example.R;
import com.example.fragments.DetailFragment;
import com.example.fragments.RandomNumberFragment;

public class DetailActivity extends FragmentActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        if (savedInstanceState == null) {
            handleIntentExtras(getIntent());
        }
    }

    private void handleIntentExtras(Intent intent) {
        String text = "";
        if (intent.hasExtra(DetailFragment.TEXT_MESS)) {
            text = intent.getStringExtra(DetailFragment.TEXT_MESS);
        }

        DetailFragment detailsFragment = DetailFragment.newInstance(text);
        getSupportFragmentManager().beginTransaction().add(R.id.container, detailsFragment).commit();
    }


}
