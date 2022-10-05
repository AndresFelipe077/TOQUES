package apps.educacion.numeros.aprendernumeros;

import static com.google.android.gms.ads.RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.numeros.R;

import apps.educacion.numeros.comandodevoz.TTSmanager;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Num41num50Activity extends AppCompatActivity {
    private Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num10, btnPasar,btnRegresar;
    private AdView mAdView;
    TTSmanager ttsManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.num41num50);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);
        num10 = findViewById(R.id.num10);
        btnPasar = findViewById(R.id.btnPasar);
        btnRegresar = findViewById(R.id.btnRegresar);
        TextView texto = findViewById(R.id.texto);
        TextView textNum = findViewById(R.id.textNum);


        ttsManager = new TTSmanager();
        ttsManager.init(this);

        /*

        //inicializador de anuncion
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                RequestConfiguration requestConfiguration = MobileAds.getRequestConfiguration().toBuilder()
                        .setTagForChildDirectedTreatment(TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE)
                        .build();
            }
        });


        //anuncio BANNER
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




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

        textNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = textNum.getText().toString();
                ttsManager.initQueue(text);
            }
        });

        texto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = texto.getText().toString();
                ttsManager.initQueue(text);
            }
        });

        btnPasar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Num41num50Activity.this,Num51num60Activity.class));
                finish();
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Num41num50Activity.this,Num31Num40Activity.class));
                finish();
            }
        });

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = num1.getText().toString();
                ttsManager.initQueue(text);

            }
        });

        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = num2.getText().toString();
                ttsManager.initQueue(text);

            }
        });

        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = num3.getText().toString();
                ttsManager.initQueue(text);

            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = num4.getText().toString();
                ttsManager.initQueue(text);

            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = num5.getText().toString();
                ttsManager.initQueue(text);

            }
        });

        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = num6.getText().toString();
                ttsManager.initQueue(text);

            }
        });

        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = num7.getText().toString();
                ttsManager.initQueue(text);

            }
        });


        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = num8.getText().toString();
                ttsManager.initQueue(text);

            }
        });

        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = num9.getText().toString();
                ttsManager.initQueue(text);

            }
        });

        num10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = num10.getText().toString();
                ttsManager.initQueue(text);

            }
        });


    }//fin onCreate

   /* private void speak(){
        String message = num1.getText().toString();
        Log.i("sirve",message);
    }*/


    /*@Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS){

            num1.getText().toString();
        }

    }*/


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}//fin todo