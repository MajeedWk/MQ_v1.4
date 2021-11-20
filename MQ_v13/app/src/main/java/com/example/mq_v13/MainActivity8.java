package com.example.mq_v13;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity8 extends AppCompatActivity {
    private Button btnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        btnMove = findViewById(R.id.ReportButton2);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity8.this, "Your report has been submitted", Toast.LENGTH_SHORT).show();
            }
        });
        btnMove = findViewById(R.id.ReportToMenuButton);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToActivity3();
            }
        });
    }

    private void moveToActivity3() {
        Intent intent = new Intent(MainActivity8.this, MainActivity3.class);
        startActivity(intent);
    }
}