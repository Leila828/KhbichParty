package com.example.khbichparty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Module1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1);
        Button b1=(Button)findViewById(R.id.button5);
        Intent goChapter=new Intent(Module1.this,Chapitre.class);
        startActivity(goChapter);
    }
}
