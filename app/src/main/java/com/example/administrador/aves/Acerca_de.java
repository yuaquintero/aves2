package com.example.administrador.aves;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Esta clase despliega en pantalla la informacoón referente a los creditos de la aplicación
 *
 */



public class Acerca_de extends AppCompatActivity {


    ImageButton anterior;
    ImageButton enlace;
    ImageButton siguiente;
    ImageView imagenes;
    String link="http://www.ideasparaelcambio.gov.co/";

    int total;
    int i=0;

    int[]fotoid={R.drawable.cambio,R.drawable.colciencias,R.drawable.enlace,R.drawable.fes,R.drawable.sennova,R.drawable.sena};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);


        anterior=(ImageButton) findViewById(R.id.credits1);
        siguiente=(ImageButton) findViewById(R.id.credits2);
        enlace=(ImageButton) findViewById(R.id.botonenlace);
        imagenes=(ImageView)findViewById(R.id.imagenacercade);
        total=fotoid.length;


        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i--;
                if (i == -1) {
                    i = total - 1;
                }
                imagenes.setImageResource(fotoid[i]);
                switch((i)){
                    case 0:
                        link="http://www.ideasparaelcambio.gov.co/";
                        break;
                    case 1:
                        link="http://www.colciencias.gov.co/";
                        break;
                    case 2:
                        link="http://corporacionenlace.org/";
                        break;
                    case 3:
                        link="http://fundacionfes.org/sitio/";
                        break;
                    case 4:
                        link="http://sites.google.com/site/sennovacomercio/segundo-simposio-formacion-con-calidad-y-pertinencia";
                        break;
                    case 5:
                        link="http://www.sena.edu.co/es-co/Paginas/default.aspx";
                        break;
                    default:
                        link="http://www.sena.edu.co/es-co/Paginas/default.aspx";
                        break;
                }
            }
        });


        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i++;
                if (i == total) {
                    i = 0;
                }
                imagenes.setImageResource(fotoid[i]);
                switch((i)){
                    case 0:
                        link="http://www.ideasparaelcambio.gov.co/";
                        break;
                    case 1:
                        link="http://www.colciencias.gov.co/";
                        break;
                    case 2:
                        link="http://corporacionenlace.org/";
                        break;
                    case 3:
                        link="http://fundacionfes.org/sitio/";
                        break;
                    case 4:
                        link="http://sites.google.com/site/sennovacomercio/segundo-simposio-formacion-con-calidad-y-pertinencia";
                        break;
                    case 5:
                        link="http://www.sena.edu.co/es-co/Paginas/default.aspx";
                        break;
                    default:
                        link="http://www.sena.edu.co/es-co/Paginas/default.aspx";
                        break;
                }
            }
        });


        enlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse(link));
                startActivity(myWebLink);
            }
        });


    }
}
