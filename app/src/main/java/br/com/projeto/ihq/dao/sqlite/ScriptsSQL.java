package br.com.projeto.ihq.dao.sqlite;

public class ScriptsSQL {


    public static class Usuario {
        public static final String columID  = "id";

        public static final String createTable = "" +
                "CREATE TABLE usuario(id integer primary key, " +
                "nome_completo varchar not null, " +
                "login varchar not null unique, " +
                "senha varchar not null, " +
                "sincronizado boolean not null,"+
                "data_cadatro datetime not null, " +
                "ultimo_acesso datetime not null);";
        public static final String dropTable = "DROP TABLE usuario";

        public static String insert = "" +
                "INSERT INTO usuario(" +
                columID+","+
                "nome_completo," +
                "login," +
                "senha," +
                "sincronizado," +
                "data_cadatro," +
                "ultimo_acesso)" +
                "values ({0})";

        public static String selectPorlogin = "select * from usuario where login = {0} and senha={1}";
        public static String selectAll = "select * from usuario";
    }

    public static class HQ {

        public static String create = "";
        public static String insert = "";
        public static String update = "";
        public static String drop = "";
    }
}
