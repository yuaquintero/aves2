package com.example.administrador.aves;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by sennova on 13/06/2017.
 */

public class Rutas extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    RecyclerView rv;
    public static List<Rutas_constructor> rutas;
    adaptadorRutas adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas);

        rv = (RecyclerView) findViewById(R.id.lista_rutas);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rutas = new ArrayList<>();

        initializeData();
        adapter= new adaptadorRutas(rutas);
        rv.setAdapter(adapter);


        adapter.notifyDataSetChanged();

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num =rv.getChildAdapterPosition(v);
               // String msg="se presionó  "+ Integer.toString(num);
               // Toast.makeText(Rutas.this,msg, Toast.LENGTH_SHORT).show();
                lanzarRuta(v,num);
            }
        });

    }

    public void  lanzarRuta(View view, int pos){
        Intent i = new Intent(this, Ruta_info.class);
        i.putExtra("id", pos);
        startActivity(i);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void initializeData(){

        rutas.add(new Rutas_constructor("La Herrera", "Ruta 1", "","3.914 Km"));
        rutas.add(new Rutas_constructor("La Salada", "Ruta 2", "","5.925 Km"));
        rutas.add(new Rutas_constructor("Verdun-Mesenia", "Ruta 3","", "24,62 Km"));
        rutas.add(new Rutas_constructor("Ventanas", "Ruta 4","", "19,75 Km"));
    }
}
