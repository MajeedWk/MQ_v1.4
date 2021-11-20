package com.example.mq_v13;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.*;

import java.util.Objects;

public class MainActivity5 extends AppCompatActivity {
    private Button btnMove;
    Button b;
    RadioGroup radioGroup;
    RadioButton selectedRadioButton;
    FirebaseDatabase rootnode, rootnode2;
    DatabaseReference reference, reference2;
    ReservationClass reservationClass;
    String str, TimeGroup;
    FirebaseAuth auth;
    String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();
    String allUsers = (String) FirebaseAuth.getInstance().getUid();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        btnMove = findViewById(R.id.ConfirmBooking);
        radioGroup = (RadioGroup) findViewById(R.id.ParkingSpace);

        TimeGroup = getIntent().getExtras().getString("Selected Time : ");


        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                selectedRadioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String parkingSpace = selectedRadioButton.getText().toString();
                final String time3 = TimeGroup;
                final String parking = parkingSpace;
                String id = FirebaseAuth.getInstance().getCurrentUser().getUid();

                reference2 = FirebaseDatabase.getInstance().getReference("Reservation").child(id);
                reference2.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (!snapshot.exists()) {
                            rootnode = FirebaseDatabase.getInstance();
                            reference = rootnode.getReference("Reservation");
                            ReservationClass reservationClass = new ReservationClass(time3, parking);
                            reference.child(currentuser).setValue(reservationClass);
                            Toast.makeText(MainActivity5.this, "Booking successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


                Query query = FirebaseDatabase.getInstance().getReference("Reservation");
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        selectedRadioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                        String parkingSpace = selectedRadioButton.getText().toString();
                        String time1 = TimeGroup;
                        String parking = parkingSpace;
                        String id = FirebaseAuth.getInstance().getCurrentUser().getUid();


                        for (DataSnapshot snapShot : snapshot.getChildren()) {

                            String type = snapshot.child("TDBZ1If1bkfZ8SrdBrKrOlhp7Bs1").child("time").getValue().toString();
                            String type2 = snapshot.child("TDBZ1If1bkfZ8SrdBrKrOlhp7Bs1").child("parking").getValue().toString();
                            String type3 = snapshot.child("Q1zT9iCwe5b7tw8RTN0XMEOW0Hl1").child("time").getValue().toString();
                            String type4 = snapshot.child("Q1zT9iCwe5b7tw8RTN0XMEOW0Hl1").child("parking").getValue().toString();
                            String type5 = snapshot.child("3ReGFkVGFISMLBBjYQl09pzF4Cm2").child("time").getValue().toString();
                            String type6 = snapshot.child("3ReGFkVGFISMLBBjYQl09pzF4Cm2").child("parking").getValue().toString();
                            String type7 = snapshot.child("IPVFtETkvrbwxQVJKMT0AkB4PPG2").child("time").getValue().toString();
                            String type8 = snapshot.child("IPVFtETkvrbwxQVJKMT0AkB4PPG2").child("parking").getValue().toString();

                            if (type.equals(time1) && type2.equals(parking)) {
                                Toast.makeText(MainActivity5.this, "Not Available1", Toast.LENGTH_SHORT).show();

                            } else if (type3.equals(time1) && type4.equals(parking)) {
                                Toast.makeText(MainActivity5.this, "Not Available2", Toast.LENGTH_SHORT).show();

                            } else if (type5.equals(time1) && type6.equals(parking)) {
                                Toast.makeText(MainActivity5.this, "Not Available3", Toast.LENGTH_SHORT).show();

                            } else if (type7.equals(time1) && type8.equals(parking)) {
                                Toast.makeText(MainActivity5.this, "Not Available4", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(MainActivity5.this, "Available, Booking confirmed", Toast.LENGTH_SHORT).show();
                                //Toast.makeText(MainActivity5.this, "Booking confirmed", Toast.LENGTH_SHORT).show();
                                rootnode = FirebaseDatabase.getInstance();
                                reference = rootnode.getReference("Reservation");
                                ReservationClass reservationClass = new ReservationClass(time1, parking);
                                reference.child(id).setValue(reservationClass);
                                Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
                                startActivity(intent);


                            }
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });


        //toast


    }


}