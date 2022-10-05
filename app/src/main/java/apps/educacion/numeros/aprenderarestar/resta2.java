package apps.educacion.numeros.aprenderarestar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numeros.R;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import apps.educacion.numeros.claseanuncio.AppOpenManager;
import apps.educacion.numeros.comandodevoz.TTSmanager;
import apps.educacion.numeros.paginaPrincipal;

public class resta2 extends AppCompatActivity {

    private Button num1linea1,num2linea1,igual1linea1,numTotal1linea1,num1linea2,num2linea2,igual1linea2,numTotal1linea2,num1linea3,num2linar3,igual1linea3,numTotallinea3,num1linea4,num2linea4,igual1linea4,numTotallinea4,num1linea5,num2linar5,igual1linea5,numTotallinea5;
    private TextView textoTitulo;
    TTSmanager ttsManager = null;
    private static AppOpenManager appOpenManager;
    private AdView mAdView;

    private TextView mas1linea1, mas1linea2, mas1linea3, mas1linea4,mas1linea5 ;

    private Button pasar,btnRegresar;

   /* private InterstitialAd interstitialAd;
    private static final String TAG = "resta2";
    private  static  final String AD_UNIT_ID = "ca-app-pub-4843976573058797/3841494358";
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resta2);

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

        // anuncio Interstitial

        InterstitialAd.load(
                this, AD_UNIT_ID, adRequest, new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        dividir1.this.interstitialAd = interstitialAd;
                        Log.i(TAG, "cargando anuncio");
                        //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                        interstitialAd.setFullScreenContentCallback(
                                new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        // Called when fullscreen content is dismissed.
                                        // Make sure to set your reference to null so you don't
                                        // show it a second time.
                                        dividir1.this.interstitialAd = null;
                                        Log.d("TAG", "El anuncio fue descartado.");
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                                        // Called when fullscreen content failed to show.
                                        // Make sure to set your reference to null so you don't
                                        // show it a second time.
                                        dividir1.this.interstitialAd = null;
                                        Log.d("TAG", "El anuncio no se mostró.");
                                    }

                                    @Override
                                    public void onAdShowedFullScreenContent() {
                                        // Called when fullscreen content is shown.
                                        Log.d("TAG", "Se mostró el anuncio.");
                                    }
                                });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        /*Log.i(TAG, loadAdError.getMessage());
                        interstitialAd = null;

                        String error = String.format("domain: %s, code: %d, message: %s", loadAdError.getDomain(), loadAdError.getCode(), loadAdError.getMessage());
                        Toast.makeText(
                                resta2.this, "Fallo al cargar el anuncio. " + error, Toast.LENGTH_SHORT)
                                .show();
                    }
                });


        // final Anuncio Interstial*/


        //comando de voz
        ttsManager = new TTSmanager();
        ttsManager.init(this);

        btnRegresar.setOnClickListener(view -> {
            startActivity(new Intent(resta2.this, resta1.class));
            finish();
        });

        pasar.setOnClickListener(view -> {
            startActivity(new Intent(resta2.this, resta3.class));
            /*if (interstitialAd != null){
                interstitialAd.show(resta2.this);
            }else{
                Log.d("TAG","El anuncio aún no está listo.");
            }*/
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