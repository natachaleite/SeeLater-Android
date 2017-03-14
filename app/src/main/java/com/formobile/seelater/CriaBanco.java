package com.formobile.seelater;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by group on 15/02/2016.
 */
public class CriaBanco extends SQLiteOpenHelper{

    public static final String NOME_BANCO = "ufla.db";

    /* TABELA SERIE*/
    public static final String SERIE = "serie"; /*nome da tabela*/
    public static final String ID = "_id";
    public static final String NOME_SERIE = "nm_Serie";
    public static final String NOME_PRODUTORA = "nm_Produtora";
    public static final String GENERO = "txt_Genero";
    public static final String COMENTARIO = "txt_Comentario";
    public static final String TEMPORADA = "num_Temporado";
    public static final String CLASSIFICACAO = "num_Classificacao";
    public static final String VISUALIZAR = "bin_Visualizar";

    /* TABELA FILME*/
    public static final String FILME = "filme"; /*nome da tabela*/
//    public static final String ID = "_id";
    public static final String NOME_FILME = "nm_Serie";
//    public static final String GENERO = "txt_Genero";
//    public static final String COMENTARIO = "txt_Comentario";
    public static final String ANO = "dt_Ano";
//    public static final String CLASSIFICACAO = "num_Classificacao";
//    public static final String VISUALIZAR = "bin_Visualizar";

    /* TABELA LIVRO*/
    public static final String LIVRO = "livro"; /*nome da tabela*/
//    public static final String ID = "_id";
    public static final String NOME_LIVRO = "nm_Livro";
    public static final String NOME_AUTOR = "nm_Autor";
//    public static final String GENERO = "txt_Genero";
//    public static final String COMENTARIO = "txt_Comentario";
    public static final String PAGINAS = "num_Paginas";
//    public static final String CLASSIFICACAO = "num_Classificacao";
//    public static final String VISUALIZAR = "bin_Visualizar";

    public static final int VERSAO = 1;

    public CriaBanco (Context context){
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE "+SERIE+"("
                + ID + " integer primary key autoincrement,"
                + NOME_SERIE + " text,"
                + NOME_PRODUTORA + " text,"
                + GENERO + " text,"
                + COMENTARIO + " text,"
                + TEMPORADA + " integer,"
                + CLASSIFICACAO + " integer,"
                + VISUALIZAR + " integer"
                +")";
        db.execSQL(sql);

        /*FILME*/
        sql = "CREATE TABLE "+FILME+"("
                + ID + " integer primary key autoincrement,"
                + NOME_FILME + " text,"
                + GENERO + " text,"
                + COMENTARIO + " text,"
                + ANO + " integer,"
                + CLASSIFICACAO + " integer,"
                + VISUALIZAR + " integer"
                +")";
        db.execSQL(sql);

        /*LIVRO*/
        sql = "CREATE TABLE "+LIVRO+"("
                + ID + " integer primary key autoincrement,"
                + NOME_LIVRO + " text,"
                + NOME_AUTOR + " text,"
                + GENERO + " text,"
                + COMENTARIO + " text,"
                + PAGINAS + " integer,"
                + CLASSIFICACAO + " float,"
                + VISUALIZAR + " integer"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXIST " + SERIE);
        db.execSQL("DROP TABLE IF EXIST " + FILME);
        db.execSQL("DROP TABLE IF EXIST " + LIVRO);
        onCreate(db);
    }
}
