package com.example.geedha.placement_with_android;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DashboardActivity extends AppCompatActivity {
    public static final String Nameofcomapany = "";
    public static final String DomainofCompany = "";

    Button Ugam,Heptagon,Scava,Starplus,Calibrant,Kgisl ;
   // SQLiteHelper sqLiteHelper;
    String name,domain,no_alumini,salary,no_of_rounds,eligibility;

    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Ugam = (Button)findViewById(R.id.button1);
        Heptagon = (Button)findViewById(R.id.button2);
        Scava= (Button)findViewById(R.id.button3);
        Starplus = (Button)findViewById(R.id.button4);
        Calibrant = (Button)findViewById(R.id.button5);
        Kgisl = (Button)findViewById(R.id.button6);
        //sqLiteHelper = new SQLiteHelper(this);


        //Adding click listener to log in button.
        Ugam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, ViewingActivity.class);

                startActivity(intent);

            }
        });
        Heptagon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent in = new Intent(DashboardActivity.this,HeptagonActivity.class);
               // startActivity(in);
            }
        });
        Scava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(DashboardActivity.this,ScavaActivity.class);
                //startActivity(i);
            }
        });
        Calibrant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent i = new Intent(DashboardActivity.this,Calibrant.class);
                //startActivity(i);
            }
        });

        Kgisl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(DashboardActivity.this,ScavaActivity.class);
                //startActivity(i);
            }
        });

    }
}