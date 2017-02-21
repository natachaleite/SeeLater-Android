package com.formobile.seelater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private static final String CATEGORIA = "Script";
    Button b1;

    //CICLO DE VIDA
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(CATEGORIA, getClassName()+".onCreate();");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(CATEGORIA, getClassName()+".onStart();");
    }

    @Override
    public void onRestart() {
        super.onStart();
        Log.i(CATEGORIA, getClassName()+".onRestart();");
    }

    @Override
    public void onResume() {
        super.onStart();
        Log.i(CATEGORIA, getClassName()+".onResume();");
    }

    @Override
    public void onPause() {
        super.onStart();
        Log.i(CATEGORIA, getClassName()+".onPause();");
    }

    @Override
    public void onStop() {
        super.onStart();
        Log.i(CATEGORIA, getClassName()+".onStop();");
    }

    @Override
    public void onDestroy() {
        super.onStart();
        Log.i(CATEGORIA, getClassName()+".onDestroy();");
    }
    //CICLO DE VIDA

    private String getClassName() {
        String aux = getClass().getName();
        return(aux.substring(aux.lastIndexOf(".") +1));
    }

    public void startInicialActivity(View v) {
        Intent intent = new Intent(this, InicialActivity.class);
        startActivity(intent);
    }

    public void startSecondActivity (View view) {
        Intent secondActivity = new Intent(this, InicialActivity.class);
        startActivity(secondActivity);
    }

}
