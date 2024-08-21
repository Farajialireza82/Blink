package com.crumulant.blink

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crumulant.blink.ui.theme.BlinkTheme
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeStyle
import dev.chrisbanes.haze.haze

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color(0xFF15141F).toArgb())
        )
        setContent {
            BlinkTheme(
                darkTheme = true,

                ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                ) { innerPadding ->
                    MainScreen(innerPadding)
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_7_PRO,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun MainScreen(
    innerPadding: PaddingValues = PaddingValues()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF15141F))
            .padding(innerPadding)
    ) {
        HomeScreen()
    }
}


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 44.dp, start = 24.dp)
        ) {
            Text(
                text = "Stream",
                color = Color(0xFFFF8F71),
                fontSize = 24.sp
            )
            Text(
                text = " Everywhere",
                fontSize = 24.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.size(28.dp))
        StarringMovieItem()
        Spacer(modifier = Modifier.size(28.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 44.dp, start = 24.dp),
            text = " Trending",
            fontSize = 24.sp,
            color = Color.White
        )
        Spacer(modifier = Modifier.size(24.dp))
        LazyRow(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            item {
                TrendingMovieItem()
                TrendingMovieItem()
                TrendingMovieItem()
                TrendingMovieItem()
                TrendingMovieItem()
                TrendingMovieItem()
            }
        }

    }
}

@Composable
fun StarringMovieItem() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            painter = painterResource(id = R.drawable.avengers),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(191.dp)
                .fillMaxSize()
                .padding(start = 24.dp, end = 24.dp)
                .clip(shape = RoundedCornerShape(30.dp)),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .height(62.dp)
                .width((LocalConfiguration.current.screenWidthDp / 1.6).dp)
                .padding(start = 32.dp, end = 28.dp, bottom = 4.dp)

                .clip(shape = RoundedCornerShape(30.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .width(
                        (
                                LocalConfiguration.current.screenWidthDp / 1.8).dp
                    )
                    .background(Color.Black)
                    .haze(
                        HazeState(),
                        HazeStyle(Color.Cyan)
                    )
                    .fillMaxWidth()
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    modifier = Modifier
                        .size(32.dp),
                    painter = painterResource(id = R.drawable.play_icon),
                    contentDescription = ""
                )
                Column(
                    modifier = Modifier
                        .padding(4.dp)
                ) {
                    Text(
                        text = "Continue Watching",
                        fontSize = 12.sp,
                        color = Color(0xFFFF8F71)
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = "Avengers",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }


        }

    }
}

@Composable
fun TrendingMovieItem() {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.BottomStart
    ) {
        Image(
            painter = painterResource(id = R.drawable.godzila),
            contentDescription = null,
            modifier = Modifier
                .height(336.dp)
                .width(258.dp)
                .padding(start = 24.dp, end = 24.dp)
                .clip(shape = RoundedCornerShape(30.dp)),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .height(62.dp)
                .width((LocalConfiguration.current.screenWidthDp / 1.6).dp)
                .padding(start = 32.dp, end = 28.dp, bottom = 8.dp)
                .align(Alignment.BottomCenter)

                .clip(shape = RoundedCornerShape(30.dp))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .fillMaxWidth()
            ){
                Text(
                    text = "Godzilla (2018)",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .align(Alignment.Center)
                    )
            }

        }
    }
}