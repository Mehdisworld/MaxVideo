package com.androworld.player.video_player.Ads;


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.androworld.player.video_player.Utils.CustomUtils;
import com.google.android.gms.ads.MobileAds;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class MyApp extends MultiDexApplication {

    RequestQueue requestQueue;
    public static int isJsonDone = 0; // 0 not yet processed 1 json is done 2 error
    public static String NetworkAds ="admob";
    public static String BannerAdmob ="ca-app-pub-3940256099942544/6300978111000";
    public static String InterstitialAdmob ="ca-app-pub-3940256099942544/10331737120";
    //----------
    public static String BannerFacebook ="IMG_16_9_APP_INSTALL#882603842535280_882604289201902";
    public static String InterstitialFacebook ="IMG_16_9_APP_INSTALL#882603842535280_882604212535243";
    //-----
    public static boolean ImageBanner =false;
    public static String ImageBannerImg ="https://health-fitness.ltd/dskcommiixplayervide/logo.jpg";
    public static String ImageBannerURL ="https://cryptocoinm.com";
    public static String PrivacyPolicy ="https://health-fitness.ltd/dskcommiixplayervide/privacypolicy.html";
    public static String PublisherId ="pub-7280343659534747";
    public static String preferences_name = "com.example.adshost";


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        requestQueue = Volley.newRequestQueue(this);
        MobileAds.initialize(this);
        callAds();
    }

    private void callAds() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, CustomUtils.JSON_LINK, null,
                new Response.Listener() {
                    @Override
                    public void onResponse(Object response)
                    {
                        try {

                            JSONObject GuideData = ((JSONObject) response).getJSONObject(CustomUtils.JSON_GUIDE_DATA);
                            JSONObject AdsController = GuideData.getJSONObject(CustomUtils.JSON_ADS);


                            NetworkAds = AdsController.getString(CustomUtils.JSON_NETWORKADS);

                            BannerAdmob = AdsController.getString(CustomUtils.JSON_BRADMOB);
                            InterstitialAdmob = AdsController.getString(CustomUtils.JSON_INTADMOB);

                            BannerFacebook = AdsController.getString(CustomUtils.JSON_BRFACEBOOK);
                            InterstitialFacebook = AdsController.getString(CustomUtils.JSON_INTFACEBOOK);

                            ImageBanner = AdsController.getBoolean(CustomUtils.JSON_IMGBANNER);
                            ImageBannerImg = AdsController.getString(CustomUtils.JSON_IMGBANNERIMG);
                            ImageBannerURL = AdsController.getString(CustomUtils.JSON_IMGBANNERURL);

                            isJsonDone = 1;

                        } catch (JSONException e) {
                            isJsonDone = 2;
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        isJsonDone = 2;
                    }
                });
        jsonObjectRequest.setShouldCache(false);
        requestQueue.add(jsonObjectRequest);
    }
}
