package br.com.kenuiapps.jumper.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.com.kenuiapps.jumper.util.Constantes;

public class DbHelper extends SQLiteOpenHelper {

	private Context mContext;
	private static DbHelper mInstance = null;

	public DbHelper(Context context) {
		super(context, Constantes.DATABASE, null, Constantes.DATABASE_VERSION);
        mContext = context;
	}
	
	public static synchronized DbHelper getInstance(Context context) {
		if (mInstance == null) {
			mInstance = new DbHelper(context.getApplicationContext());
		}
		return mInstance;
	}
	
	@Override
	public void onCreate(SQLiteDatabase database) {

		String TAG = "DbHelper";
		try {

    		String[] tables = Constantes.CREATE_TABLE();
			for (String table : tables) {
				database.execSQL(table);
				Log.d(TAG, "Criando tabela: " + table);
			}
    		
		} catch (Exception e) {
			e.printStackTrace();
			Log.e(TAG, "O banco parou");
		}
	}
		
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
