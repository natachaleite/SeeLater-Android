package com.formobile.seelater;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

public class InicialActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String CATEGORIA = "Script";

    Button b1;
    TextView livros;
    TextView series;
    TextView filmes;

    BancoController bc;

    //CICLO DE VIDA
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        bc = new BancoController(this);

        int qtdeLivro = bc.getQtdeLivro();
        int qtdeSerie = bc.getQtdeSerie();
        int qtdeFilme = bc.getQtdeFilme();

        ((TextView)findViewById(R.id.txtNumLivros)).setText(qtdeLivro+"");
        ((TextView)findViewById(R.id.txtNumSeries)).setText(qtdeSerie+"");
        ((TextView)findViewById(R.id.txtNumFilmes)).setText(qtdeFilme+"");

        b1 = (Button)findViewById(R.id.btnCadastra);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(findViewById(R.id.menuLateral).getVisibility() == View.VISIBLE)
                    findViewById(R.id.menuLateral).setVisibility(View.INVISIBLE);
                else if(findViewById(R.id.menuLateral).getVisibility() == View.INVISIBLE)
                    findViewById(R.id.menuLateral).setVisibility(View.VISIBLE);
            }
        });


        findViewById(R.id.labelCadastraLivro).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), AdicionaLivrosActivity.class);
                i.putExtra("tela", 0);
                startActivity(i);
            }
        });
        livros = (TextView) findViewById(R.id.txtLivros);
        livros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ExibeLivrosActivity.class);
                i.putExtra("tela", 0);

                startActivity(i);
            }
        });

        findViewById(R.id.labelCadastraSerie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), AdicionaSeriesActivity.class);
                i.putExtra("tela", 0);
                startActivity(i);
            }
        });
        series = (TextView) findViewById(R.id.txtSeries);
        series.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ExibeSeriesActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.labelCadastraFilme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), AdicionaFilmesActivity.class);
                i.putExtra("tela", 0);
                startActivity(i);
            }
        });
        filmes = (TextView) findViewById(R.id.txtFilmes);
        filmes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), ExibeFilmesActivity.class);
                startActivity(i);
            }
        });

        Log.i(CATEGORIA, getClassName() + ".onCreate();");
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//
//        MenuItem m1 = menu.add(0, 0, 0, "Teste");
//        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
//
//        MenuItem m2 = menu.add(0, 1, 1, "Teste2");
//        //m2.setIcon(R.drawable.common_google_signin_btn_icon_dark);
//        m2.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
//
//        MenuItem m3 = menu.add(0, 2, 2, "Teste3");
//        m3.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
//
//
//        return (true);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(int panel, MenuItem item){
//        switch (item.getItemId()) {
//            case 0:
//                Toast.makeText(this, "Livro", Toast.LENGTH_SHORT);
//                break;
//            case 1:
//                Toast.makeText(this, "Filme", Toast.LENGTH_SHORT);
//                break;
//            case 2:
//                Toast.makeText(this, "Série", Toast.LENGTH_SHORT);
//                break;
//        }
//
//        return (true);
//    }

    public void onStart() {
        super.onStart();
        Log.i(CATEGORIA, getClassName() + ".onStart();");

    }

    public void onRestart() {
        super.onStart();
        Log.i(CATEGORIA, getClassName() + ".onRestart();");
    }

    public void onResume() {
        super.onStart();

        int qtdeLivro = bc.getQtdeLivro();
        int qtdeSerie = bc.getQtdeSerie();
        int qtdeFilme = bc.getQtdeFilme();

        ((TextView)findViewById(R.id.txtNumLivros)).setText(qtdeLivro+"");
        ((TextView)findViewById(R.id.txtNumSeries)).setText(qtdeSerie+"");
        ((TextView)findViewById(R.id.txtNumFilmes)).setText(qtdeFilme+"");

        Log.i(CATEGORIA, getClassName() + ".onResume();");

    }

    public void onPause() {
        super.onStart();
        Log.i(CATEGORIA, getClassName() + ".onPause();");
    }

    public void onStop() {
        super.onStart();
        Log.i(CATEGORIA, getClassName() + ".onStop();");
    }

    public void onDestroy() {
        super.onStart();
        Log.i(CATEGORIA, getClassName() + ".onDestroy();");
    }
    //CICLO DE VIDA

    private String getClassName() {
        String aux = getClass().getName();
        return (aux.substring(aux.lastIndexOf(".") + 1));
    }

    @Override
    public void onClick(View v) {

    }
}
