package com.example.wa05dthomebase.hellokitty;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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

    public List<Ticket> GetAllTickets(){
        List<Ticket> ticketList = new ArrayList<Ticket>();

        String selectQuery = "SELECT * FROM " + TicketContract.TicketEntry.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Ticket ticket = new Ticket();
                ticket.setId(Integer.parseInt(cursor.getString(0)));
                ticket.setEmployeeID(cursor.getString(1));
                ticket.setShortDesc(cursor.getString(2));
                ticket.setLongDesc(cursor.getString(3));

                ticketList.add(ticket);
            } while (cursor.moveToNext());
        }

        return ticketList;
    }

    public int updateTicket(Ticket ticket){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TicketContract.TicketEntry.COLUMN_EID, ticket.getEmployeeID());
        values.put(TicketContract.TicketEntry.COLUMN_SHORT, ticket.getShortDesc());
        values.put(TicketContract.TicketEntry.COLUMN_LONG, ticket.getLongDesc());

        return db.update(TicketContract.TicketEntry.TABLE_NAME, values,
                TicketContract.TicketEntry.COLUMN_PRODUCT_ID + " = ?",
                new String[]{String.valueOf(ticket.getId())});
    }

    //Deleting a Ticket
    public void deleteTicket(Ticket ticket){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TicketContract.TicketEntry.TABLE_NAME, TicketContract.TicketEntry.COLUMN_PRODUCT_ID + " = ?", new String[]{String.valueOf(ticket.getId())});

        db.close();
    }

    //Delete all tickets
    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TicketContract.TicketEntry.TABLE_NAME, null, null);
        db.execSQL(" delete from " + TicketContract.TicketEntry.TABLE_NAME);
        db.close();
    }

    //Detele the database file
    public void deleteDatabase(){
        mContext.deleteDatabase(DATABASE_NAME);
    }

}
