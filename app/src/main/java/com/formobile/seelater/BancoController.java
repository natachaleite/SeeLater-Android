package com.formobile.seelater;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static com.formobile.seelater.R.id.nomeSerie;
import static java.lang.Boolean.TRUE;

/**
 * Created by group on 15/02/2016.
 */
public class BancoController  {
    static private SQLiteDatabase db;
    static private CriaBanco banco;


    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    /*INSERIR SERIE*/
    public void inserirSerie(String nomeSerie,  int numTemporada, String nomeProdutora, String genero, String comentario, float classificacao) {

        db = banco.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(CriaBanco.NOME_SERIE, nomeSerie);
        valores.put(CriaBanco.NOME_PRODUTORA, nomeProdutora);
        valores.put(CriaBanco.TEMPORADA, numTemporada);
        valores.put(CriaBanco.GENERO, genero);
        valores.put(CriaBanco.COMENTARIO, comentario);
        valores.put(CriaBanco.CLASSIFICACAO, classificacao);

        db.insert(CriaBanco.SERIE, null, valores);
        if (db.isOpen())
            db.close();
    }

    /*INSERIR FILME*/
    public void inserirFilme(String nomeFilme, String genero, String comentario, int ano, float classificacao) {

        db = banco.getWritableDatabase();
        ContentValues valores = new ContentValues();
//        long resultado;

        valores.put(CriaBanco.NOME_FILME, nomeFilme);
        valores.put(CriaBanco.GENERO, genero);
        valores.put(CriaBanco.COMENTARIO, comentario);
        valores.put(CriaBanco.ANO, ano);
        valores.put(CriaBanco.CLASSIFICACAO, classificacao);

//        resultado = db.insert(CriaBanco.FILME, null, valores);
        db.insert(CriaBanco.FILME, null, valores);

//        if(resultado == 1)
//            countFilmes++;

        if (db.isOpen())
            db.close();
    }

    /*INSERIR LIVRO*/
    public void inserirLivro(String nomeLivro, String nomeAutor, String genero, String comentario, int paginas, float classificacao) {
        Log.d("TAG","inseriu livro");

        db = banco.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(CriaBanco.NOME_LIVRO, nomeLivro);
        valores.put(CriaBanco.NOME_AUTOR, nomeAutor);
        valores.put(CriaBanco.GENERO, genero);
        valores.put(CriaBanco.COMENTARIO, comentario);
        valores.put(CriaBanco.PAGINAS, paginas);
        valores.put(CriaBanco.CLASSIFICACAO, classificacao);

        db.insert(CriaBanco.LIVRO, null, valores);

        if (db.isOpen())
            db.close();

    }

    /*EDITAR SERIE*/
    public String editarSerie(String nomeSerie, String nomeProdutora, String genero, String comentario, int numTemporada, float classificacao, int ID) {
        int resultado;
        String where = CriaBanco.ID + " = " + ID;

        db = banco.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(CriaBanco.NOME_SERIE, nomeSerie);
        valores.put(CriaBanco.NOME_PRODUTORA, nomeProdutora);
        valores.put(CriaBanco.GENERO, genero);
        valores.put(CriaBanco.COMENTARIO, comentario);
        valores.put(CriaBanco.CLASSIFICACAO, classificacao);
        valores.put(CriaBanco.TEMPORADA, numTemporada);

        resultado = db.update(CriaBanco.SERIE, valores, where, null);
        if (db.isOpen())
            db.close();
        if (resultado == -1)
            return "Erro ao alterar registro";
        else
            return "Registro alterado com sucesso!";
    }

    /*EDITAR LIVRO*/
    public String editarLivro(String nomeLivro, String nomeAutor, String genero, String comentario, int numPaginas, float classificacao, int ID) {
        int resultado;
        String where = CriaBanco.ID + " = " + ID;

        db = banco.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(CriaBanco.NOME_LIVRO, nomeLivro);
        valores.put(CriaBanco.NOME_AUTOR, nomeAutor);
        valores.put(CriaBanco.GENERO, genero);
        valores.put(CriaBanco.COMENTARIO, comentario);
        valores.put(CriaBanco.CLASSIFICACAO, classificacao);
        valores.put(CriaBanco.PAGINAS, numPaginas);

        resultado = db.update(CriaBanco.LIVRO, valores, where, null);
        if (db.isOpen())
            db.close();
        if (resultado == -1)
            return "Erro ao alterar registro";
        else
            return "Registro alterado com sucesso!";
    }

    /* EDITAR FILMES */
    public String editarFilme(String nomeLivro, String genero, String comentario, int ano, float classificacao, int ID) {
        int resultado;
        String where = CriaBanco.ID + " = " + ID;

        db = banco.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(CriaBanco.NOME_FILME, nomeLivro);
        valores.put(CriaBanco.GENERO, genero);
        valores.put(CriaBanco.COMENTARIO, comentario);
        valores.put(CriaBanco.ANO, ano);
        valores.put(CriaBanco.CLASSIFICACAO, classificacao);


        resultado = db.update(CriaBanco.FILME, valores, where, null);
        if (db.isOpen())
            db.close();
        if (resultado == -1)
            return "Erro ao alterar registro";
        else
            return "Registro alterado com sucesso!";
    }


    // Retorna as informações básicas das séries (TELA 10)
//    public seriesObjeto[] getSerieSimples(){
//        Log.d("DDDDEBUG","vrau");
//
//        Cursor cursor;
//        String[] campos = {CriaBanco.ID, CriaBanco.NOME_SERIE, CriaBanco.NOME_PRODUTORA, CriaBanco.CLASSIFICACAO};
//        db = banco.getReadableDatabase();
//
//        cursor = db.query(CriaBanco.SERIE, campos, null, null, null, null, null, null);
//
//        seriesObjeto[] seriesobj = new seriesObjeto[cursor.getCount()];
//
//        cursor.moveToFirst();
//        while(!cursor.isAfterLast()) {
//            seriesobj[cursor.getPosition()] = new seriesObjeto();
//            seriesobj[cursor.getPosition()].nome_serie = cursor.getString(cursor.getColumnIndex(CriaBanco.NOME_SERIE));
//            seriesobj[cursor.getPosition()].nome_produtora = cursor.getString(cursor.getColumnIndex(CriaBanco.NOME_PRODUTORA));
//            seriesobj[cursor.getPosition()].classificacao1 = cursor.getInt(cursor.getColumnIndex(CriaBanco.CLASSIFICACAO));
//            cursor.moveToNext();
//        }
//        cursor.close();
//
//        if(db.isOpen())
//            db.close();
//
//        return seriesobj;
//    }

    //MÉTODOS REFERENTES AOS LIVROS

    // Retorna as informações básicas dos livros (TELA 10)
    public Cursor getLivroSimples(int ID){
        Log.d("DDDDEBUG","vrau");

        Cursor cursor;
        String[] campos = {CriaBanco.ID, CriaBanco.NOME_LIVRO, CriaBanco.NOME_AUTOR, CriaBanco.CLASSIFICACAO};
        String where = CriaBanco.ID + " = " + ID;

        db = banco.getReadableDatabase();

        cursor = db.query(CriaBanco.LIVRO, campos, where, null, null, null, null, null);

        cursor.moveToFirst();

        if(db.isOpen())
            db.close();

        return cursor;
    }

    // Retorna as informações completas do livro(TELA 10)
    public Cursor getLivroCompleto(int ID){
        Log.d("DDDDEBUG","vrau");

        Cursor cursor;

        String where = CriaBanco.ID + " = " + ID;

        db = banco.getReadableDatabase();

        cursor = db.query(CriaBanco.LIVRO, null, where, null, null, null, null, null);

        cursor.moveToFirst();

        if(db.isOpen())
            db.close();

        return cursor;
    }

    // Retorna os ids dos livros
    public String[] getLivroIds(){
        Log.d("DDDDEBUG","vrau");

        Cursor cursor;
        String[] campos = {CriaBanco.ID};
        db = banco.getReadableDatabase();

        cursor = db.query(CriaBanco.LIVRO, campos, null, null, null, null, null, null);

        String[] ids = new String[cursor.getCount()];

        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            ids[cursor.getPosition()] = String.valueOf(cursor.getInt(cursor.getColumnIndex(CriaBanco.ID)));
            cursor.moveToNext();
        }
        cursor.close();

        if(db.isOpen())
            db.close();

        return ids;
    }

    //retorna a quantidade de livros
    public int getQtdeLivro(){
        Log.d("DDDDEBUG","vrau");

        Cursor cursor;
        String[] campos = {CriaBanco.ID, CriaBanco.NOME_LIVRO, CriaBanco.NOME_AUTOR, CriaBanco.CLASSIFICACAO};

        db = banco.getReadableDatabase();

        cursor = db.query(CriaBanco.LIVRO, campos, null, null, null, null, null, null);
        int aux = cursor.getCount();
        if(db.isOpen())
            db.close();

        return aux;
    }

    //MÉTODOS REFERENTES ÀS SERIES
    // Retorna as informações básicas das series (TELA 10)
    public Cursor getSerieSimples(int ID){
        Log.d("DDDDEBUG","vrau");

        Cursor cursor;
        String[] campos = {CriaBanco.ID, CriaBanco.NOME_SERIE, CriaBanco.NOME_PRODUTORA, CriaBanco.CLASSIFICACAO};
        String where = CriaBanco.ID + " = " + ID;

        db = banco.getReadableDatabase();

        cursor = db.query(CriaBanco.SERIE, campos, where, null, null, null, null, null);

        cursor.moveToFirst();

        if(db.isOpen())
            db.close();

        return cursor;
    }

    // Retorna as informações completas do livro(TELA 10)
    public Cursor getSerieCompleto(int ID){
        Log.d("DDDDEBUG","vrau");

        Cursor cursor;

        String where = CriaBanco.ID + " = " + ID;

        db = banco.getReadableDatabase();

        cursor = db.query(CriaBanco.SERIE, null, where, null, null, null, null, null);

        cursor.moveToFirst();

        if(db.isOpen())
            db.close();

        return cursor;
    }

    // Retorna os ids das series
    public String[] getSeriesIds(){
        Log.d("DDDDEBUG","vrau");

        Cursor cursor;
        String[] campos = {CriaBanco.ID};
        db = banco.getReadableDatabase();

        cursor = db.query(CriaBanco.SERIE, campos, null, null, null, null, null, null);

        String[] ids = new String[cursor.getCount()];

        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            ids[cursor.getPosition()] = String.valueOf(cursor.getInt(cursor.getColumnIndex(CriaBanco.ID)));
            cursor.moveToNext();
        }
        cursor.close();

        if(db.isOpen())
            db.close();

        return ids;
    }
    //retorna a quantidade de livros
    public int getQtdeSerie(){
        Log.d("CONSEGUI","vrau");

        Cursor cursor;
        String[] campos = {CriaBanco.ID, CriaBanco.NOME_SERIE, CriaBanco.NOME_PRODUTORA, CriaBanco.CLASSIFICACAO};

        db = banco.getReadableDatabase();

        cursor = db.query(CriaBanco.SERIE, campos, null, null, null, null, null, null);
        int aux = cursor.getCount();
        if(db.isOpen())
            db.close();

        return aux;
    }

    //MÉTODOS REFERENTES AOS FILMES

    // Retorna as informações básicas dos livros (TELA 10)
    public Cursor getFilmeSimples(int ID){
        Log.d("DDDDEBUG","vrau");

        Cursor cursor;
        String[] campos = {CriaBanco.ID, CriaBanco.NOME_FILME, CriaBanco.ANO, CriaBanco.CLASSIFICACAO};
        String where = CriaBanco.ID + " = " + ID;

        db = banco.getReadableDatabase();

        cursor = db.query(CriaBanco.FILME, campos, where, null, null, null, null, null);

        cursor.moveToFirst();

        if(db.isOpen())
            db.close();

        return cursor;
    }

    // Retorna as informações completas do livro(TELA 10)
    public Cursor getFilmeCompleto(int ID){
        Log.d("DDDDEBUG","vrau");

        Cursor cursor;

        String where = CriaBanco.ID + " = " + ID;

        db = banco.getReadableDatabase();

        cursor = db.query(CriaBanco.FILME, null, where, null, null, null, null, null);

        cursor.moveToFirst();

        if(db.isOpen())
            db.close();

        return cursor;
    }

    // Retorna os ids dos livros
    public String[] getFilmesIds(){
        Log.d("DDDDEBUG","vrau");

        Cursor cursor;
        String[] campos = {CriaBanco.ID};
        db = banco.getReadableDatabase();

        cursor = db.query(CriaBanco.FILME, campos, null, null, null, null, null, null);

        String[] ids = new String[cursor.getCount()];

        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            ids[cursor.getPosition()] = String.valueOf(cursor.getInt(cursor.getColumnIndex(CriaBanco.ID)));
            cursor.moveToNext();
        }
        cursor.close();

        if(db.isOpen())
            db.close();

        return ids;
    }

    //retorna a quantidade de livros
    public int getQtdeFilme(){
        Log.d("DDDDEBUG","vrau");

        Cursor cursor;
        String[] campos = {CriaBanco.ID, CriaBanco.NOME_FILME, CriaBanco.ANO, CriaBanco.CLASSIFICACAO};

        db = banco.getReadableDatabase();

        cursor = db.query(CriaBanco.FILME, campos, null, null, null, null, null, null);
        int aux = cursor.getCount();
        if(db.isOpen())
            db.close();

        return aux;
    }
    /** ------------------ FIM DOS MÉTODOS REFERENTES A FILMES, LIVROS E SÉRIES ------------- **/


    public void deletaItem(String TABELA, int ID){
        String where = CriaBanco.ID + "=" + ID;
        db = banco.getReadableDatabase();
        db.delete(TABELA, where, null);
        if(db.isOpen())
            db.close();
    }

    public void deletaTodosDados(){
        db = banco.getReadableDatabase();
//        db.execSQL("DELETE FROM " + CriaBanco.SERIE);
        db.execSQL("DELETE FROM " + CriaBanco.FILME);
        if(db.isOpen())
            db.close();
    }

}
