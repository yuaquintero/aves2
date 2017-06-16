package com.example.administrador.aves;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.DecimalFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;

/**
 * Created by sennova on 15/06/2017.
 */

public class Ruta_info extends AppCompatActivity {

    private TextView Tvnombre;
    private TextView Tvlong;
    ImageView ivRuta;
    Rutas_constructor miRuta;
    private View miLayout;
    private View otherLayout;

    private DecimalFormat df;
    int sel;
    public Ruta_info() {

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.ruta_info);

        Bundle extras = getIntent().getExtras();
        int id = extras.getInt("id", -1);
        sel=id;
        miRuta=Rutas.rutas.get(id);
        miLayout = findViewById(R.id.lyutas);*/


        setContentView(R.layout.info_ruta);

        Bundle extras = getIntent().getExtras();
        int id = extras.getInt("id", -1);
        sel=id;
        miRuta=Rutas.rutas.get(id);
        miLayout = findViewById(R.id.layout_ruta);
        otherLayout=findViewById(R.id.lam_ruta);
        ivRuta=(ImageView) findViewById(R.id.image_ruta);
        Tvnombre = (TextView) findViewById(R.id.n_ruta);
        Tvlong = (TextView) findViewById(R.id.londitud_ruta);

        //Tvnombre = (TextView) findViewById(R.id.tvnombreruta);


        Tvnombre.setText( miRuta.getNombre());

       // Tvlong = (TextView) findViewById(R.id.tvlongitud);


        Tvlong.setText( miRuta.getLongitud());

        switch (sel)
        {
            case 0:   //miLayout.setBackgroundResource(R.drawable.ruta1);
                     // ivRuta.setImageResource(R.drawable.ruta1);
                      otherLayout.setBackgroundResource(R.drawable.ruta1);
            break;

            case 1:   //miLayout.setBackgroundResource(R.drawable.ruta2);
                     // ivRuta.setImageResource(R.drawable.ruta2);
                      otherLayout.setBackgroundResource(R.drawable.ruta2);
                break;

            case 2:  // miLayout.setBackgroundResource(R.drawable.ruta3);
                     //ivRuta.setImageResource(R.drawable.ruta3);
                     otherLayout.setBackgroundResource(R.drawable.ruta3);
                break;

            case 3:   //miLayout.setBackgroundResource(R.drawable.ruta4);
                      //ivRuta.setImageResource(R.drawable.ruta4);
                     otherLayout.setBackgroundResource(R.drawable.ruta4);

                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch ( item.getItemId() )
        {
            case R.id.boton_home:{
                Intent Home = new Intent(Ruta_info.this, Home.class);
                ActivityCompat.finishAffinity(this);
                startActivity(Home);
                Home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();

            }
            break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }




}
