package com.example.wa05dthomebase.hellokitty;

import android.provider.BaseColumns;

/**
 * Created by WA05DTHOMEBASE on 12/12/2017.
 * Class is used to set the columns for the SQL database
 */

public class TicketContract {
    public static final String DATABASE_NAME = "TicketDump";

    public static final int DATABASE_VERSION = 1;

    public class TicketEntry implements BaseColumns{
        public static final String TABLE_NAME = "TicketInfo";

        public static final String COLUMN_PRODUCT_ID = "ticketId";
        public static final String COLUMN_EID = "EID";
        public static final String COLUMN_SHORT = "shortDescription";
        public static final String COLUMN_LONG = "longDescription";
    }
}
