package com.example.mediaplayer;

public class DBAdapter extends MainActivity {

	

	import android.content.*;
	import android.database.*;
	import android.database.sqlite.*;
	import android.util.Log;

	
		public static final String KEY_ROWID = "_id";
		public static final String KEY_TITLE = "title";
		//public static final String KEY_RATING ="rating";
		public static final String KEY_DESCRIPTION = "description";
		public static final String KEY_IMAGENAME = "imageName";
		public static final String KEY_TRAILERNAME = "trailerName";
		public static final String TAG = "DBAdapter";
		private static final String DATABASE_NAME = "MyDB";
		private static final Sttring DATABASE_TABLE = "myTrailers";
		private static final int DATABASE_VERSION = 2;
		
		private static final String DATABASE_CREATE =
			"create table contacts(_id integer primary key autoincrement,"
			+ "name text not null,email text not null);";
		
		private final Context context;
		private DatabaseHelper DBHelper;
		private SQLiteDatabase db;
		
		public DBAdapter(Context ctx)
		{
			this.context = ctx;
			DBHelper = new DatabaseHelper(context);	
		}
		
		private static class DatabaseHelper extends SQLiteOpenHelper
		{
			DatabaseHelper(Context context)
			{
				super(context,DATABASE_NAME,null,DATABASE_VERSION);
			}
			
			public void onCreate(SQLiteDatabase db)
			{
				try{
					db.execSQL(DATABASE_CREATE);
				}catch(SQLException e){
					e.printStackTrace();
				}		
			}//end method onCreate
			
			public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
			{
				Log.w(TAG,"Upgrade database from version " + oldVersion + " to "
				+ newVersion + ", which will destroy all old data");
				db.execSQL("DROP TABLE IF EXISTS myTrailers");
				onCreate(db);	
			}//end method onUpgrade
		}
		
		//open the database
		public DBAdapter open() throws SQLException
		{
			db = DBHelper.getWritableDatabase();
			return this;
		}
		
		//close the database
		public void close()
		{
			DBHelper.close();
		}
		
		//insert a contact into the database
		public long insertTrailer(String title, String description, String imageName, String trailerName )
		{
			ContentValues initialValues = new ContentValues();
			initialValues.put(KEY_TITLE, title);
			//initialValues.put(KEY_RATING, rating);
			initialValues.put(KEY_DESCRIPTION, description);
			initialValues.put(KEY_IMAGENAME, imageName);
			initialValues.put(KEY_TRAILERNAME, trailerName);
			
			return db.insert(DATABASE_TABLE, null, initialValues);
		}

		//delete a particular trailer
		public boolean deleteTrailer(long rowId)
		{
			return db.delete(DATABASE_TABLE,KEY_ROWID + "=" + rowId,null) >0;
		}
		
		//retrieve all the trailers
		public Cursor getAllContact()
		{
			return db.query(DATABASE_TABLE,new String[]{
					KEY_ROWID,
					KEY_TITLE,
					//KEY_RATING,
					KEY_DESCRIPTION,
					KEY_IMAGENAME,
					KEY_TRAILERNAME},null,null,null,null,null);
			if(mCursor != null)
			{
				mCursor.moveToFirst();
			}
			return mCursor;
		}
		
		//retrieve a single Trailer
		public Cursor getContact(long rowId) throws SQLException
		{
			Cursor mCursor = db.query(true, DATABASE_TABLE, new String[] {
					KEY_ROWID,
					KEY_TITLE,
					//KEY_RATING,
					KEY_DESCRIPTION,
					KEY_IMAGENAME,
					KEY_TRAILERNAME},KEY_ROWID + "=" + rowId,null,null,null,null,null);
			if(mCursor != null)
			{
				mCursor.moveToFirst();
			}
			return mCursor;
		}
		
		//updates a contact
		public boolean updateContact(long rowId,String title, String description, String imageName, String trailerName)
		{
			ContentValues cval = new ContentValues();
			cval.put(KEY_TITLE, title);
			//cval.put(KEY_RATING, rating);
			cval.put(KEY_DESCRIPTION, description);
			cval.put(KEY_IMAGENAME, imageName);
			cval.put(KEY_TRAILERNAME, trailerName);
			
			return db.update(DATABASE_TABLE, cval, KEY_ROWID + "=" + rowId,null) >0;
		}
		
	}//end class DBAdapter


	
	
}
