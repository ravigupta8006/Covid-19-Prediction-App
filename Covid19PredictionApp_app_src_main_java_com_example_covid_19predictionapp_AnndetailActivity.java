package com.example.covid_19predictionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class AnndetailActivity extends AppCompatActivity {
    private TextView suff,sta;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anndetail);
        suff=findViewById(R.id.ravi);
        sta=findViewById(R.id.state);
        imageView=findViewById(R.id.image);


        final String State = getIntent().getExtras().getString("value2");
        final String Model = getIntent().getExtras().getString("value3");


        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Data");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot dataSnapshot1:snapshot.getChildren())
                {
                    String date = String.valueOf(dataSnapshot1.child("Date").getValue());
                    String model = String.valueOf(dataSnapshot1.child("model").getValue());
                    String state = String.valueOf(dataSnapshot1.child("state").getValue());


                    Log.i("Our Value", date);
                    // die.setText(value);
                    if(model.equals(Model)) {
                        if (state.equals(State)) {
                           // String link = dataSnapshot1.getValue(String.class);
                            String image = String.valueOf(dataSnapshot1.child("image").getValue());
                            Picasso.get().load(image).into(imageView);
                            //Picasso.get().load(link).into(imageView);
                            String algm = String.valueOf(dataSnapshot1.child("Algm").getValue());
                            suff.setText(algm);
                            String States = String.valueOf(dataSnapshot1.child("state").getValue());
                            sta.setText(States);

                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
