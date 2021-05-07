package com.example.covid_19predictionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AnnActivity extends AppCompatActivity {
    private Button submit;
    private EditText state,model;

    DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ann);

        submit = findViewById(R.id.submit);
        state = findViewById(R.id.state);
        model = findViewById(R.id.model);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(AnnActivity.this,AnndetailActivity.class);
                String st = state.getText().toString();
                String st1 = model.getText().toString();

                i.putExtra("value2",st);
                i.putExtra("value3",st1);
                startActivity(i);








            }
        });
    }
}
