package com.example.juegodante.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.juegodante.R;

public class OpcionesActivity extends AppCompatActivity {
    Button btnColores, btnNumeros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        btnColores=(Button)findViewById(R.id.btn1);
        btnNumeros=(Button)findViewById(R.id.btn2);
    }

    public void Opcion(View v)
    {
        Intent i, ii;

        switch (v.getId())
        {
            case R.id.btn1:

                i= new Intent(this, ColoresActivity.class);
                i.putExtra("titulo1", btnColores.getText());
                startActivity(i);
                finish();
                break;

            case R.id.btn2:
                ii= new Intent(this, NumerosActivity.class);
                ii.putExtra("titulo2", btnNumeros.getText());
                startActivity(ii);
                break;

            default:
                break;
        }
    }
    @Override
    public void onBackPressed()
    {
        finish();
    }
}
