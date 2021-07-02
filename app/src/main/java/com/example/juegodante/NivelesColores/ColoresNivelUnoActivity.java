package com.example.juegodante.NivelesColores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juegodante.Activities.OpcionesActivity;
import com.example.juegodante.R;

public class ColoresNivelUnoActivity extends AppCompatActivity {
    ImageView imagen1, imagen2;
    TextView tvCorrecta, tvIncorrecta;
    CardView cv1, cv2;

    int alea1, alea2, countCo=0, countInco=0, bandera=0;
    String [] pelota= {"pelotaamarilla","pelotaazul", "pelotaceleste", "pelotanaranja", "pelotaroja", "pelotarosa", "pelotaverde", "pelotavioleta"};
    int opcion, r;
    MediaPlayer mpBien, mpMal,mpPelotaAzul, mpPelotaAmarilla, mpPelotaRoja, mpPelotaVerde, mpPelotaNaranja, mpPelotaCeleste, mpPelotaRosa, mpPelotaVioleta;
    private Handler hh= new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores_nivel_uno);
        imagen1=(ImageView)findViewById(R.id.iv1);
        imagen2=(ImageView)findViewById(R.id.iv2);
        cv1=(CardView)findViewById(R.id.cardview1);
        cv2=(CardView)findViewById(R.id.cardview2);
        tvCorrecta=(TextView)findViewById(R.id.tv1);
        tvIncorrecta=(TextView) findViewById(R.id.tv2);

        mpMal=MediaPlayer.create(this, R.raw.bad);
        mpBien=MediaPlayer.create(this, R.raw.wonderful);
        mpPelotaAzul=MediaPlayer.create(this, R.raw.pelotaazul);
        mpPelotaAmarilla=MediaPlayer.create(this, R.raw.pelotaamarilla);
        mpPelotaRoja=MediaPlayer.create(this, R.raw.pelotaroja);
        mpPelotaRosa=MediaPlayer.create(this, R.raw.pelotarosa);
        mpPelotaVerde=MediaPlayer.create(this, R.raw.pelotaverde);
        mpPelotaVioleta=MediaPlayer.create(this, R.raw.pelotavioleta);
        mpPelotaNaranja=MediaPlayer.create(this, R.raw.pelotanaranja);
        mpPelotaCeleste=MediaPlayer.create(this, R.raw.pelotaceleste);

        setTitle("Colores- Nivel 1");

        r= ColorAleatorio();
    }

    //metodo para que varie aleatoriamente el color de las pelotas -->
    public int ColorAleatorio ()
    {
        bandera= (int)(Math.random()*2);
        alea1 = (int) (Math.random() * 8);
        alea2 = (int) (Math.random() * 8);

        while (alea1 == alea2)
        {
            alea2 = (int) (Math.random() * 8);
        }
        
        cv1.setCardBackgroundColor(Color.WHITE);
        cv2.setCardBackgroundColor(Color.WHITE);

        if (countCo <10) //poner 9
        {
            for (int i = 0; i < pelota.length; i++)
            {
                int id = getResources().getIdentifier(pelota[i], "drawable", getPackageName());

                if (alea1 == i)
                {
                    imagen1.setImageResource(id);
                    if(bandera==0)
                    {
                        reproducir(alea1);
                    }
                } else if (alea2 == i )
                {
                    imagen2.setImageResource(id);
                    if (bandera==1)
                    {
                        reproducir(alea2);
                    }
                }
            }
            return bandera;
        }
        else
        {
            Intent i= new Intent(this, ColoresNivelDosActivity.class);
            i.putExtra("incorrectas", countInco);
            startActivity(i);
            finish();
            return 5;
        }
    }

    //evento de seleccion de elemento --> 100%
    public void clickk(View v)
    {
        switch (v.getId())
        {
            case R.id.iv1:
                opcion=0;

                if(r==opcion)
                {
                    countCo ++;
                    tvCorrecta.setText("CORRECTAS: " + countCo);
                    cv1.setCardBackgroundColor(Color.GREEN);
                    mpBien.start();
                }
                else
                {
                    countInco++;
                    tvIncorrecta.setText("NO TAN CORRECTAS: "+ countInco);
                    cv1.setCardBackgroundColor(Color.RED);
                    mpMal.start();
                }
                break;

            case R.id.iv2:
                opcion=1;

                if(r==opcion)
                {
                    countCo++;
                    tvCorrecta.setText("CORRECTAS: " + countCo);
                    cv2.setCardBackgroundColor(Color.GREEN);
                    mpBien.start();
                }
                else
                {
                    countInco++;
                    tvIncorrecta.setText("NO TAN CORRECTAS: "+ countInco);
                    cv2.setCardBackgroundColor(Color.RED);
                    mpMal.start();
                }
                break;

                default:
                    break;
        }

        hh.postDelayed(new Runnable()// para que demore 1 segundo en ejecutar el metodo ColorAleatorio nuevamente
        {
            @Override
            public void run()
            {
                r=ColorAleatorio();
            }
        }, 1000);
    }

    //metodo para que reproduzca el sonido segun el color --> 100%
    public void reproducir(int np)
    {
        if(np==0)
        {
            mpPelotaAmarilla.start();
        }
        if(np==1)
        {
            mpPelotaAzul.start();
        }
        if(np==2)
        {
            mpPelotaCeleste.start();
        }
        if(np==3)
        {
            mpPelotaNaranja.start();
        }
        if(np==4)
        {
            mpPelotaRoja.start();
        }
        if(np==5)
        {
            mpPelotaRosa.start();
        }
        if(np==6)
        {
            mpPelotaVerde.start();
        }
        if(np==7)
        {
            mpPelotaVioleta.start();
        }
    }

    //sobreescribir el boton para atras, para que vuelva al principio --> 100%
    @Override
    public void onBackPressed()
    {
        Intent i= new Intent(ColoresNivelUnoActivity.this, OpcionesActivity.class);
        startActivity(i);
        finish();
    }
}
