package com.example.khbichparty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class findMate extends AppCompatActivity {
    Button pop;
    Dialog dialog;
    String text ="";
    ArrayList<Mate> mates;
    MateAdapter adapter;
    ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_mate);
        ListView mListView = (ListView) findViewById(R.id.List);
        mates=new ArrayList<Mate>();
        mates.add(new Mate("HABIB Lila", "Hello in my twitter"));
        adapter = new MateAdapter(findMate.this, mates);
        mListView.setAdapter(adapter);

        pop=(Button)findViewById(R.id.pop);
pop.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        dialog = new Dialog(findMate.this);
        dialog.setContentView(R.layout.dialogue);
        dialog.setTitle("Création");
        dialog.show();


        Button btnValider = (Button) dialog.findViewById(R.id.dialog_btn_valider);
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {

                EditText content=(EditText) dialog.findViewById(R.id.dialog_libelle);
                EditText name=(EditText) dialog.findViewById(R.id.dialog_name);

                ListView mListView = (ListView) findViewById(R.id.List);
                Toast.makeText(findMate.this, content.getText().toString(), Toast.LENGTH_SHORT).show();
                mates.add(new Mate(name.getText().toString(),content.getText().toString()));
                adapter = new MateAdapter(findMate.this, mates);
                mListView.setAdapter(adapter);
                dialog.dismiss();


            }
        });

    }
});




    }

}
