package com.formobile.seelater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Tela3Livros extends AppCompatActivity {

    ListView Lista_livros;
    ListAdapter adapterLivros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3_livros);
        Lista_livros = (ListView) findViewById(R.id.ListaLivros);
        BancoController bc = new BancoController(this);
//        bc.inserirLivro("Faça Acontecer","Sheryl Sandeberg", "Terror", "Ótimo Livro!", 2, 5);
//        bc.inserirLivro("Piadinhas do Psico","Psico Garcia", "Comédia", "Péssimo Livro!", 900, 1);

        String[] dados = bc.getLivroIds();

        adapterLivros = new CustomAdapter(this, dados);
        Lista_livros.setAdapter(adapterLivros);
    }
}
