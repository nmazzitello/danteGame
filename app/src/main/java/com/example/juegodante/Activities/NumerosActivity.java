package com.example.juegodante.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.juegodante.NivelesColores.ColoresNivelUnoActivity;
import com.example.juegodante.NivelesNumeros.NumerosNivelUnoActivity;
import com.example.juegodante.R;

public class NumerosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros);

        Bundle param= getIntent().getExtras();
        String titulo= param.getString("titulo2");
        setTitle(titulo);
    }

    public void Continuar (View v)
    {
        Intent i;
        i= new Intent(this, NumerosNivelUnoActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed()
    {
        Intent i= new Intent(this, OpcionesActivity.class);
        startActivity(i);
        finish();
    }
}
