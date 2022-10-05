package apps.educacion.numeros;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.numeros.R;

import apps.educacion.numeros.abecedario.abecedario;
import apps.educacion.numeros.aprenderadividir.dividir1;
import apps.educacion.numeros.aprenderadividir.dividir2;
import apps.educacion.numeros.aprenderarestar.resta1;
import apps.educacion.numeros.aprendernumeros.MainActivity;
import apps.educacion.numeros.aprendersumas.suma;
import apps.educacion.numeros.comandodevoz.TTSmanager;
import apps.educacion.numeros.tablasdemultiplicar.tabla2;
import de.hdodenhof.circleimageview.CircleImageView;

public class paginaPrincipal extends AppCompatActivity {

    ImageView aprenderNumeros,aprenderAbecedario,aprenderSumas,aprenderRestas,aprenderMultiplicaciones,aprenderDivisiones,circlePro;
    TTSmanager ttsManager;
    private TextView titulo, numeros, abecedario, sumar, restar, multiplicar, dividir, textoPiedePantalla;
    Button btnSalir;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);


        titulo = findViewById(R.id.titulo);
        abecedario = findViewById(R.id.abecedario);
        numeros = findViewById(R.id.numeros);
       /* sumar = findViewById(R.id.sumar);
        restar = findViewById(R.id.restas);
        multiplicar = findViewById(R.id.multiplicaciones);
        dividir = findViewById(R.id.divisiones);*/
        textoPiedePantalla = findViewById(R.id.textoPiedePantalla);
        circlePro = findViewById(R.id.circlePro);

        btnSalir = findViewById(R.id.btnSalir);


        aprenderNumeros          = findViewById(R.id.aprenderNumeros);
        aprenderAbecedario       = findViewById(R.id.aprenderAbecedario);
        /*aprenderSumas            = findViewById(R.id.aprenderSumas);
        aprenderRestas           = findViewById(R.id.aprenderRestas);
        aprenderMultiplicaciones = findViewById(R.id.aprenderMultiplicaciones);
        aprenderDivisiones       = findViewById(R.id.aprenderDivisiones);
*/
        ttsManager = new TTSmanager();
        ttsManager.init(this);


        circlePro.setOnClickListener(View ->{
            //startActivity(new Intent(paginaPrincipal.this, moverObjecto.class));
            trans();
        });

        btnSalir.setOnClickListener(View -> System.exit(0));


        titulo.setOnClickListener(view -> {
            String text = titulo.getText().toString();
            ttsManager.initQueue(text);
        });

        abecedario.setOnClickListener(view -> {
            String text = abecedario.getText().toString();
            ttsManager.initQueue(text);
        });

        numeros.setOnClickListener(view -> {
            String text = numeros.getText().toString();
            ttsManager.initQueue(text);

        });

        /*sumar.setOnClickListener(view -> {
            String text = sumar.getText().toString();
            ttsManager.initQueue(text);

        });

        restar.setOnClickListener(view -> {
            String text = restar.getText().toString();
            ttsManager.initQueue(text);

        });

        dividir.setOnClickListener(view -> {
            String text = dividir.getText().toString();
            ttsManager.initQueue(text);

        });

        multiplicar.setOnClickListener(view -> {
            String text = multiplicar.getText().toString();
            ttsManager.initQueue(text);

        });*/

        textoPiedePantalla.setOnClickListener(view -> {
            String text = textoPiedePantalla.getText().toString();
            ttsManager.initQueue(text);

        });

        // fin texto


        //inicio botones

        aprenderNumeros.setOnClickListener(view -> {
            startActivity(new Intent(paginaPrincipal.this, MainActivity.class));
            finish();
        });

        aprenderAbecedario.setOnClickListener(view -> {
            startActivity(new Intent(paginaPrincipal.this, abecedario.class));
            finish();
        });

        /*aprenderSumas.setOnClickListener(view -> {
            startActivity(new Intent(paginaPrincipal.this, suma.class));
            finish();
        });

        aprenderRestas.setOnClickListener(view -> {
            startActivity(new Intent(paginaPrincipal.this, resta1.class));
            finish();
        });

        aprenderMultiplicaciones.setOnClickListener(view -> {
            startActivity(new Intent(paginaPrincipal.this, tabla2.class));
            finish();
        });*/

        /*aprenderDivisiones.setOnClickListener(view -> {
            startActivity(new Intent(paginaPrincipal.this, dividir2.class));
            finish();
        });*/



    }//fin onCreate

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }


    //codigo para las transiciones y animaciones BABY!!!
    public void trans(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.trains);
        Animation animation2 = AnimationUtils.loadAnimation(this,R.anim.trains2);
        Animation animation3 = AnimationUtils.loadAnimation(this,R.anim.trains3);
        Animation animation4 = AnimationUtils.loadAnimation(this,R.anim.trains4);
        /*Animation animation5 = AnimationUtils.loadAnimation(this,R.anim.trains5);
        Animation animation6 = AnimationUtils.loadAnimation(this,R.anim.trains6);
        Animation animation7 = AnimationUtils.loadAnimation(this,R.anim.trains7);
        Animation animation8 = AnimationUtils.loadAnimation(this,R.anim.trains8);*/
        titulo.startAnimation(animation);
        textoPiedePantalla.startAnimation(animation2);
        abecedario.startAnimation(animation3);
        numeros.startAnimation(animation4);
        /*restar.startAnimation(animation5);
        sumar.startAnimation(animation6);
        dividir.startAnimation(animation7);
        multiplicar.startAnimation(animation8);*/

    }


}//fin paginaPrincipal
