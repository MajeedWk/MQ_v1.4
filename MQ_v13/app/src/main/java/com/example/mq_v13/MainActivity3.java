package com.example.mq_v13;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity3 extends AppCompatActivity {
    private Button btnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btnMove = findViewById(R.id.NewBookingButton);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToActivity4();
            }
        });

        btnMove = findViewById(R.id.CancelBookingButton);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToActivity7();
            }
        });

        btnMove = findViewById(R.id.ViewBookingButton);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToActivity6();
            }
        });

        btnMove = findViewById(R.id.ReportButton1);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToActivity8();
            }
        });

        btnMove = findViewById(R.id.LogoutButton);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    private void moveToActivity4() {
        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
        startActivity(intent);
    }

    private void moveToActivity7() {
        Intent intent = new Intent(MainActivity3.this, MainActivity7.class);
        startActivity(intent);
    }

    private void moveToActivity6() {
        Intent intent = new Intent(MainActivity3.this, MainActivity6.class);
        startActivity(intent);
    }

    private void moveToActivity8() {
        Intent intent = new Intent(MainActivity3.this, MainActivity8.class);
        startActivity(intent);
    }

}