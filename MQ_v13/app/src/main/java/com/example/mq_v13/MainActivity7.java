package com.example.mq_v13;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.*;

public class MainActivity7 extends AppCompatActivity {
    private Button btnMove;
    Button cButton;
    FirebaseDatabase rootNode;
    DatabaseReference reference, reference2;
    FirebaseAuth auth;
    String time, parking;
    TextView viewBooking, viewBooking2;
    String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        btnMove = findViewById(R.id.ReturnToMenuButton1);
        cButton = findViewById(R.id.CancelBookingBt);

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Reservation").child(currentuser);
        //reference2 = rootNode.getReference("Reservation").child(currentuser).child("parking");


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
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.removeValue();
                //reference2.removeValue();
                Toast.makeText(MainActivity7.this, "Booking has been Canceled", Toast.LENGTH_SHORT).show();


            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToActivity3();
            }
        });
    }

    private void moveToActivity3() {
        Intent intent = new Intent(MainActivity7.this, MainActivity3.class);
        startActivity(intent);
    }
}