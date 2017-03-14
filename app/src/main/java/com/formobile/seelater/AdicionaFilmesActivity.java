package com.formobile.seelater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class AdicionaFilmesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_filme);

        final EditText etNome = (EditText) findViewById(R.id.etNomeFilme);
        final EditText etGenero = (EditText) findViewById(R.id.etGeneroFilme);
        final EditText etComentario = (EditText) findViewById(R.id.etComentarioFilme);
        final EditText etPaginas = (EditText) findViewById(R.id.etAnoFilme);
        final RatingBar rbPrioridade = (RatingBar) findViewById(R.id.rbPrioridade);

        Button buttonOK = (Button) findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nomeFilme = etNome.getText().toString();
                final String genero = etGenero.getText().toString();
                final String comentario = etComentario.getText().toString();
                final int paginas = Integer.parseInt(etPaginas.getText().toString());
                final float prioridade = rbPrioridade.getRating();

                BancoController b1 = new BancoController(AdicionaFilmesActivity.this);

                b1.inserirFilme(nomeFilme, genero, comentario, paginas, prioridade);

                finish();
            }
        });

    }
}
