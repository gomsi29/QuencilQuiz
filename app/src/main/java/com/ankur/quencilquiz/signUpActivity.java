package com.ankur.quencilquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signUpActivity extends AppCompatActivity {
EditText regUserName,regEmail,regPassword;
Button regButton;
String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
ProgressDialog progressDialog;
FirebaseAuth mAuth;
//    FirebaseDatabase firebaseDatabase;
//    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().hide();
        regUserName=findViewById(R.id.reg_username);
        regEmail=findViewById(R.id.reg_email);
        regPassword=findViewById(R.id.reg_password);
        regButton=findViewById(R.id.reg_submit);
       progressDialog=new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
//        firebaseDatabase=FirebaseDatabase.getInstance();
//        databaseReference=firebaseDatabase.getReference();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userRegister();
            }
        });






    }

    private void userRegister() {

        String userName = regUserName.getText().toString();
        String email = regEmail.getText().toString();
        String password = regPassword.getText().toString();

        if (!email.matches(regex))
        {
            regEmail.setError("Enter Correct Email");
        }
        if (password.isEmpty()|| password.length()<6)
        {
            regPassword.setError("Enter Correct Password");
        }

        else
        {
            progressDialog.setMessage("Registering Going On .....");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
//            registerModel registerModel=new registerModel();
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {

                        Toast.makeText(signUpActivity.this, "Register SuccessFully", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));





//                        registerModel.setUserName(userName);
//                        registerModel.setEmail(email);

//                        databaseReference.addValueEventListener(new ValueEventListener() {
//                            @Override
//                            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                databaseReference.child("Users").child(email).setValue(registerModel).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                    @Override
//                                           public void onComplete(@NonNull Task<Void> task) {
//
//                                    }
//                                });
//
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError error) {
//                                Toast.makeText(signUpActivity.this, "Registration Fail data Entry", Toast.LENGTH_SHORT).show();
//                                progressDialog.dismiss();
//                            }
//                        });



                    }
                    else {
                        Toast.makeText(signUpActivity.this, "Registration Fail", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
            });
        }




    }
}