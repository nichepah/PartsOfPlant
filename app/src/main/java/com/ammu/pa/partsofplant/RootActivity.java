package com.ammu.pa.partsofplant;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;

public class RootActivity extends AppCompatActivity {

    private Queue<String> textQueue = new LinkedList<String>();
    private String activityText = new String("ROOT");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);
        // set root image
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.roots);

    }

    public void onClick(View view){
        Button button = (Button) view;
        String text = button.getText().toString();
        textQueue.add(text);

        TextView textView = findViewById(R.id.textView);
        String textHeader = TextUtils.join("",textQueue);
        textView.setText(textHeader);

        if(textHeader.equals(activityText)) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("CoNgRaTuLaTiOnS dear A-M-M-U...\n Do you want to try another word?");
            alertDialogBuilder.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //Toast.makeText(RootActivity.this, "Start Another activity", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), LeafActivity.class);
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
        Intent intent = new Intent(this, LeafActivity.class);
        startActivity(intent);
    }

}

