package com.example.covid_19predictionapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Snapshot;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

public class DetailActivity extends AppCompatActivity {



    ArrayList<String> list = new ArrayList<>();
    TextView suff,recov,die,active1,conf,act,recover,parpat;
    DatabaseReference reff;
   // String Dates="3-May-2020";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        suff=findViewById(R.id.suff);
        die=findViewById(R.id.die_text);
        recov=findViewById(R.id.recover_text);
        active1=findViewById(R.id.active_text);
        conf=findViewById(R.id.confirm);
        act=findViewById(R.id.act);
        recover=findViewById(R.id.recover);
        parpat=findViewById(R.id.die);


        final String Date = getIntent().getExtras().getString("value");
        final String state = getIntent().getExtras().getString("value1");



        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Data");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


              for(DataSnapshot dataSnapshot1:snapshot.getChildren())
                {
                    String date = String.valueOf(dataSnapshot1.child("Date").getValue());
                   // String State = String.valueOf(dataSnapshot1.child("state").getValue());


                   // String value = String.valueOf(snapshot.getValue());
                    /*  String newString = new String();

                    for (int i = 0; i < 9; i++) {

                        // Insert the original string character
                        // into the new string
                        newString += value.charAt(i);
                    }*/
                  //  Log.i("Our value",newString);
                    Log.i("Our Value", date);
                   // die.setText(value);
                    if(date.equals(Date))
                     {
                         String suffer = String.valueOf(dataSnapshot1.child("people_suffer").getValue());
                         String recovery = String.valueOf(dataSnapshot1.child("people_recover").getValue());
                         String dies = String.valueOf(dataSnapshot1.child("people_death").getValue());
                         String active = String.valueOf(dataSnapshot1.child("people_active").getValue());

                         Log.i("Our Value", suffer);
                         Log.i("Our Value", recovery);
                         Log.i("Our Value", dies);

                        die.setText(dies);
                        recov.setText(recovery);
                        suff.setText(suffer);
                        active1.setText(active);

                         conf.setText(suffer);
                         recover.setText(recovery);
                         parpat.setText(dies);
                         act.setText(active);


                     }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

       /* list = new ArrayList<String>();
        final String Date = getIntent().getExtras().getString("value");

        reff = FirebaseDatabase.getInstance().getReference("Data");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren() )
                {
                    String passc= (String) dataSnapshot1.child("Data").getValue();

                    if(Date.equals(passc))
                    {
                        String suffer = dataSnapshot1.child("people_suffer").getValue().toString();
                        String recovery = dataSnapshot1.child("people_recover").getValue().toString();
                        String dies = dataSnapshot1.child("people_death").getValue().toString();

                        suff.setText(suffer);
                        recov.setText(recovery);
                        die.setText(passc);

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
*/

    }
}
