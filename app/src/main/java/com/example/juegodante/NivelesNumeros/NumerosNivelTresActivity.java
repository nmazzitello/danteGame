package com.example.juegodante.NivelesNumeros;

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

public class NumerosNivelTresActivity extends AppCompatActivity {
    TextView corr, inco;
    ImageView imagen1, imagen2, imagen3, imagen4;
    CardView cv1, cv2, cv3, cv4;

    int opcion, r, countCo=20, countInco, bandera=0, ale1, ale2, ale3,ale4;
    private Handler hh= new Handler();
    String [] auto= {"autouno", "autodos", "autotres", "autocuatro", "autocinco", "autoseis", "autosiete", "autoocho", "autonueve", "autodiez"};
    MediaPlayer mpMal, mpBien,  mpNumeroUno, mpNumeroDos, mpNumeroTres, mpNumeroCuatro, mpNumeroCinco, mpNumeroSeis, mpNumeroSiete, mpNumeroOcho, mpNumeroNueve, mpNumeroDiez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros_nivel_tres);

        setTitle("Números- Nivel 3");

        corr=(TextView)findViewById(R.id.tevi1_5);
        inco=(TextView)findViewById(R.id.tevi2_5);
        imagen1=(ImageView)findViewById(R.id.iv1_5);
        imagen2=(ImageView)findViewById(R.id.iv2_5);
        imagen3=(ImageView)findViewById(R.id.iv3_5);
        imagen4=(ImageView)findViewById(R.id.iv4_5);
        cv1=(CardView)findViewById(R.id.cv1_5);
        cv2=(CardView)findViewById(R.id.cv2_5);
        cv3=(CardView)findViewById(R.id.cv3_5);
        cv4=(CardView)findViewById(R.id.cv4_5);

        Bundle param= getIntent().getExtras();
        countInco=param.getInt("incorrectas");
        inco.setText("NO TAN CORRECTAS: "+ countInco);

        mpMal= MediaPlayer.create(this, R.raw.bad);
        mpBien=MediaPlayer.create(this, R.raw.wonderful);
        mpNumeroUno= MediaPlayer.create(this, R.raw.numerouno);
        mpNumeroDos= MediaPlayer.create(this, R.raw.numerodos);
        mpNumeroTres= MediaPlayer.create(this, R.raw.numerotres);
        mpNumeroCuatro= MediaPlayer.create(this, R.raw.numerocuatro);
        mpNumeroCinco= MediaPlayer.create(this, R.raw.numerocinco);
        mpNumeroSeis= MediaPlayer.create(this, R.raw.numeroseis);
        mpNumeroSiete= MediaPlayer.create(this, R.raw.numerosiete);
        mpNumeroOcho= MediaPlayer.create(this, R.raw.numeroocho);
        mpNumeroNueve= MediaPlayer.create(this, R.raw.numeronueve);
        mpNumeroDiez= MediaPlayer.create(this, R.raw.numerodiez);

        r=AutoAleatorio();
    }

    public int AutoAleatorio ()
    {
        bandera= (int)(Math.random()*4);

        ale1 = (int) (Math.random() * 10);
        ale2 = (int) (Math.random() * 10);
        ale3 = (int) (Math.random() * 10);
        ale4 = (int) (Math.random() * 10);

        while (Validacion(ale1, ale2, ale3, ale4)==false)
        {
            ale2 = (int) (Math.random() * 10);
            ale3 = (int) (Math.random() * 10);
            ale4 = (int) (Math.random() * 10);
        }

        cv1.setCardBackgroundColor(Color.WHITE);
        cv2.setCardBackgroundColor(Color.WHITE);
        cv3.setCardBackgroundColor(Color.WHITE);
        cv4.setCardBackgroundColor(Color.WHITE);

//        if (bandera==0)
//    {
//        ale1=bandera;
//        ale2 = (int) (Math.random() * 10);
//        ale3 = (int) (Math.random() * 10);
//        ale4 = (int) (Math.random() * 10);
//
//        while(Validacion(ale1, ale2, ale3, ale4)==false)
//        {
//            ale2 = (int) (Math.random() * 10);
//            ale3 = (int) (Math.random() * 10);
//            ale4 = (int) (Math.random() * 10);
//        }
//    }
//        if (bandera==1)
//        {
//            ale2=bandera;
//            ale1 = (int) (Math.random() * 10);
//            ale3 = (int) (Math.random() * 10);
//            ale4 = (int) (Math.random() * 10);
//
//            while(Validacion(ale1, ale2, ale3, ale4)==false)
//            {
//                ale1 = (int) (Math.random() * 10);
//                ale3 = (int) (Math.random() * 10);
//                ale4 = (int) (Math.random() * 10);
//            }
//        }
//        if(bandera==2)
//        {
//            ale3=bandera;
//            ale1 = (int) (Math.random() * 10);
//            ale2 = (int) (Math.random() * 10);
//            ale4 = (int) (Math.random() * 10);
//
//            while(Validacion(ale1, ale2, ale3, ale4)==false)
//            {
//                ale1 = (int) (Math.random() * 10);
//                ale2 = (int) (Math.random() * 10);
//                ale4 = (int) (Math.random() * 10);
//            }
//        }
//        if(bandera==3)
//        {
//            ale4=bandera;
//            ale1 = (int) (Math.random() * 10);
//            ale2 = (int) (Math.random() * 10);
//            ale3 = (int) (Math.random() * 10);
//
//            while(Validacion(ale1, ale2, ale3, ale4)==false)
//            {
//                ale1 = (int) (Math.random() * 10);
//                ale2 = (int) (Math.random() * 10);
//                ale3 = (int) (Math.random() * 10);
//            }
//        }

        for (int i = 0; i < auto.length; i++) {
            int id = getResources().getIdentifier(auto[i], "drawable", getPackageName());

            if (ale1 == i) {
                imagen1.setImageResource(id);
                if (bandera == 0) {
                    reproducir(ale1);
                }
            } else if (ale2 == i) {
                imagen2.setImageResource(id);
                if (bandera == 1) {
                    reproducir(ale2);
                }
            } else if (ale3 == i) {
                imagen3.setImageResource(id);
                if (bandera == 2) {
                    reproducir(ale3);
                }
            } else if (ale4 == i) {
                imagen4.setImageResource(id);
                if (bandera == 3) {
                    reproducir(ale4);
                }
            }
        }
        return bandera;
    }

    public boolean Validacion(int n1, int n2, int n3, int n4)
    {
        if(n1==n2)
        {
            return false;
        }
        if(n1==n3)
        {
            return false;
        }
        if(n1==n4)
        {
            return false;
        }
        if(n2==n3)
        {
            return false;
        }
        if(n2==n4)
        {
            return false;
        }
        if(n3==n4)
        {
            return false;
        }
        return true;
    }

    public void click6(View v)
    {
        switch (v.getId())
        {
            case R.id.iv1_5:
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

            case R.id.iv2_5:
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

            case R.id.iv3_5:
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

            case R.id.iv4_5:
                opcion=3;

                if(r==opcion)
                {
                    countCo++;
                    corr.setText("CORRECTAS: " + countCo);
                    cv4.setCardBackgroundColor(Color.GREEN);
                    mpBien.start();
                }
                else
                {
                    countInco++;
                    inco.setText("NO TAN CORRECTAS: "+ countInco);
                    cv4.setCardBackgroundColor(Color.RED);
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
                r=AutoAleatorio();
            }
        }, 1000);
    }

    public void reproducir(int np)
    {
        if(np==0)
        {
            mpNumeroUno.start();
        }
        if(np==1)
        {
            mpNumeroDos.start();
        }
        if(np==2)
        {
            mpNumeroTres.start();
        }
        if(np==3)
        {
            mpNumeroCuatro.start();
        }
        if(np==4)
        {
            mpNumeroCinco.start();
        }
        if(np==5)
        {
            mpNumeroSeis.start();
        }
        if(np==6)
        {
            mpNumeroSiete.start();
        }
        if(np==7)
        {
            mpNumeroOcho.start();
        }
        if(np==8)
        {
            mpNumeroNueve.start();
        }
        if(np==9){
            mpNumeroDiez.start();
        }
    }
}
