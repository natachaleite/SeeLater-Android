package com.formobile.seelater;

/* Created by Nathalia on 16/02/2017. */

import android.content.Intent;
import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


public class AdicionaSeriesActivity extends Activity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionarserie);

        Intent intent = getIntent();

        final EditText etNome = (EditText) findViewById(R.id.etNomeSerie);
        final EditText etProdutora = (EditText) findViewById(R.id.etProdutora);
        final EditText etGenero = (EditText) findViewById(R.id.etGenero);
        final EditText etComentario = (EditText) findViewById(R.id.etComentario);
        final EditText etTemp = (EditText) findViewById(R.id.etTemp);
        final RatingBar rbPrioridade = (RatingBar) findViewById(R.id.rbPrioridade);

        final BancoController b1 = new BancoController(AdicionaSeriesActivity.this);

        final int tela = intent.getExtras().getInt("tela");
        //Tela para editar
        int id = -1;
        if (tela == 1) {
            id = Integer.parseInt(intent.getExtras().getString("id"));
            Log.d("ID", id + "");
            Cursor cursor = b1.getSerieCompleto(id);

            etNome.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.NOME_SERIE)));
            etTemp.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.TEMPORADA)));
            etProdutora.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.NOME_PRODUTORA)));
            etGenero.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.GENERO)));
            etComentario.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.COMENTARIO)));
            rbPrioridade.setRating(cursor.getInt(cursor.getColumnIndex(CriaBanco.CLASSIFICACAO)));
        }

        Button buttonOK = (Button) findViewById(R.id.buttonOK);
        final int finalId = id;
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nomeFilme = etNome.getText().toString();
                final int numTemp = Integer.parseInt(etTemp.getText().toString());
                final String produtora = etProdutora.getText().toString();
                final String genero = etGenero.getText().toString();
                final String comentario = etComentario.getText().toString();
                final float prioridade = rbPrioridade.getRating();

                BancoController b1 = new BancoController(AdicionaSeriesActivity.this);

                if (tela == 1) {
                    b1.editarSerie(nomeFilme, produtora, genero, comentario, numTemp, prioridade, finalId);
                    //atualizaSeries(this);
                }else
                    b1.inserirSerie(nomeFilme, produtora, genero, comentario, numTemp, prioridade);

                finish();
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onStart() {
        super.onStart();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }


    @Override
    public void onStop() {
        super.onStop();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.disconnect();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("AdicionaSeries Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }
}
