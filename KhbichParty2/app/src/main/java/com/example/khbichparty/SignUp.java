package com.example.khbichparty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.khbichparty.Model.user;
import com.firebase.ui.auth.data.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUp extends AppCompatActivity {
MaterialEditText Name,password,phone;
Button signUP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Name=(MaterialEditText) findViewById(R.id.NameUp);
        password=(MaterialEditText) findViewById(R.id.passwordUp);
        phone=(MaterialEditText) findViewById(R.id.phoneUp);
        signUP=(Button)findViewById(R.id.signUp);
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user=database.getReference("user");

        signUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog=new ProgressDialog(SignUp.this);
                mDialog.setMessage("Please wait ...");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(phone.getText().toString()).exists()){
                            mDialog.dismiss();
                            Toast.makeText(SignUp.this, "phone number already exists!!", Toast.LENGTH_SHORT).show();

                        }else {

                            mDialog.dismiss();
                            user user=new  user(Name.getText().toString(),password.getText().toString());
                            table_user.child(phone.getText().toString());
                            Toast.makeText(SignUp.this, "Success!!", Toast.LENGTH_SHORT).show();
                            Intent signUP=new Intent(SignUp.this,MainActivity.class);
                            startActivity(signUP);
                            finish();
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
