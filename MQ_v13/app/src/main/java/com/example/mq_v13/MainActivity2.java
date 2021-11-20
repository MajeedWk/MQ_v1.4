package com.example.mq_v13;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button btnMove;
    Button signUpButton;
    EditText signUpID, signUpEmail, signUpPassword, signUpCarPlate;
    private FirebaseAuth fAuth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        signUpID = findViewById(R.id.ID_2);
        signUpEmail = findViewById(R.id.UserEmail);
        signUpPassword = findViewById(R.id.UserPassword);
        signUpCarPlate = findViewById(R.id.CarPlate);
        signUpButton = (Button) findViewById(R.id.SignUpButton2);
        signUpButton.setOnClickListener(this);
        btnMove = (Button) findViewById(R.id.FromSignUpToLogin);
        btnMove.setOnClickListener(this);
        fAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.FromSignUpToLogin:
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.SignUpButton2:

                signUpButton();


        }
    }


    private void signUpButton() {
        final String id = signUpID.getText().toString().trim();
        final String email = signUpEmail.getText().toString().trim();
        final String password = signUpPassword.getText().toString().trim();
        final String carPlate = signUpCarPlate.getText().toString().trim();

        if (id.isEmpty()) {
            signUpID.setError("ID is required");
            return;
        }
        if (email.isEmpty()) {
            signUpEmail.setError("Email is required");
            return;
        }
        if (password.isEmpty()) {
            signUpPassword.setError("Password is required");
            return;
        }
        if (carPlate.isEmpty()) {
            signUpCarPlate.setError("Car Plate is required");
            return;
        }
        Toast.makeText(MainActivity2.this, "Data Validated", Toast.LENGTH_SHORT).show();

        fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    UserHelperClass userHelperClass = new UserHelperClass(id, password, email, carPlate);

                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(userHelperClass).addOnCompleteListener(new OnCompleteListener<Void>() {

                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity2.this, "User has been registered", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                                signUpButton();
                                startActivity(i);
                            }

                        }

                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

        });


    }


}