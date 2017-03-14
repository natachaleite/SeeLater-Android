package com.formobile.seelater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import static java.lang.Boolean.TRUE;

public class AdicionaLivrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_livros);

        final EditText etNome = (EditText) findViewById(R.id.etNomeLivro);
        final EditText etAutor = (EditText) findViewById(R.id.etAutorLivro);
        final EditText etGenero = (EditText) findViewById(R.id.etGeneroLivro);
        final EditText etComentario = (EditText) findViewById(R.id.etComentarioLivro);
        final EditText etPaginas = (EditText) findViewById(R.id.etQtdePaginas);
        final RatingBar rbPrioridade = (RatingBar) findViewById(R.id.rbPrioridade);

        Button buttonOK = (Button) findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nomeLivro = etNome.getText().toString();
                final String autor = etAutor.getText().toString();
                final String genero = etGenero.getText().toString();
                final String comentario = etComentario.getText().toString();
                final int paginas = Integer.parseInt(etPaginas.getText().toString());
                final float prioridade = rbPrioridade.getRating();

                BancoController b1 = new BancoController(AdicionaLivrosActivity.this);

                b1.inserirLivro(nomeLivro, autor, genero, comentario, paginas, prioridade);

                finish();
            }
        });

    }

    @Override
    public void onStart() { super.onStart(); }


    @Override
    public void onStop() { super.onStop(); }

}

