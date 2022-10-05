package apps.educacion.numeros.aprendernumeros;

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
import apps.educacion.numeros.paginaPrincipal;

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

public class Num91num100Activity extends AppCompatActivity {
    private Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num10,btnSalir, btnRegresar, btnIniciar;
    private AdView mAdView;
    TTSmanager ttsManager = null;
    private InterstitialAd interstitialAd;
    private static final String TAG = "Num91num100Activity";
    private static final String AD_UNIT_ID = "ca-app-pub-4843976573058797/3841494358";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.num91num100);

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
        btnSalir = findViewById(R.id.btnSalir);
        btnIniciar = findViewById(R.id.btnIniciar);
        TextView texto = findViewById(R.id.texto);
        TextView textNum = findViewById(R.id.textNum);
        btnRegresar = findViewById(R.id.btnRegresar);



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
                        Num91num100Activity.this.interstitialAd = interstitialAd;
                        Log.i(TAG, "cargando anuncio");
                        //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                        interstitialAd.setFullScreenContentCallback(
                                new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        // Called when fullscreen content is dismissed.
                                        // Make sure to set your reference to null so you don't
                                        // show it a second time.
                                        Num91num100Activity.this.interstitialAd = null;
                                        Log.d("TAG", "El anuncio fue descartado.");
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                                        // Called when fullscreen content failed to show.
                                        // Make sure to set your reference to null so you don't
                                        // show it a second time.
                                        Num91num100Activity.this.interstitialAd = null;
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

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              startActivity(new Intent(Num91num100Activity.this,Num81num90Activity.class));
              finish();
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Num91num100Activity.this, paginaPrincipal.class));
               /* if(interstitialAd != null){
                    interstitialAd.show(Num91num100Activity.this);
                }else{
                    Log.d("TAG","El anuncio aun no está listo");
                }

                */
                finish();

                //finish();//salir de APP
            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Num91num100Activity.this,MainActivity.class));
                /*if (interstitialAd != null){
                    interstitialAd.show(Num91num100Activity.this);
                }else{
                    Log.d("TAG","El anuncio no se ha podido mostrar.");
                }

                 */
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
