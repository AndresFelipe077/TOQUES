package apps.educacion.numeros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.numeros.R;

import java.util.Timer;
import java.util.TimerTask;

import apps.educacion.numeros.aprendernumeros.MainActivity;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(splashScreen.this, paginaPrincipal.class));
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(tarea,5000);

    }// fin onCreate
}