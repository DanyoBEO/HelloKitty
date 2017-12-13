package com.example.wa05dthomebase.hellokitty;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.wa05dthomebase.hellokitty.TicketContract.DATABASE_NAME;

/**
 * Created by WA05DTHOMEBASE on 12/12/2017.
 */

public class TicketDbHandler extends SQLiteOpenHelper{
    private Context mContext;


    public TicketDbHandler(Context context){
        super(context, DATABASE_NAME, null, TicketContract.DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String TEXT_TYPE = " TEXT";
        final String COMMA_SEP = ",";
        final String INTEGER_TYPE = " INTEGER";
        final String FLOAT_TYPE = " REAL";
        String CREATE_TABLE = "CREATE TABLE " + TicketContract.TicketEntry.TABLE_NAME + "("
                + TicketContract.TicketEntry.COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY,"
                + TicketContract.TicketEntry.COLUMN_EID + TEXT_TYPE + COMMA_SEP
                + TicketContract.TicketEntry.COLUMN_SHORT + TEXT_TYPE + COMMA_SEP
                + TicketContract.TicketEntry.COLUMN_LONG + TEXT_TYPE + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TicketContract.TicketEntry.TABLE_NAME);
        //Creating DB
        onCreate(db);
    }

    //CRUDD Operations (Create, Read, Update, Delete, DeleteDatabase)

    // Adding new product
    public void addTicket(Ticket ticket){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TicketContract.TicketEntry.COLUMN_EID, ticket.getEmployeeID());
        values.put(TicketContract.TicketEntry.COLUMN_SHORT, ticket.getShortDesc());
        values.put(TicketContract.TicketEntry.COLUMN_LONG, ticket.getLongDesc());

        // Inserting rows into database
        db.insert(TicketContract.TicketEntry.TABLE_NAME, null, values);
        db.close(); // Closing Database Connections
    }

    // Getting one Ticket
    public Cursor getTicket(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TicketContract.TicketEntry.TABLE_NAME,
                new String[]{
                        TicketContract.TicketEntry.COLUMN_PRODUCT_ID,
                        TicketContract.TicketEntry.COLUMN_EID,
                        TicketContract.TicketEntry.COLUMN_SHORT,
                        TicketContract.TicketEntry.COLUMN_LONG
                },
                TicketContract.TicketEntry.COLUMN_PRODUCT_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        return cursor;
    }

    
}
