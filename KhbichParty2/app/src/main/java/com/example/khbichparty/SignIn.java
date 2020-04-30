package com.example.khbichparty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.khbichparty.Model.user;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {
EditText phone,name,password;
Button signIn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        phone=(MaterialEditText)findViewById(R.id.phone);
        name=(MaterialEditText)findViewById(R.id.name);
        password=(MaterialEditText)findViewById(R.id.password);
        signIn2=(Button)findViewById(R.id.signIn2);

        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user=database.getReference("user");
        signIn2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog=new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please wait ...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                      if (dataSnapshot.child(phone.getText().toString()).exists()){


                       mDialog.dismiss();
                        user user=dataSnapshot.child(phone.getText().toString()).getValue(user.class);
                                if (user.getPasswoed().equals(password.getText().toString())){
                                    Toast.makeText(SignIn.this, "succes!!", Toast.LENGTH_SHORT).show();
                                    Intent signIn=new Intent(SignIn.this,MainActivity.class);
                                    startActivity(signIn);
                                }else {

                                    Toast.makeText(SignIn.this, "wrong password !!", Toast.LENGTH_SHORT).show();
                                }}else {
                          Toast.makeText(SignIn.this, "", Toast.LENGTH_SHORT).show();
                      }

                              }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}
