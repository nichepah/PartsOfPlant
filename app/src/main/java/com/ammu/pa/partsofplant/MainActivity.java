package com.ammu.pa.partsofplant;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // called on clicking Play Button
    public void onPlay(View view){
        Intent intent = new Intent(this, FlowerActivity.class);
        startActivity(intent);

    }
}
