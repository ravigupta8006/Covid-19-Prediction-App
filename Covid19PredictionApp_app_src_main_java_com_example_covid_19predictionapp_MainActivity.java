package com.example.covid_19predictionapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.multidex.MultiDex;

import android.content.Intent;
import android.net.http.HttpResponseCache;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
     private  EditText days,months,years;
     private Button submit,enter;
     private TextView day_text,month_text,year_text,recover_text,die_text,text,suffers;
   //  ListView myListView;
   //  ArrayList<String> myArrayList = new ArrayList<>();

    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  MultiDex.install(this);
        setContentView(R.layout.activity_main);


        days = findViewById(R.id.date);
        months = findViewById(R.id.month);
        years = findViewById(R.id.year);
        submit = findViewById(R.id.Click);


        year_text = findViewById(R.id.year_text);
        month_text = findViewById(R.id.month_text);
        day_text = findViewById(R.id.date_text);
        text = findViewById(R.id.Text);
        enter=findViewById(R.id.enter);

        suffers = findViewById(R.id.suff);
        recover_text = findViewById(R.id.recover_text);
        die_text = findViewById(R.id.die_text);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,AnnActivity.class);
                startActivity(i);


            }
        });



        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // ravi();
                Intent i = new Intent(MainActivity.this,DetailActivity.class);
        String st = months.getText().toString();
        String st1 = days.getText().toString();

        i.putExtra("value",st);
        i.putExtra("value1",st1);
        startActivity(i);
       // finish();
            }
        });



    }

}

