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

/**
 * Created by ivan on 15/02/2016.
 */
public class BancoController  {
    static private SQLiteDatabase db;
    static private CriaBanco banco;

    public BancoController(Context context){
        banco = new CriaBanco(context);
    }

    /*INSERIR SERIE*/
    public void inserirSerie(String nomeSerie, String nomeProdutora, String genero, String comentario, int numTemporada, int classificacao) {

        db = banco.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(CriaBanco.NOME_SERIE, nomeSerie);
        valores.put(CriaBanco.NOME_PRODUTORA, nomeProdutora);
        valores.put(CriaBanco.GENERO, genero);
        valores.put(CriaBanco.COMENTARIO, comentario);
        valores.put(CriaBanco.TEMPORADA, numTemporada);
        valores.put(CriaBanco.CLASSIFICACAO, classificacao);

        db.insert(CriaBanco.SERIE, null, valores);
        if (db.isOpen())
            db.close();
    }

    /*INSERIR FILME*/
    public void inserirFilme(String nomeFilme, String genero, String comentario, int ano, int classificacao) {

        db = banco.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(CriaBanco.NOME_FILME, nomeFilme);
        valores.put(CriaBanco.GENERO, genero);
        valores.put(CriaBanco.COMENTARIO, comentario);
        valores.put(CriaBanco.ANO, ano);
        valores.put(CriaBanco.CLASSIFICACAO, classificacao);

        db.insert(CriaBanco.SERIE, null, valores);
        if (db.isOpen())
            db.close();
    }

    /*INSERIR LIVRO*/
    public void inserirLivro(String nomeLivro, String nomeAutor, String genero, String comentario, int paginas, int classificacao) {

        db = banco.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(CriaBanco.NOME_LIVRO, nomeLivro);
        valores.put(CriaBanco.NOME_AUTOR, nomeAutor);
        valores.put(CriaBanco.GENERO, genero);
        valores.put(CriaBanco.COMENTARIO, comentario);
        valores.put(CriaBanco.PAGINAS, paginas);
        valores.put(CriaBanco.CLASSIFICACAO, classificacao);

        db.insert(CriaBanco.SERIE, null, valores);
        if (db.isOpen())
            db.close();
    }

    /*EDITAR SERIE*/
    public String editarSerie(String nomeSerie, String nomeProdutora, String genero, String comentario, int numTemporada, int classificacao, int ID) {
        int resultado;
        String where = CriaBanco.ID + " = " + ID;

        db = banco.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(CriaBanco.NOME_SERIE, nomeSerie);
        valores.put(CriaBanco.NOME_PRODUTORA, nomeProdutora);
        valores.put(CriaBanco.GENERO, genero);
        valores.put(CriaBanco.COMENTARIO, comentario);
        valores.put(CriaBanco.TEMPORADA, numTemporada);
        valores.put(CriaBanco.CLASSIFICACAO, classificacao);

        resultado = db.update(CriaBanco.SERIE, valores, where, null);
        if (db.isOpen())
            db.close();
        if (resultado == -1)
            return "Erro ao alterar registro";
        else
            return "Registro alterado com sucesso!";
    }


// Retorna as informações básicas das séries (TELA 10)
    public seriesObjeto[] getSerieSimples(){
        Log.d("DDDDEBUG","vrau");

        Cursor cursor;
        String[] campos = {CriaBanco.ID, CriaBanco.NOME_SERIE, CriaBanco.NOME_PRODUTORA, CriaBanco.CLASSIFICACAO};
        db = banco.getReadableDatabase();

        cursor = db.query(CriaBanco.SERIE, campos, null, null, null, null, null, null);

        seriesObjeto[] seriesobj = new seriesObjeto[cursor.getCount()];

        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            seriesobj[cursor.getPosition()] = new seriesObjeto();
            seriesobj[cursor.getPosition()].nome_serie = cursor.getString(cursor.getColumnIndex(CriaBanco.NOME_SERIE));
            seriesobj[cursor.getPosition()].nome_produtora = cursor.getString(cursor.getColumnIndex(CriaBanco.NOME_PRODUTORA));
            seriesobj[cursor.getPosition()].classificacao1 = cursor.getInt(cursor.getColumnIndex(CriaBanco.CLASSIFICACAO));
            cursor.moveToNext();
        }
        cursor.close();

        if(db.isOpen())
            db.close();

        return seriesobj;
    }

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
//    public String[] getTipos(){
//        Cursor cursor;
//        String[] campos = {CriaBanco.ID, CriaBanco.TIPO};
//        db = banco.getReadableDatabase();
//
//        cursor = db.query(CriaBanco.CURSOS, campos, null, null, null, null, null, null);
//
//        ArrayList<String> names = new ArrayList<String>();
//        cursor.moveToFirst();
//        while(!cursor.isAfterLast()) {
//            names.add(cursor.getString(cursor.getColumnIndex(CriaBanco.TIPO)));
//            cursor.moveToNext();
//        }
//        cursor.close();
//
//        if(db.isOpen())
//            db.close();
//
//        return names.toArray(new String[names.size()]);
//
//    }
//
//    public CursoObj getCursoByTitulo(String titulo){
//        Cursor cursor;
//        String[] campos = {CriaBanco.TIPO, CriaBanco.TITULO, CriaBanco.INFOS, CriaBanco.EXTRA};
//        String where = CriaBanco.TITULO + " LIKE '" + titulo + "'";
//        db = banco.getReadableDatabase();
//
//        cursor = db.query(CriaBanco.CURSOS, campos, where, null, null, null, null, null);
//
//        cursor.moveToFirst();
//        CursoObj o = new CursoObj(
//        cursor.getString(cursor.getColumnIndex(CriaBanco.TITULO)).toString(),
//        cursor.getString(cursor.getColumnIndex(CriaBanco.INFOS)).toString(),
//        cursor.getString(cursor.getColumnIndex(CriaBanco.TIPO)).toString(),
//        cursor.getString(cursor.getColumnIndex(CriaBanco.EXTRA)).toString()
//                );
//
//        if(db.isOpen())
//            db.close();
//
//        return o;
//    }
//    static public void deletaDado(int ID){
//        String where = CriaBanco.DATA_ID + "=" + ID;
//        db = banco.getReadableDatabase();
//        db.delete(CriaBanco.TALI_MED_QTD, where, null);
//
//        where = CriaBanco.ID + "=" + ID;
//        db.delete(CriaBanco.TDATA, where, null);
//        if(db.isOpen())
//            db.close();
//    }
//

}
