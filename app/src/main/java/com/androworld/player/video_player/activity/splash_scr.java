package com.androworld.player.video_player.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.androworld.player.video_player.R;



public class splash_scr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_scr);

      /*  mInterstitialAdMob = showAdmobFullAd();
        this.mInterstitialAdMob.loadAd(new AdRequest.Builder()

                .build()); */

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(splash_scr.this, home.class));
                // showAdmobInterstitial();
            }
        },3000);

    }


    @Override
    protected void onPause() {

        super.onPause();
        finish();

    }

    /*
    private com.google.android.gms.ads.InterstitialAd mInterstitialAdMob;

    private com.google.android.gms.ads.InterstitialAd showAdmobFullAd() {
        com.google.android.gms.ads.InterstitialAd interstitialAd = new com.google.android.gms.ads.InterstitialAd(splash_scr.this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        interstitialAd.setAdListener(new com.google.android.gms.ads.AdListener() {
            @Override
            public void onAdClosed() {
                mInterstitialAdMob.loadAd(new AdRequest.Builder()
                        .addTestDevice("0E9048D9285193167D9674E79562F5DC")
                        .addTestDevice("34D19C0181647FFA4D8F095F773F2154")
                        .build());
            }

            @Override
            public void onAdLoaded() {
            }

            @Override
            public void onAdOpened() {
            }
        });
        return interstitialAd;
    }


    private void showAdmobInterstitial() {
        if (this.mInterstitialAdMob != null && this.mInterstitialAdMob.isLoaded()) {
            this.mInterstitialAdMob.show();
        }
    } */


}