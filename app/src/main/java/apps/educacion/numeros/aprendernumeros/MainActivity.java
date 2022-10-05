package apps.educacion.numeros.aprendernumeros;

import static android.content.ContentValues.TAG;
import static com.google.android.gms.ads.RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numeros.R;

import apps.educacion.numeros.claseanuncio.AppOpenManager;
import apps.educacion.numeros.comandodevoz.TTSmanager;
import apps.educacion.numeros.aprendersumas.suma;
import apps.educacion.numeros.paginaPrincipal;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;

//Admob
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd interstitialAd;
    private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712";
    //implements TextToSpeech.OnInitListener
    private Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num10, btnPasar,btnSalir;
    private TextView texto;
    private AdView mAdView;
    private static AppOpenManager appOpenManager;
    TTSmanager ttsManager = null;

    //private static final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        btnSalir = findViewById(R.id.btnSalir);
        texto = findViewById(R.id.texto);
        TextView textNum = findViewById(R.id.textNum);
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






        //anuncio BANNER

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


        //anuncio cuando sales de la app y luego vuelves
       appOpenManager = new AppOpenManager(this);



        // inicio anuncio intertial


            InterstitialAd.load(
                    this, AD_UNIT_ID, adRequest, new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            // The mInterstitialAd reference will be null until
                            // an ad is loaded.
                            MainActivity.this.interstitialAd = interstitialAd;
                            Log.i(TAG, "cargando anuncio");
                            //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                            interstitialAd.setFullScreenContentCallback(
                                    new FullScreenContentCallback() {
                                        @Override
                                        public void onAdDismissedFullScreenContent() {
                                            // Called when fullscreen content is dismissed.
                                            // Make sure to set your reference to null so you don't
                                            // show it a second time.
                                            MainActivity.this.interstitialAd = null;
                                            Log.d("TAG", "El anuncio fue descartado.");
                                        }

                                        @Override
                                        public void onAdFailedToShowFullScreenContent(AdError adError) {
                                            // Called when fullscreen content failed to show.
                                            // Make sure to set your reference to null so you don't
                                            // show it a second time.
                                            MainActivity.this.interstitialAd = null;
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
                            Log.i(TAG, loadAdError.getMessage());
                            interstitialAd = null;


                        }
                    });
*/

        //fin de codigo intertial

        //codigo que hace lo de voz
        ttsManager = new TTSmanager();
        ttsManager.init(this);

        textNum.setOnClickListener(view -> {
            String text = textNum.getText().toString();
            ttsManager.initQueue(text);
        });

        texto.setOnClickListener(view -> {
        String text = texto.getText().toString();
        ttsManager.initQueue(text);
        });

        btnPasar.setOnClickListener(view -> {
            //startActivity(new Intent(MainActivity.this,Num11Num20Activity.class));
            startActivity(new Intent(MainActivity.this, Num11Num20Activity.class));
            finish();
        });

        btnSalir.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, paginaPrincipal.class));
            finish();
            //System.exit(0);
            //finish(); //salir de APP
        });

        num1.setOnClickListener(view -> {
            String text = num1.getText().toString();
            ttsManager.initQueue(text);

        });

        num2.setOnClickListener(view -> {
            String text = num2.getText().toString();
            ttsManager.initQueue(text);

        });

        num3.setOnClickListener(view -> {
            String text = num3.getText().toString();
            ttsManager.initQueue(text);

        });

        num4.setOnClickListener(view -> {
            String text = num4.getText().toString();
            ttsManager.initQueue(text);

        });

        num5.setOnClickListener(view -> {
            String text = num5.getText().toString();
            ttsManager.initQueue(text);

        });

        num6.setOnClickListener(view -> {
            String text = num6.getText().toString();
            ttsManager.initQueue(text);

        });

        num7.setOnClickListener(view -> {
            String text = num7.getText().toString();
            ttsManager.initQueue(text);

        });


        num8.setOnClickListener(view -> {
            String text = num8.getText().toString();
            ttsManager.initQueue(text);

        });

        num9.setOnClickListener(view -> {
            String text = num9.getText().toString();
            ttsManager.initQueue(text);

        });

        num10.setOnClickListener(view -> {
            String text = num10.getText().toString();
            ttsManager.initQueue(text);

        });





    }//fin onCreate

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }




}//fin todo