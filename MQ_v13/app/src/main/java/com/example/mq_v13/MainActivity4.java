package com.example.mq_v13;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.firebase.database.*;

public class MainActivity4 extends AppCompatActivity {
    private Button btnMove;
    RadioGroup radioGroup;
    RadioButton selectedRadioButton;
    TimeCheck timeCheck;
    FirebaseDatabase rootnode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        radioGroup = (RadioGroup) findViewById(R.id.TimeGroup);

        btnMove = findViewById(R.id.SearchButton);
        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToActivity5();
                selectedRadioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
                String TimeGroup = selectedRadioButton.getText().toString();
                Intent i = new Intent(MainActivity4.this, MainActivity5.class);
                i.putExtra("Selected Time : ", TimeGroup);
                startActivity(i);

            }
        });
    }

    private void moveToActivity5() {
        Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
        startActivity(intent);
    }
}