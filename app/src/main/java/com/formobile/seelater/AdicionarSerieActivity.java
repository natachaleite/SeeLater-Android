package com.formobile.seelater;

/* Created by Nathalia on 16/02/2017. */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;


public class AdicionarSerieActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionarserie);

        EditText etNome = (EditText) findViewById(R.id.etNome);
        EditText etTemp = (EditText) findViewById(R.id.etTemp);
        EditText etProdutora = (EditText) findViewById(R.id.etProdutora);
        EditText etGenero = (EditText) findViewById(R.id.etGenero);
        EditText etComentario = (EditText) findViewById(R.id.etComentario);
        RatingBar rbPrioridade = (RatingBar) findViewById(R.id.rbPrioridade);

        String nomeSerie = etNome.toString();
        String numTemp = etTemp.toString();
        String produtora = etProdutora.toString();
        String genero = etGenero.toString();
        String comentario = etComentario.toString();
        int prioridade = rbPrioridade.getNumStars();

        Button buttonOK = (Button) findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }




    @Override
    public void onStart() { super.onStart(); }


    @Override
    public void onStop() { super.onStop(); }
}
