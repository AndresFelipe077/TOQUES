package apps.educacion.numeros.aprendersumas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.numeros.R;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import apps.educacion.numeros.aprendernumeros.MainActivity;
import apps.educacion.numeros.claseanuncio.AppOpenManager;
import apps.educacion.numeros.comandodevoz.TTSmanager;
import apps.educacion.numeros.paginaPrincipal;

public class suma extends AppCompatActivity {

    private Button num1linea1,mas1linea1,num2linea1,igual1linea1,numTotal1linea1,num1linea2,mas1linea2,num2linea2,igual1linea2,numTotal1linea2,num1linea3,mas1linea3,num2linar3,igual1linea3,numTotallinea3,num1linea4,mas1linea4,num2linea4,igual1linea4,numTotallinea4,num1linea5,mas1linea5,num2linar5,igual1linea5,numTotallinea5;
    private TextView textoTitulo;
    TTSmanager ttsManager = null;
    private static AppOpenManager  appOpenManager;
    private AdView mAdView;

    private Button pasar,btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma);

        pasar = findViewById(R.id.pasar);
        btnRegresar = findViewById(R.id.btnRegresar);

        textoTitulo = findViewById(R.id.textoTitulo);

        num1linea1 = findViewById(R.id.num1linea1);
        mas1linea1 = findViewById(R.id.mas1linea1);
        num2linea1 = findViewById(R.id.num2linea1);
        igual1linea1 = findViewById(R.id.igual1linea1);
        numTotal1linea1 = findViewById(R.id.numTotal1linea1);


        num1linea2 = findViewById(R.id.num1linea2);
        mas1linea2 = findViewById(R.id.mas1linea2);
        num2linea2 = findViewById(R.id.num2linea2);
        igual1linea2 = findViewById(R.id.igual1linea2);
        numTotal1linea2 = findViewById(R.id.numTotal1linea2);


        num1linea3 = findViewById(R.id.num1linea3);
        mas1linea3 = findViewById(R.id.mas1linea3);
        num2linar3 = findViewById(R.id.num2linar3);
        igual1linea3 = findViewById(R.id.igual1linea3);
        numTotallinea3 = findViewById(R.id.numTotallinea3);


        num1linea4 = findViewById(R.id.num1linea4);
        mas1linea4 = findViewById(R.id.mas1linea4);
        num2linea4 = findViewById(R.id.num2linea4);
        igual1linea4 = findViewById(R.id.igual1linea4);
        numTotallinea4 = findViewById(R.id.numTotallinea4);


        num1linea5 = findViewById(R.id.num1linea5);
        mas1linea5 = findViewById(R.id.mas1linea5);
        num2linar5 = findViewById(R.id.num2linar5);
        igual1linea5 = findViewById(R.id.igual1linea5);
        numTotallinea5 = findViewById(R.id.numTotallinea5);


        //adView = findViewById(R.id.adView);


       /* //inicializador de anuncion
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                *//*RequestConfiguration requestConfiguration = MobileAds.getRequestConfiguration().toBuilder()
                        .setTagForChildDirectedTreatment(TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE)
                        .build();*//*
            }
        });

        Bundle extras = new Bundle();
        extras.putBoolean("is_designed_for_families", true);
        AdView mAdView = findViewById (R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addNetworkExtrasBundle (AdMobAdapter.class,extras).build ();
        mAdView.loadAd(adRequest); //tened ojo con esto

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

*/



        //comando de voz
        ttsManager = new TTSmanager();
        ttsManager.init(this);

        btnRegresar.setOnClickListener(view -> {
            startActivity(new Intent(suma.this, paginaPrincipal.class));
            finish();
        });

        pasar.setOnClickListener(view -> {
            startActivity(new Intent(suma.this,suma2.class));
            finish();
        });

        textoTitulo.setOnClickListener(view -> {
            String text = textoTitulo.getText().toString();
            ttsManager.initQueue(text);
        });

        num1linea1.setOnClickListener(view -> {
            String text = num1linea1.getText().toString();
            ttsManager.initQueue(text);
        });

        mas1linea1.setOnClickListener(view -> {
            String text = mas1linea1.getText().toString();
            ttsManager.initQueue(text);
        });

        num2linea1.setOnClickListener(view -> {
            String text = num2linea1.getText().toString();
            ttsManager.initQueue(text);
        });

        igual1linea1.setOnClickListener(view -> {
            String text = igual1linea1.getText().toString();
            ttsManager.initQueue(text);
        });

        numTotal1linea1.setOnClickListener(view -> {
            String text = numTotal1linea1.getText().toString();
            ttsManager.initQueue(text);
        });

        //fin primera fila

        num1linea2.setOnClickListener(view -> {
            String text = num1linea2.getText().toString();
            ttsManager.initQueue(text);
        });

        mas1linea2.setOnClickListener(view -> {
            String text = mas1linea2.getText().toString();
            ttsManager.initQueue(text);
        });

        num2linea2.setOnClickListener(view -> {
            String text = num2linea2.getText().toString();
            ttsManager.initQueue(text);
        });

        igual1linea2.setOnClickListener(view -> {
            String text = igual1linea2.getText().toString();
            ttsManager.initQueue(text);
        });

        numTotal1linea2.setOnClickListener(view -> {
            String text = numTotal1linea2.getText().toString();
            ttsManager.initQueue(text);
        });

        //fin fila 2

        num1linea3.setOnClickListener(view -> {
            String text = num1linea3.getText().toString();
            ttsManager.initQueue(text);
        });

        mas1linea3.setOnClickListener(view -> {
            String text = mas1linea3.getText().toString();
            ttsManager.initQueue(text);
        });

        num2linar3.setOnClickListener(view -> {
            String text = num2linar3.getText().toString();
            ttsManager.initQueue(text);
        });

        igual1linea3.setOnClickListener(view -> {
            String text = igual1linea3.getText().toString();
            ttsManager.initQueue(text);
        });

        numTotallinea3.setOnClickListener(view -> {
            String text = numTotallinea3.getText().toString();
            ttsManager.initQueue(text);
        });

        //fin fila 3

        num1linea4.setOnClickListener(view -> {
            String text = num1linea4.getText().toString();
            ttsManager.initQueue(text);
        });

        mas1linea4.setOnClickListener(view -> {
            String text = mas1linea4.getText().toString();
            ttsManager.initQueue(text);
        });

        num2linea4.setOnClickListener(view -> {
            String text = num2linea4.getText().toString();
            ttsManager.initQueue(text);
        });

        igual1linea4.setOnClickListener(view -> {
            String text = igual1linea4.getText().toString();
            ttsManager.initQueue(text);
        });

        numTotallinea4.setOnClickListener(view -> {
            String text = numTotallinea4.getText().toString();
            ttsManager.initQueue(text);
        });

        //fin fila 4

        num1linea5.setOnClickListener(view -> {
            String text = num1linea5.getText().toString();
            ttsManager.initQueue(text);
        });

        mas1linea5.setOnClickListener(view -> {
            String text = mas1linea5.getText().toString();
            ttsManager.initQueue(text);
        });

        num2linar5.setOnClickListener(view -> {
            String text = num2linar5.getText().toString();
            ttsManager.initQueue(text);
        });

        igual1linea5.setOnClickListener(view -> {
            String text = igual1linea5.getText().toString();
            ttsManager.initQueue(text);
        });


        numTotallinea5.setOnClickListener(view -> {
            String text = numTotallinea5.getText().toString();
            ttsManager.initQueue(text);
        });

    }//fin de onCreate

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }


}//fin de clase