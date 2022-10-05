package apps.educacion.numeros.aprendernumeros;

import static android.content.ContentValues.TAG;
import static com.google.android.gms.ads.RequestConfiguration.TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numeros.R;

import apps.educacion.numeros.comandodevoz.TTSmanager;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class Num61num70Activity extends AppCompatActivity {

    private Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num10, btnPasar,btnRegresar;
    private AdView mAdView;
    TTSmanager ttsManager = null;
    private static final String AD_UNIT_ID = "ca-app-pub-4843976573058797/3841494358";
    private static final String TAG = "Num61num79Activity";
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.num61num70);


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
        //regresar = findViewById(R.id.btnRegresar);


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
                        Num61num70Activity.this.interstitialAd = interstitialAd;
                        Log.i(TAG, "cargando anuncio");
                        //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                        interstitialAd.setFullScreenContentCallback(
                                new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        // Called when fullscreen content is dismissed.
                                        // Make sure to set your reference to null so you don't
                                        // show it a second time.
                                        Num61num70Activity.this.interstitialAd = null;
                                        Log.d("TAG", "El anuncio fue descartado.");
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                                        // Called when fullscreen content failed to show.
                                        // Make sure to set your reference to null so you don't
                                        // show it a second time.
                                        Num61num70Activity.this.interstitialAd = null;
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


        // final Anuncio Interstial

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
                startActivity(new Intent(Num61num70Activity.this,Num71num80Activity.class));
               /* if (interstitialAd != null){
                    interstitialAd.show(Num61num70Activity.this);
                }else{
                    Log.d("TAG","El anuncio intersticial aún no estaba listo.");
                }

                */
                finish();
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Num61num70Activity.this,Num51num60Activity.class));
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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}//fin todo