package com.formobile.seelater;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        Intent intent = getIntent();

        final EditText etNome = (EditText) findViewById(R.id.etNomeLivro);
        final EditText etAutor = (EditText) findViewById(R.id.etAutorLivro);
        final EditText etGenero = (EditText) findViewById(R.id.etGeneroLivro);
        final EditText etComentario = (EditText) findViewById(R.id.etComentarioLivro);
        final EditText etPaginas = (EditText) findViewById(R.id.etQtdePaginas);
        final RatingBar rbPrioridade = (RatingBar) findViewById(R.id.rbPrioridade);

        final BancoController b1 = new BancoController(AdicionaLivrosActivity.this);

        final int tela = intent.getExtras().getInt("tela");
        //Tela para editar
        int id = -1;
        if (tela == 1) {
            id = Integer.parseInt(intent.getExtras().getString("id"));
            Log.d("ID", id + "");
            Cursor cursor = b1.getLivroCompleto(id);

            etNome.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.NOME_LIVRO)));
            etAutor.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.NOME_AUTOR)));
            etGenero.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.GENERO)));
            etComentario.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.COMENTARIO)));
            etPaginas.setText(cursor.getString(cursor.getColumnIndex(CriaBanco.PAGINAS)));
            rbPrioridade.setRating(cursor.getInt(cursor.getColumnIndex(CriaBanco.CLASSIFICACAO)));
        }

        Button buttonOK = (Button) findViewById(R.id.buttonOK);
        final int finalId = id;
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

                if(tela == 1) {
                    b1.editarLivro(nomeLivro, autor, genero, comentario, paginas, prioridade, finalId);
                    //atualizaLivros(this);
                }else
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

