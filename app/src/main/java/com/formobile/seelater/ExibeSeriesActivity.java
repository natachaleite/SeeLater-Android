package com.formobile.seelater;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ExibeSeriesActivity extends AppCompatActivity {

    ListView Lista_Series;
    ListAdapter adapterSeries;
    BancoController bc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibe_series);

        Lista_Series = (ListView) findViewById(R.id.ListaSeries);

        bc = new BancoController(this);

        atualizaSeries(this);
    }

    public void atualizaSeries (Context contexto) {
        String[] dados = bc.getSeriesIds();
        adapterSeries = new CustomAdapterSeries(this, dados);
        Lista_Series.setAdapter(adapterSeries);
    }
}
