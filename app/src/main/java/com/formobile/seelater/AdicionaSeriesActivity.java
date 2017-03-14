package com.formobile.seelater;

/* Created by Nathalia on 16/02/2017. */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;


public class AdicionaSeriesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionarserie);

        final EditText etNome = (EditText) findViewById(R.id.etNome);
        final EditText etTemp = (EditText) findViewById(R.id.etTemp);
        final EditText etProdutora = (EditText) findViewById(R.id.etProdutora);
        final EditText etGenero = (EditText) findViewById(R.id.etGenero);
        final EditText etComentario = (EditText) findViewById(R.id.etComentario);
        final RatingBar rbPrioridade = (RatingBar) findViewById(R.id.rbPrioridade);

        Button buttonOK = (Button) findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nomeSerie = etNome.getText().toString();
                final String numTemp = etTemp.getText().toString();
                final String produtora = etProdutora.getText().toString();
                final String genero = etGenero.getText().toString();
                final String comentario = etComentario.getText().toString();
                final float prioridade = rbPrioridade.getRating();

                BancoController b1 = new BancoController(AdicionaSeriesActivity.this);

                b1.inserirSerie(nomeSerie, numTemp, produtora, genero, comentario, prioridade);
                finish();
            }
        });
    }




    @Override
    public void onStart() { super.onStart(); }


    @Override
    public void onStop() { super.onStop(); }
}
