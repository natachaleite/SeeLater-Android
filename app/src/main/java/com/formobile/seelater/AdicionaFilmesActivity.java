package com.formobile.seelater;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RatingBar;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import static com.formobile.seelater.R.id.etAnoFilme;

public class AdicionaFilmesActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    BancoController b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_filme);

        Intent intent = getIntent();

        final EditText etNome = (EditText) findViewById(R.id.etNomeFilme);
        final EditText etGenero = (EditText) findViewById(R.id.etGeneroFilme);
        final EditText etComentario = (EditText) findViewById(R.id.etComentarioFilme);
        final EditText etAno = (EditText) findViewById(etAnoFilme);
        final RatingBar rbPrioridade = (RatingBar) findViewById(R.id.rbPrioridade);

        b1 = new BancoController(AdicionaFilmesActivity.this);

        final int tela = intent.getExtras().getInt("tela");
        //Tela para editar
        int id = -1;
        if (tela == 1) {
            id = Integer.parseInt(intent.getExtras().getString("id"));
            Log.d("ID", id + "");
            Cursor cursor = b1.getFilmeCompleto(id);

            etNome.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.NOME_FILME)));
            etGenero.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.GENERO)));
            etComentario.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.COMENTARIO)));
            etAno.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.ANO)));
            rbPrioridade.setRating(cursor.getInt(cursor.getColumnIndex(CriaBanco.CLASSIFICACAO)));
        }

        Button buttonOK = (Button) findViewById(R.id.buttonOK);
        final int finalId = id;
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nomeFilme = etNome.getText().toString();
                final String genero = etGenero.getText().toString();
                final String comentario = etComentario.getText().toString();
                final int ano = Integer.parseInt(etAno.getText().toString());
                final float prioridade = rbPrioridade.getRating();

                BancoController b1 = new BancoController(AdicionaFilmesActivity.this);

                if (tela == 1) {
                    b1.editarFilme(nomeFilme, genero, comentario, ano, prioridade, finalId);
                } else
                    b1.inserirFilme(nomeFilme, genero, comentario, ano, prioridade);

                finish();
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("AdicionaFilmes Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
