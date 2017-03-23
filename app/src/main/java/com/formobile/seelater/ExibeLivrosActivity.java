package com.formobile.seelater;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ExibeLivrosActivity extends AppCompatActivity {

    ListView Lista_livros;
    ListAdapter adapterLivros;
    BancoController bc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_livros);
        Lista_livros = (ListView) findViewById(R.id.ListaLivros);

        bc = new BancoController(this);

        atualizaLivros(this);
    }

    public void atualizaLivros (Context contexto) {
        String[] dados = bc.getLivroIds();
        adapterLivros = new CustomAdapterLivros(this, dados);
        Lista_livros.setAdapter(adapterLivros);
    }
}
