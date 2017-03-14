package com.formobile.seelater;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by group on 26/03/2016.
 */
public class CustomAdapterLivros extends ArrayAdapter<String> {

    Context contexto;
    String[] IDs;
    View customView;

    CustomAdapterLivros(Context context, String[] datas) {
        super(context, R.layout.default_livros, datas);
        contexto = context;
        IDs = datas;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        customView = inflater.inflate(R.layout.default_livros, parent, false);

        final BancoController bc = new BancoController(contexto);
        final Cursor c = bc.getLivroSimples(Integer.parseInt(IDs[position]));

        final RelativeLayout r1 = (RelativeLayout)customView.findViewById(R.id.linha);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contexto,"Cliquei",Toast.LENGTH_LONG).show();

                Cursor cursor = bc.getLivroCompleto(Integer.parseInt(IDs[position]));
                String textodialogo = "Nome: "+cursor.getString(cursor.getColumnIndex(CriaBanco.NOME_LIVRO))+" \n" +
                        "Autor: "+cursor.getString(cursor.getColumnIndex(CriaBanco.NOME_AUTOR))+" \n" +
                        "Gênero: "+cursor.getString(cursor.getColumnIndex(CriaBanco.GENERO))+" \n" +
                        "Comentário: "+cursor.getString(cursor.getColumnIndex(CriaBanco.COMENTARIO))+" \n" +
                        "Páginas: "+cursor.getInt(cursor.getColumnIndex(CriaBanco.PAGINAS))+" \n" +
                        "Classificação: "+cursor.getFloat(cursor.getColumnIndex(CriaBanco.CLASSIFICACAO))+" \n";

                AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
                builder.setMessage(textodialogo)
                        .setPositiveButton("Editar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // FIRE ZE MISSILES!
                                Toast.makeText(contexto,"Editei",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("Excluir", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                bc.deletaItem(CriaBanco.LIVRO, Integer.parseInt(IDs[position]));
                                ((ViewGroup)r1.getParent()).removeView(r1);
                                Toast.makeText(contexto,"Excluído com sucesso!",Toast.LENGTH_LONG).show();
                                //customView = null;
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and return it
                AlertDialog a = builder.create();
                a.show();
            }
        });

        TextView nomeLivro = (TextView)customView.findViewById(R.id.nomeLivro);
        TextView autorLivro = (TextView)customView.findViewById(R.id.autorLivro);

        nomeLivro.setText(c.getString(c.getColumnIndex(CriaBanco.NOME_LIVRO)));
        autorLivro.setText(c.getString(c.getColumnIndex(CriaBanco.NOME_AUTOR)));

        RatingBar a = (RatingBar)customView.findViewById(R.id.ratingLivro);
        a.setNumStars(c.getInt(c.getColumnIndex(CriaBanco.CLASSIFICACAO)));

        return customView;
    }
}
