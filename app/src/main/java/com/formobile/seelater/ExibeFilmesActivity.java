package com.formobile.seelater;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ExibeFilmesActivity extends AppCompatActivity {

    ListView Lista_filmes;
    ListAdapter adapterFilmes;
    BancoController bc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_filmes);
        Lista_filmes = (ListView) findViewById(R.id.ListaFilmes);

        bc = new BancoController(this);

        atualizaFilmes(this);
    }

    public void atualizaFilmes (Context contexto) {
        String[] dados = bc.getFilmesIds();
        adapterFilmes = new CustomAdapterFilmes(this, dados);
        Lista_filmes.setAdapter(adapterFilmes);
    }
}
