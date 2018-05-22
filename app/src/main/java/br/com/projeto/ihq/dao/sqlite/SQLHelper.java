package br.com.projeto.ihq.dao.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {
    private static final String NOME = "ihq.sqlite";
    private static final int VERSION = 3;
    private final String log = "DB";
    private Context context;

    public SQLHelper(Context context) {
        super(context, NOME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("onCreate - SQLITE");
        criarTabelas(db);
    }

    private void criarTabelas(SQLiteDatabase db) {
        db.execSQL(ScriptsSQL.Usuario.createTable);
//        db.execSQL(ScriptsSQL.Eleitor.createTable);
//        db.execSQL(ScriptsSQL.Contato.createTable);
//        db.execSQL(ScriptsSQL.Dependente.createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        System.out.println("onUpgrade - SQLITE");

        if(VERSION==2){
            db.execSQL(ScriptsSQL.Usuario.dropTable);
        }if(VERSION==3){
            db.execSQL(ScriptsSQL.Usuario.createTable);
        }if(VERSION==4){

        }


    }
}
