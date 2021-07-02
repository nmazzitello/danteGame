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

public class ColoresNivelDosActivity extends AppCompatActivity {
    ImageView imagen1, imagen2, imagen3;
    CardView cv1, cv2, cv3;
    TextView corr, inco;

    MediaPlayer  mpBien, mpMal,mpPelotaAzul, mpPelotaAmarilla, mpPelotaRoja, mpPelotaVerde, mpPelotaNaranja, mpPelotaCeleste, mpPelotaRosa, mpPelotaVioleta;
    int alea1, alea2, alea3, countCo=10, countInco, bandera=0;
    String [] pelota= {"pelotaamarilla","pelotaazul", "pelotaceleste", "pelotanaranja", "pelotaroja", "pelotarosa", "pelotaverde", "pelotavioleta"};
    int opcion, r;
    private Handler hh= new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores_nivel_dos);

        setTitle("Colores- Nivel 2");

        imagen1=(ImageView)findViewById(R.id.iv1_1);
        imagen2=(ImageView)findViewById(R.id.iv2_1);
        imagen3=(ImageView)findViewById(R.id.iv3_1);
        cv1=(CardView)findViewById(R.id.cv1_1);
        cv2=(CardView)findViewById(R.id.cv2_1);
        cv3=(CardView)findViewById(R.id.cv3_1);
        corr=(TextView)findViewById(R.id.tevi1_1);
        inco=(TextView)findViewById(R.id.tevi2_1);

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

        Bundle param= getIntent().getExtras();
        countInco= param.getInt("incorrectas");
        inco.setText("NO TAN CORRECTAS: "+ countInco);

        r= ColorAleatorio();
    }

    //evento de seleccion de elemento
    public void click2(View v)
    {
        switch (v.getId())
        {
            case R.id.iv1_1:
                opcion=0;

                if(r==opcion)
                {
                    countCo ++;
                    corr.setText("CORRECTAS: " + countCo);
                    cv1.setCardBackgroundColor(Color.GREEN);
                    mpBien.start();
                }
                else
                {
                    countInco++;
                    inco.setText("NO TAN CORRECTAS: "+ countInco);
                    cv1.setCardBackgroundColor(Color.RED);
                    mpMal.start();
                }
                break;

            case R.id.iv2_1:
                opcion=1;

                if(r==opcion)
                {
                    countCo++;
                    corr.setText("CORRECTAS: " + countCo);
                    cv2.setCardBackgroundColor(Color.GREEN);
                    mpBien.start();
                }
                else
                {
                    countInco++;
                    inco.setText("NO TAN CORRECTAS: "+ countInco);
                    cv2.setCardBackgroundColor(Color.RED);
                    mpMal.start();
                }
                break;

            case R.id.iv3_1:
                opcion=2;

                if(r==opcion)
                {
                    countCo++;
                    corr.setText("CORRECTAS: " + countCo);
                    cv3.setCardBackgroundColor(Color.GREEN);
                    mpBien.start();
                }
                else
                {
                    countInco++;
                    inco.setText("NO TAN CORRECTAS: "+ countInco);
                    cv3.setCardBackgroundColor(Color.RED);
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

    //metodo para que varie aleatoriamente el color de las pelotas -->
    public int ColorAleatorio ()
    {
        cv1.setCardBackgroundColor(Color.WHITE);
        cv2.setCardBackgroundColor(Color.WHITE);
        cv3.setCardBackgroundColor(Color.WHITE);

        bandera= (int)(Math.random()*3);
        alea1 = (int) (Math.random() * 8);
        alea2 = (int) (Math.random() * 8);
        alea3 = (int) (Math.random() * 8);

        while(Validacion(alea1, alea2, alea3)==false)
        {
            alea1 = (int) (Math.random() * 8);
            alea2 = (int) (Math.random() * 8);
            alea3 = (int) (Math.random() * 8);
        }

        if (countCo <20)
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
                }else if (alea2 == i)
                {
                    imagen2.setImageResource(id);
                    if (bandera==1)
                    {
                        reproducir(alea2);
                    }
                }else if(alea3==i)
                {
                    imagen3.setImageResource(id);
                    if(bandera==2)
                    {
                        reproducir(alea3);
                    }
                }
            }
            return bandera;
        }
        else
        {
            Intent i= new Intent(this, ColoresNivelTresActivity.class);
            i.putExtra("incorrectas", countInco);
            startActivity(i);
            finish();
            return 3;
        }
    }

    //metodo para validar que los numeros aleatorios sean distinto entre si --> 100%
    public boolean Validacion(int n1, int n2, int n3)
    {
        if(n1==n2)
        {
            return false;
        }
        if(n1==n3)
        {
            return false;
        }
        if(n2==n3)
        {
            return false;
        }
        return true;
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

    //sobreesrcibir la opcion back para que vuelva al menu principal -->100%
    @Override
    public void onBackPressed()
    {
        Intent i= new Intent (this, OpcionesActivity.class);
        startActivity(i);
        finish();
    }
}
