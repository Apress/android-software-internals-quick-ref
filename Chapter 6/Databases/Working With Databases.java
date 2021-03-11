//Define a schema and contract:
public final class databaseTemplate {

    // Inner class that represents the table values
    public static class databaseData implements BaseColumns {
        public static final String TABLE_NAME = "TABLE_NAME";
        public static final String COLUMN_ONE = "FIRST_COLUMN_NAME";
        public static final String COLUMN_TWO = "SECOND_COLUMN_NAME";
    }
}

//Creating a database helper:
public class databaseHelper extends SQLiteOpenHelper {

    public databaseHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    private static final String SQL_CREATE_INSTRUCTION =
            "CREATE TABLE " + databaseTemplate.databaseData.TABLE_NAME + " (" +
                    databaseTemplate.databaseData._ID + " INTEGER PRIMARY KEY," +
                    databaseTemplate.databaseData.COLUMN_ONE + " TEXT," +
                    databaseTemplate.databaseData.COLUMN_TWO + " TEXT)";

    private static final String SQL_DELETE_INSTRUCTION =
            "DROP TABLE IF EXISTS " + databaseTemplate.databaseData.TABLE_NAME;

    public static final int VERSION = 1; //increment if schema changed

    public static final String NAME = "database.db"; // database name

    // Standard Database functions

    public void onCreate(SQLiteDatabase database) {
        database.execSQL(SQL_CREATE_INSTRUCTION);
    }

    public void onUpgrade(SQLiteDatabase database, int previousVersion, int currentVersion) {
        database.execSQL(SQL_DELETE_INSTRUCTION);
        onCreate(database);
    }
}

//Adding a row to a database:
private void addDataToDatabase(Context context, String columnOneData, String columnTwoData){

    databaseHelper databaseHelper = new databaseHelper(context);

    SQLiteDatabase database = databaseHelper.getWritableDatabase();

    ContentValues contentValues = new ContentValues();
    contentValues.put(databaseTemplate.databaseData.COLUMN_ONE, columnOneData);
    contentValues.put(databaseTemplate.databaseData.COLUMN_TWO, columnTwoData);

    database.insert(databaseTemplate.databaseData.TABLE_NAME, null, contentValues);
}

//Reading a database:

    private List<String> readFromDatabase(Context context){

        final String TABLE_NAME = databaseTemplate.databaseData.TABLE_NAME;

        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        databaseHelper databaseHelper = new databaseHelper(context);
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        Cursor cursor      = database.rawQuery(selectQuery, null);
        ArrayList data = new ArrayList();

        if (cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndexOrThrow(databaseTemplate.databaseData._ID);
                int columnOneIndex = cursor.getColumnIndexOrThrow(databaseTemplate.databaseData.COLUMN_ONE);
                int columnTwoIndex = cursor.getColumnIndexOrThrow(databaseTemplate.databaseData.COLUMN_TWO);

                String idValue = String.valueOf(cursor.getString(idIndex));
                String columnOneValue = String.valueOf(cursor.getString(columnOneIndex));
                String columnTwoValue = String.valueOf(cursor.getString(columnTwoIndex));

                ArrayList rowData = new ArrayList();
                rowData.add(idValue);
                rowData.add(columnOneValue);
                rowData.add(columnTwoValue);

                data.add(rowData);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return data;
    }

//Deleting a row from a database:
private void deleteRowFromDatabase(Context context, int rowIdToRemove){

    databaseHelper databaseHelper = new databaseHelper(context);
    SQLiteDatabase database = databaseHelper.getReadableDatabase();

    String selection = databaseTemplate.databaseData._ID + " LIKE ?";

    String[] selectionValues = {String.valueOf(rowIdToRemove)};

    database.delete(databaseTemplate.databaseData.TABLE_NAME, selection, selectionValues);
}

// Usage
this.addDataToDatabase(this.getApplicationContext(), "column1","column2");
List<String> data = this.readFromDatabase(this.getApplicationContext());
Log.v("TAG", String.valueOf(data));
this.deleteRowFromDatabase(getApplicationContext(),0);
test = this.readFromDatabase(this.getApplicationContext());
Log.v("TAG", String.valueOf(data));
