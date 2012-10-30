package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MyActivity extends Activity{
    /**
     * Called when the activity is first created.
     */
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Intent intent = new Intent(this,MySecondActivity.class);
        final Button button = (Button) findViewById(R.id.f_btn);
        button.setOnClickListener(new OnClickListener(){
            public void onClick(View view){

                startActivity(intent);

            }
        });
    }
}
