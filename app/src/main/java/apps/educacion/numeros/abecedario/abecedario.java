package apps.educacion.numeros.abecedario;

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
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import apps.educacion.numeros.comandodevoz.TTSmanager;
import apps.educacion.numeros.paginaPrincipal;
import apps.educacion.numeros.tablasdemultiplicar.tabla3;

public class abecedario extends AppCompatActivity {

    Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,ñ,o,p,q,r,s,t,u,v,w,x,y,z,btnregresar;
    TTSmanager ttsManager;
    private InterstitialAd interstitialAd;
    private static final String TAG = "abecedario";
    private  static  final String AD_UNIT_ID = "ca-app-pub-4843976573058797/3841494358";
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abecedario);

        a = findViewById(R.id.a);b = findViewById(R.id.b);c = findViewById(R.id.c);d = findViewById(R.id.d);e = findViewById(R.id.e);
        f = findViewById(R.id.f);g = findViewById(R.id.g);h = findViewById(R.id.h);i = findViewById(R.id.i);j = findViewById(R.id.j);
        k = findViewById(R.id.k);l = findViewById(R.id.l);m = findViewById(R.id.m);n = findViewById(R.id.n);ñ = findViewById(R.id.ñ);
        o = findViewById(R.id.o);p = findViewById(R.id.p);q = findViewById(R.id.q);r = findViewById(R.id.r);s = findViewById(R.id.s);
        t = findViewById(R.id.t);u = findViewById(R.id.u);v = findViewById(R.id.v);w = findViewById(R.id.w);x = findViewById(R.id.x);
        y = findViewById(R.id.y);z = findViewById(R.id.z);
        btnregresar = findViewById(R.id.btnRegresar);
        titulo = findViewById(R.id.titulo);

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

        AdSize adSize = new AdSize(500, 50);

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
                        abecedario.this.interstitialAd = interstitialAd;
                        Log.i(TAG, "cargando anuncio");
                        //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                        interstitialAd.setFullScreenContentCallback(
                                new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        // Called when fullscreen content is dismissed.
                                        // Make sure to set your reference to null so you don't
                                        // show it a second time.
                                        abecedario.this.interstitialAd = null;
                                        Log.d("TAG", "El anuncio fue descartado.");
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                                        // Called when fullscreen content failed to show.
                                        // Make sure to set your reference to null so you don't
                                        // show it a second time.
                                        abecedario.this.interstitialAd = null;
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
                        //Log.i(TAG, loadAdError.getMessage());
                        interstitialAd = null;

                    }
                });


        // final Anuncio Interstial*/


        ttsManager = new TTSmanager();
        ttsManager.init(this);

        titulo.setOnClickListener(view -> {
            String text = titulo.getText().toString();
            ttsManager.initQueue(text);
        });

        btnregresar.setOnClickListener(view -> {
            startActivity(new Intent(abecedario.this, paginaPrincipal.class));
            /*if (interstitialAd != null){
                interstitialAd.show(abecedario.this);
            }else{
                Log.d("TAG","El anuncio aun no esta listo");
            }*/
            finish();
        });


        a.setOnClickListener(view -> {
            String text = a.getText().toString();
            ttsManager.initQueue(text);
        });
        b.setOnClickListener(view -> {
            String text = b.getText().toString();
            ttsManager.initQueue(text);
        });
        c.setOnClickListener(view -> {
            String text = c.getText().toString();
            ttsManager.initQueue(text);
        });
        d.setOnClickListener(view -> {
            String text = d.getText().toString();
            ttsManager.initQueue(text);
        });
        e.setOnClickListener(view -> {
            String text = e.getText().toString();
            ttsManager.initQueue(text);
        });
        f.setOnClickListener(view -> {
            String text = f.getText().toString();
            ttsManager.initQueue(text);
        });
        g.setOnClickListener(view -> {
            String text = g.getText().toString();
            ttsManager.initQueue(text);
        });
        h.setOnClickListener(view -> {
            String text = h.getText().toString();
            ttsManager.initQueue(text);
        });
        i.setOnClickListener(view -> {
            String text = i.getText().toString();
            ttsManager.initQueue(text);
        });
        j.setOnClickListener(view -> {
            String text = j.getText().toString();
            ttsManager.initQueue(text);
        });
        k.setOnClickListener(view -> {
            String text = k.getText().toString();
            ttsManager.initQueue(text);
        });
        l.setOnClickListener(view -> {
            String text = l.getText().toString();
            ttsManager.initQueue(text);
        });
        m.setOnClickListener(view -> {
            String text = m.getText().toString();
            ttsManager.initQueue(text);
        });
        n.setOnClickListener(view -> {
            String text = n.getText().toString();
            ttsManager.initQueue(text);
        });
        ñ.setOnClickListener(view -> {
            String text = ñ.getText().toString();
            ttsManager.initQueue(text);
        });
        o.setOnClickListener(view -> {
            String text = o.getText().toString();
            ttsManager.initQueue(text);
        });
        p.setOnClickListener(view -> {
            String text = p.getText().toString();
            ttsManager.initQueue(text);
        });
        q.setOnClickListener(view -> {
            String text = q.getText().toString();
            ttsManager.initQueue(text);
        });
        r.setOnClickListener(view -> {
            String text = r.getText().toString();
            ttsManager.initQueue(text);
        });
        s.setOnClickListener(view -> {
            String text = s.getText().toString();
            ttsManager.initQueue(text);
        });
        t.setOnClickListener(view -> {
            String text = t.getText().toString();
            ttsManager.initQueue(text);
        });
        v.setOnClickListener(view -> {
            String text = v.getText().toString();
            ttsManager.initQueue(text);
        });
        u.setOnClickListener(view -> {
            String text = u.getText().toString();
            ttsManager.initQueue(text);
        });
        w.setOnClickListener(view -> {
            String text = w.getText().toString();
            ttsManager.initQueue(text);
        });
        x.setOnClickListener(view -> {
            String text = x.getText().toString();
            ttsManager.initQueue(text);
        });
        y.setOnClickListener(view -> {
            String text = y.getText().toString();
            ttsManager.initQueue(text);
        });
        z.setOnClickListener(view -> {
            String text = z.getText().toString();
            ttsManager.initQueue(text);
        });


    }//final onCreate




}//final abecedario