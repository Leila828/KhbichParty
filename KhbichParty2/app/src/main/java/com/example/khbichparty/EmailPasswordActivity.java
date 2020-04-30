package com.example.khbichparty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmailPasswordActivity extends AppCompatActivity {
Button signIn,signUP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_password);
signIn =(Button)findViewById(R.id.signIn);
signUP =(Button)findViewById(R.id.signUP);
signIn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent signin=new Intent(EmailPasswordActivity.this,SignIn.class);
        startActivity(signin);
    }
});
signUP.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent signUP=new Intent(EmailPasswordActivity.this,SignUp.class);
        startActivity(signUP);
    }
});
    }
}
