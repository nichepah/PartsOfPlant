package com.ammu.pa.partsofplant;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FlowerActivity extends Activity {

    private Queue<String> textQueue = new LinkedList<String>();
    private String activityText = new String("FLOWER");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.flower);
    }

    public void onClick(View view){
        Button button = (Button) view;
        String text = button.getText().toString();
        textQueue.add(text);

        TextView textView = findViewById(R.id.textView);
        String textHeader = TextUtils.join("", textQueue);
        //Log.d("Queue: ", String.valueOf(textQueue));
        textView.setText(textHeader);
        if(textHeader.equals(activityText)) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("Congratulations dear AMMU...\n Do you want to try a new word?");
            alertDialogBuilder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(), FruitActivity.class);
                            startActivity(intent);
                        }
                    });

            alertDialogBuilder.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }

    }

    // On clicking Next
    public void onNext(View view){
        Intent intent = new Intent(this, RootActivity.class);
        startActivity(intent);
    }

}
