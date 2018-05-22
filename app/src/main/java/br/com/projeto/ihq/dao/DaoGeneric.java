package br.com.projeto.ihq.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.MessageFormat;

import br.com.projeto.ihq.dao.sqlite.SQLfactory;
import br.com.projeto.ihq.dao.sqlite.ScriptsSQL;
import br.com.projeto.ihq.exception.SqliteException;
import br.com.projeto.ihq.model.Album;
import br.com.projeto.ihq.model.Hq;
import br.com.projeto.ihq.model.Usuario;
import br.com.projeto.ihq.util.Util;

public class DaoGeneric {

    private static SQLiteDatabase db;
    private static Cursor cursor;
    private static Usuario usuario;

    private static String sql;

    public static void salvarUsuario(Context context, Usuario usuario) throws SqliteException {

        System.out.println("ENTROU.....");

        try {
            db = SQLfactory.getInstance(context);
            sql = ScriptsSQL.Usuario.insert;
            sql = MessageFormat.format(sql, usuario.getToSqlInsert());
            db.execSQL(sql);
            SQLfactory.closedb(context);

        } catch (SqliteException e) {
            e.printStackTrace();
            throw new SqliteException("Erro Insert Usuario");
        }

    }

    public static Usuario buscarUsuarioPorLogin(Context context, String login, String senha) throws SqliteException {
        db = SQLfactory.getInstance(context);
        login = "'" + login + "'";
        senha = "'" + senha + "'";
        sql = ScriptsSQL.Usuario.selectPorlogin;
        sql = MessageFormat.format(sql, login, senha);
        System.out.println(login);
        System.out.println(senha);
        System.out.println(sql);
        cursor = db.rawQuery(sql, null);
//            cursor = db.rawQuery("select * from usuario where login = ? ", new String[] {login});
//            cursor = db.query("usuario",null,"login=", new String[] {login}, null, null, null);

        if (cursor.moveToFirst()) {
            usuario = new Usuario();

            usuario.setId(cursor.getInt(cursor.getColumnIndex(ScriptsSQL.Usuario.columID)));
            usuario.setNomeCompleto(cursor.getString(cursor.getColumnIndex("nome_completo")));
            usuario.setLogin(cursor.getString(cursor.getColumnIndex("login")));
            usuario.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
            usuario.setSincronizado(Boolean.valueOf(cursor.getString(cursor.getColumnIndex("sincronizado"))));
            usuario.setDataCadastro(Util.getDateToString(cursor.getString(cursor.getColumnIndex("data_cadatro")), Util.dataTimeFormater_dd_MM_yyy_HH_mm_ss));
            usuario.setUltimoAcesso(Util.getDateToString(cursor.getString(cursor.getColumnIndex("ultimo_acesso")), Util.dataTimeFormater_dd_MM_yyy_HH_mm_ss));
            SQLfactory.closedb(context);
            return usuario;
        }
        throw new SqliteException("usuario ou senha inválida");

    }

    public static void salvarHQ(Hq hq) {
        //abro a conexao
        //faço alguma cois
        // fecho conexão

    }

    public static void salvarALbum(Album album) {
        //abro a conexao
        //faço alguma cois
        // fecho conexão

    }

    public static Boolean isUsuarioLogado(Context context) throws SqliteException {

        db = SQLfactory.getInstance(context);
        sql = ScriptsSQL.Usuario.selectAll;
        cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        return Boolean.valueOf(cursor.getString(cursor.getColumnIndex("sincronizado")));

    }
}
