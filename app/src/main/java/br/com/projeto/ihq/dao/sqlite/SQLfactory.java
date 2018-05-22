package br.com.projeto.ihq.dao.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import br.com.projeto.ihq.exception.SqliteException;

public class SQLfactory {

    private static SQLiteDatabase db;
    private static SQLHelper helper;


    private SQLfactory() {

    }

    public static SQLiteDatabase getInstance(Context context) throws SqliteException {
        try {
            if (db == null || !db.isOpen()) {
                helper = new SQLHelper(context);
                db = helper.getWritableDatabase();
            }

        } catch (Exception e) {
            throw new SqliteException("SQLITE Exception");
        }
        return db;
    }

    public static void closedb(Context context) throws SqliteException {
        try {
            if (db != null || db.isOpen()) {
                db.close();
                if (helper != null) helper.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new SqliteException("Erro ClosedDb");
        }
    }
}
