package com.globalstore.game8192

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.globalstore.game8192.ads.AdMobBanner
import com.globalstore.game8192.ui.game.GameScreen
import com.globalstore.game8192.ui.theme.Compose2048Theme
import com.google.android.gms.ads.MobileAds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MobileAds.initialize(this) {}
        setContent {
            Compose2048Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color(0xffe6dbc9)
                ) {
                    Box(
                        Modifier.padding(16.dp)
                    ) {
                        GameScreen()
                        AdMobBanner(
                            adUnitId = "ca-app-pub-5820993331824423/2931284310",
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .fillMaxWidth()
                                .wrapContentHeight()
                        )
                    }
                }
            }
        }
    }
}
