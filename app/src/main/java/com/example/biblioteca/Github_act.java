package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Libros.Libros;

public class Github_act extends AppCompatActivity {
    private Spinner spin1;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);
        spin1= (Spinner)findViewById(R.id.spin1);
        text = (TextView)findViewById(R.id.text);


       ArrayList<String> listaLibros = (ArrayList<String>) getIntent().getSerializableExtra("listaLibros");
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaLibros);
        spin1.setAdapter(adap);

    }

    public void Calcular(View v)
    {
        Libros Li = new Libros();
        String lb = spin1.getSelectedItem().toString();

        int result1 = Li.getFarenheith();
        int result2 = Li.getRevival();
        int result3 = Li.getEl_Alquimista();
        int result4 = Li.getEl_Poder();
        int result5 = Li.getDespertar();


        if(lb.equals("Farentheith"))
        {
            text.setText("El valor de Farentheith es: " + result1);
        }

        if(lb.equals("Revival"))
        {
            text.setText("El valor de Farentheith es: " + result2);
        }


        if(lb.equals("El Alquimista"))
        {
            text.setText("El valor de El Alquimista es: " + result3);
        }

        if(lb.equals("El Poder"))
        {
            text.setText("El valor de El Poder es: " + result4);
        }

        if(lb.equals("Despertar"))
        {
            text.setText("El valor de Despertar es: " + result5);
        }

    }



}