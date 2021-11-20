package com.example.mq_v13;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;

public class MainActivity6 extends AppCompatActivity {
    private Button btnMove;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    FirebaseAuth auth;
    String time, parking;
    TextView viewBooking, viewBooking2;
    String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        btnMove = findViewById(R.id.ReturnToMenuButton2);
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Reservation").child(currentuser);
        /*Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String parkingSpace = extras.getString("Selected Parking space is: ");
            //The key argument here must match that used in the other activity*/
        viewBooking = (TextView) findViewById(R.id.MyBooking1);
        viewBooking2 = (TextView) findViewById(R.id.viewBookingtext2);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String viewB = snapshot.child("time").getValue(String.class);
                String viewB2 = snapshot.child("parking").getValue(String.class);
                viewBooking.setText(viewB);
                viewBooking2.setText(viewB2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //}
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToActivity3();
            }
        });


    }

    private void moveToActivity3() {
        Intent intent = new Intent(MainActivity6.this, MainActivity3.class);
        startActivity(intent);
    }


}