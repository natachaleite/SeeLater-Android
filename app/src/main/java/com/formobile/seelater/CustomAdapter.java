package com.formobile.seelater;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ivan on 26/03/2016.
 */
public class CustomAdapter extends ArrayAdapter<String> {

    Context contexto;
    String[] IDs;
    View customView;

    CustomAdapter(Context context, String[] datas) {
        super(context, R.layout.default_livros, datas);
        contexto = context;
        IDs = datas;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        customView = inflater.inflate(R.layout.default_livros, parent, false);

        BancoController bc = new BancoController(contexto);

        Cursor c = bc.getLivroSimples(Integer.parseInt(IDs[position]));

        TextView nomeLivro = (TextView)customView.findViewById(R.id.nomeLivro);
        TextView autorLivro = (TextView)customView.findViewById(R.id.autorLivro);

        nomeLivro.setText(c.getString(c.getColumnIndex(CriaBanco.NOME_LIVRO)));
        autorLivro.setText(c.getString(c.getColumnIndex(CriaBanco.NOME_AUTOR)));

        RatingBar a = (RatingBar)customView.findViewById(R.id.ratingLivro);
        a.setNumStars(c.getInt(c.getColumnIndex(CriaBanco.CLASSIFICACAO)));

        return customView;
    }
}
