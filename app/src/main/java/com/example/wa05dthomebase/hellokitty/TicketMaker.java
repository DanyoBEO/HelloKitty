package com.example.wa05dthomebase.hellokitty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TicketMaker extends AppCompatActivity {
    EditText mEID;
    EditText mShort;
    EditText mLong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_maker);

        Button cancelButton = (Button) findViewById(R.id.ticket_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent( TicketMaker.this, MainActivity.class));
            }
        });

        Button saveButton = (Button) findViewById(R.id.save_ticket);
        cancelButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mEID = (EditText) findViewById(R.id.user_eid);
                mShort = (EditText) findViewById(R.id.description_short);
                mLong = (EditText) findViewById(R.id.description_full);

            }
        });
    }

}
