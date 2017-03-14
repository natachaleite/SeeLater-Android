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
 * Created by group on 09/03/2017.
 */

public class CustomAdapterFilmes extends ArrayAdapter<String> {


    Context contexto;
    String[] IDs;
    View customView;

    CustomAdapterFilmes(Context context, String[] datas) {
        super(context, R.layout.default_filmes, datas);
        contexto = context;
        IDs = datas;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        customView = inflater.inflate(R.layout.default_filmes, parent, false);

        final BancoController bc = new BancoController(contexto);
        final Cursor c = bc.getFilmeSimples(Integer.parseInt(IDs[position]));

        final RelativeLayout r1 = (RelativeLayout)customView.findViewById(R.id.linhaFilme);

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contexto,"Cliquei",Toast.LENGTH_LONG).show();

                Cursor cursor = bc.getFilmeCompleto(Integer.parseInt(IDs[position]));
                String textodialogo = "Nome: "+cursor.getString(cursor.getColumnIndex(CriaBanco.NOME_FILME))+" \n" +
                        "Gênero: "+cursor.getString(cursor.getColumnIndex(CriaBanco.GENERO))+" \n" +
                        "Comentário: "+cursor.getString(cursor.getColumnIndex(CriaBanco.COMENTARIO))+" \n" +
                        "Ano de Lançamento: "+cursor.getInt(cursor.getColumnIndex(CriaBanco.ANO))+" \n" +
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
                                bc.deletaItem(CriaBanco.FILME, Integer.parseInt(IDs[position]));
                                ((ViewGroup)r1.getParent()).removeView(r1);
                                Toast.makeText(contexto,"Excluído com sucesso!",Toast.LENGTH_LONG).show();
                                // User cancelled the dialog
                            }
                        });
                // Create the AlertDialog object and return it
                AlertDialog a = builder.create();
                a.show();
            }
        });

        TextView nomeFilme = (TextView)customView.findViewById(R.id.nomeFilme);
        TextView anoLancamento = (TextView)customView.findViewById(R.id.anoFilme);

        nomeFilme.setText(c.getString(c.getColumnIndex(CriaBanco.NOME_FILME)));
        anoLancamento.setText(c.getString(c.getColumnIndex(CriaBanco.ANO)));

        RatingBar a = (RatingBar)customView.findViewById(R.id.ratingFilme);
        a.setNumStars(c.getInt(c.getColumnIndex(CriaBanco.CLASSIFICACAO)));

        return customView;
    }

}
