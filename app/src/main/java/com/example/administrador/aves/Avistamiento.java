package com.example.administrador.aves;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Avistamiento extends AppCompatActivity  {

    Button bFiltrar;
    String colorPrimario, colorSecundario, formaAve, formaPico;
    ImageView ivCriterio1, ivCriterio2, ivCriterio4, ivCriterio5 ;
    LinearLayout formitas,piquitos,colorsitos;
    Spinner sCriterio5, sCriterio4, sCriterio1, sCriterio2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avistamiento);

        ivCriterio1=(ImageView) findViewById(R.id.ivColor1);
        sCriterio1=(Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapterSpinner1 = ArrayAdapter.createFromResource(this,R.array.ColorPrincipal, android.R.layout.simple_spinner_item);
        adapterSpinner1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sCriterio1.setAdapter(adapterSpinner1);
        sCriterio1.setOnItemSelectedListener(
                new OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0){
                            ivCriterio1.setImageResource(R.drawable.colorful);
                            colorPrimario="0";
                        }else if (position == 1){
                            ivCriterio1.setImageResource(R.drawable.color_amarillo);
                            colorPrimario="1";
                        }else if (position == 2){
                            ivCriterio1.setImageResource(R.drawable.color_azul);
                            colorPrimario="2";
                        }else if (position == 3){
                            ivCriterio1.setImageResource(R.drawable.color_blanco);
                            colorPrimario="3";
                        }else if (position == 4){
                            ivCriterio1.setImageResource(R.drawable.color_cafe);
                            colorPrimario="4";
                        }else if (position == 5){
                            ivCriterio1.setImageResource(R.drawable.color_dorado);
                            colorPrimario="5";
                        }else if (position == 6){
                            ivCriterio1.setImageResource(R.drawable.color_gris);
                            colorPrimario="6";
                        }else if (position == 7){
                            ivCriterio1.setImageResource(R.drawable.color_morado);
                            colorPrimario="7";
                        }else if (position == 8) {
                            ivCriterio1.setImageResource(R.drawable.color_naranja);
                            colorPrimario = "8";
                        }else if (position == 9) {
                            ivCriterio1.setImageResource(R.drawable.color_negro);
                            colorPrimario = "9";
                        }else if (position == 10) {
                            ivCriterio1.setImageResource(R.drawable.color_pardo);
                            colorPrimario = "10";
                        }else if (position == 11) {
                            ivCriterio1.setImageResource(R.drawable.color_rojo);
                            colorPrimario = "11";
                        }else if (position == 12) {
                            ivCriterio1.setImageResource(R.drawable.color_rufo);
                            colorPrimario = "12";
                        }else if (position == 13) {
                            ivCriterio1.setImageResource(R.drawable.color_verde);
                            colorPrimario = "13";
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

        ivCriterio2=(ImageView) findViewById(R.id.ivColor2);
        sCriterio2=(Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapterSpinner2 = ArrayAdapter.createFromResource(this,R.array.ColorSecundario, android.R.layout.simple_spinner_item);
        adapterSpinner2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sCriterio2.setAdapter(adapterSpinner1);
        sCriterio2.setOnItemSelectedListener(
                new OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0){
                            ivCriterio2.setImageResource(R.drawable.colorful);
                            colorSecundario="0";
                        }else if (position == 1){
                            ivCriterio2.setImageResource(R.drawable.color_amarillo);
                            colorSecundario="1";
                        }else if (position == 2){
                            ivCriterio2.setImageResource(R.drawable.color_azul);
                            colorSecundario="2";
                        }else if (position == 3){
                            ivCriterio2.setImageResource(R.drawable.color_blanco);
                            colorSecundario="3";
                        }else if (position == 4){
                            ivCriterio2.setImageResource(R.drawable.color_cafe);
                            colorSecundario="4";
                        }else if (position == 5){
                            ivCriterio2.setImageResource(R.drawable.color_dorado);
                            colorSecundario="5";
                        }else if (position == 6){
                            ivCriterio2.setImageResource(R.drawable.color_gris);
                            colorSecundario="6";
                        }else if (position == 7){
                            ivCriterio2.setImageResource(R.drawable.color_morado);
                            colorSecundario="7";
                        }else if (position == 8) {
                            ivCriterio2.setImageResource(R.drawable.color_naranja);
                            colorSecundario = "8";
                        }else if (position == 9) {
                            ivCriterio2.setImageResource(R.drawable.color_negro);
                            colorSecundario = "9";
                        }else if (position == 10) {
                            ivCriterio2.setImageResource(R.drawable.color_pardo);
                            colorSecundario = "10";
                        }else if (position == 11) {
                            ivCriterio2.setImageResource(R.drawable.color_rojo);
                            colorSecundario = "11";
                        }else if (position == 12) {
                            ivCriterio2.setImageResource(R.drawable.color_rufo);
                            colorSecundario = "12";
                        }else if (position == 13) {
                            ivCriterio2.setImageResource(R.drawable.color_verde);
                            colorSecundario = "13";
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });



        formitas=(LinearLayout)findViewById(R.id.formas1);
        piquitos=(LinearLayout)findViewById(R.id.picos1);
        colorsitos=(LinearLayout)findViewById(R.id.colores1);

        ivCriterio4=(ImageView) findViewById(R.id.ivPico);
        sCriterio4=(Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapterSpinner4 = ArrayAdapter.createFromResource(this,R.array.FormaPico, android.R.layout.simple_spinner_item);
        adapterSpinner4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sCriterio4.setAdapter(adapterSpinner4);
        sCriterio4.setOnItemSelectedListener(
                new OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0){
                            ivCriterio4.setImageResource(R.drawable.avessinfondo);
                            formaPico="0";
                        }else if (position == 1){
                            ivCriterio4.setImageResource(R.drawable.pico1);
                            formaPico="1";
                        }else if (position == 2){
                            ivCriterio4.setImageResource(R.drawable.pico2);
                            formaPico="2";
                        }else if (position == 3){
                            ivCriterio4.setImageResource(R.drawable.pico3);
                            formaPico="3";
                        }else if (position == 4){
                            ivCriterio4.setImageResource(R.drawable.pico4);
                            formaPico="4";
                        }else if (position == 5){
                            ivCriterio4.setImageResource(R.drawable.pico5);
                            formaPico="5";
                        }else if (position == 6){
                            ivCriterio4.setImageResource(R.drawable.pico6);
                            formaPico="6";
                        }else if (position == 7){
                            ivCriterio4.setImageResource(R.drawable.pico7);
                            formaPico="7";
                        }else if (position == 8){
                            ivCriterio4.setImageResource(R.drawable.pico8);
                            formaPico="8";
                        }else if (position == 9) {
                            ivCriterio4.setImageResource(R.drawable.pico9);
                            formaPico = "9";
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });

        ivCriterio5=(ImageView) findViewById(R.id.ivAve);
        sCriterio5=(Spinner) findViewById(R.id.spinner5);
        ArrayAdapter<CharSequence> adapterSpinner5 = ArrayAdapter.createFromResource(this,R.array.FormaAve, android.R.layout.simple_spinner_item);
        adapterSpinner5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sCriterio5.setAdapter(adapterSpinner5);
        sCriterio5.setOnItemSelectedListener(
                new OnItemSelectedListener() {
                    public void onItemSelected(
                            AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0){
                            ivCriterio5.setImageResource(R.drawable.avessinfondo);
                            formaAve="0";
                        }else if (position == 1){
                            ivCriterio5.setImageResource(R.drawable.forma1);
                            formaAve="1";
                        }else if (position == 2){
                            ivCriterio5.setImageResource(R.drawable.forma2);
                            formaAve="2";
                        }else if (position == 3){
                            ivCriterio5.setImageResource(R.drawable.forma3);
                            formaAve="3";
                        }else if (position == 4){
                            ivCriterio5.setImageResource(R.drawable.forma4);
                            formaAve="4";
                        }else if (position == 5){
                            ivCriterio5.setImageResource(R.drawable.forma5);
                            formaAve="5";
                        }else if (position == 6){
                            ivCriterio5.setImageResource(R.drawable.forma6);
                            formaAve="6";
                        }else if (position == 7){
                            ivCriterio5.setImageResource(R.drawable.forma7);
                            formaAve="7";
                        }else if (position == 8){
                            ivCriterio5.setImageResource(R.drawable.forma8);
                            formaAve="8";
                        }else if (position == 9) {
                            ivCriterio5.setImageResource(R.drawable.forma9);
                            formaAve = "9";
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });




        bFiltrar = (Button) findViewById(R.id.bFiltrar);
        /*formitas.setVisibility(View.GONE);
        piquitos.setVisibility(View.GONE);
        colorsitos.setVisibility(View.GONE);*/




        bFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent explicit_intent;
                explicit_intent = new Intent(Avistamiento.this,Filtro.class);

                if(view==bFiltrar){

                    explicit_intent.putExtra("colorPrimario",colorPrimario);
                    explicit_intent.putExtra("colorSecundario",colorSecundario);
                    explicit_intent.putExtra("formaPico",formaPico);
                    explicit_intent.putExtra("formaAve",formaAve);

                    startActivity(explicit_intent);
                }


            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent Home = new Intent(Avistamiento.this, Home.class);
        ActivityCompat.finishAffinity(this);
        startActivity(Home);
        Home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }

}
