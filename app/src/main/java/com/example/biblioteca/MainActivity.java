package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText txt, txt2;
    private ProgressBar progress;
    private Button button;
    private ImageButton Ibutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (EditText)findViewById(R.id.txt);
        txt2 = (EditText)findViewById(R.id.txt2);
        Ibutton = (ImageButton)findViewById(R.id.btn);
        progress = (ProgressBar)findViewById(R.id.pb);

        progress.setVisibility(View.INVISIBLE);
        button = (Button)findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute(); // ejecuta mi tarea asíncrona.
            }
        });


        progress.setVisibility(View.INVISIBLE); // desaparece el elemento.


    }
    public void Libross(View v)
    {
        ArrayList<String> listaLibros = new ArrayList<String>();


        listaLibros.add("Farenheith");
        listaLibros.add("Revival");
        listaLibros.add("El Alquimista");

        Intent i = new Intent (this, Github_act.class);
        i.putExtra("listaLibros", listaLibros);


        startActivity(i);
    }


    class Task extends AsyncTask<String, Void, String> {

        @Override  // Vamos a darle la configuración inicial a la tarea
        protected void onPreExecute() {

            progress.setVisibility(View.VISIBLE);
        }


        @Override // vamos a emplear el proceso o tarea pesada en segundo plano.
        protected String doInBackground(String... strings) {

            for(int i = 1; i < 10; i++)
            {
                try {
                    Thread.sleep(1000);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override // finalizamos la tarea
        protected void onPostExecute(String s) {

            progress.setVisibility(View.INVISIBLE);



            String nombre = txt.getText().toString();
            String contraseña = txt2.getText().toString();

            if(nombre.equalsIgnoreCase("android") && contraseña.equalsIgnoreCase("123"))
            {
                Intent i = new Intent(getBaseContext(), Home.class);
                startActivity(i);

            }else if(nombre.equalsIgnoreCase("Android") && contraseña.equalsIgnoreCase("123"))
            {
                Intent i = new Intent(getBaseContext(), Home.class);
                startActivity(i);

            }else{

                Toast.makeText(getBaseContext(), "Login incorrecto", Toast.LENGTH_SHORT).show();
            }

        }
    }


}