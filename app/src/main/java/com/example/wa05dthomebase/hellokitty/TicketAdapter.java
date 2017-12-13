package com.example.wa05dthomebase.hellokitty;

import android.app.Activity;
import android.widget.ArrayAdapter;

import com.example.wa05dthomebase.hellokitty.Ticket;

import java.util.ArrayList;

/**
 * Created by WA05DTHOMEBASE on 12/12/2017.
 */

public class TicketAdapter extends ArrayAdapter<Ticket> {

    public TicketAdapter(Activity context, ArrayList<Ticket> tickets){
        super(context, 0, tickets);
    }

    TicketDbHandler db = new TicketDbHandler(getContext());

}
