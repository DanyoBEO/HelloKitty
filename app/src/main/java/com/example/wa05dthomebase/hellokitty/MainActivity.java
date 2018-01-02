package com.example.wa05dthomebase.hellokitty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addTicket = (Button) findViewById(R.id.add_button);
        addTicket.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, TicketMaker.class));
            }
        });

        Button sendEmail = (Button) findViewById(R.id.email_send);
        sendEmail.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //create email sending class
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_item, menu);

    }
}
