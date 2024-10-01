package com.globalstore.game8192.ads

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError

@Composable
fun AdMobBanner(
    adUnitId: String,
    modifier: Modifier
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            AdView(context).apply {
                this.adUnitId = adUnitId
                this.setAdSize(com.google.android.gms.ads.AdSize.BANNER)
                loadAd(AdRequest.Builder().build())

                // Set AdListener to log events
                this.adListener = object : AdListener() {
                    override fun onAdLoaded() {
                        super.onAdLoaded()
                        Log.d("AdMobBanner", "Ad loaded successfully")
                    }

                    override fun onAdFailedToLoad(adError: LoadAdError) {
                        super.onAdFailedToLoad(adError)
                        Log.e("AdMobBanner", "Ad failed to load: ${adError.message}")
                    }
                }
            }
        },
        update = { adView ->
            adView.loadAd(AdRequest.Builder().build())
        }
    )
}