package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.signature_text)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            fontStyle = FontStyle.Italic,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GiftImages(gift: Int, modifier: Modifier = Modifier){
    val giftImage = painterResource(gift)
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ConfetiImage()
        Image(
            painter = giftImage,
            contentDescription = stringResource(R.string.gift_box_description),
        )
        ConfetiImage(rotation = 180F)
    }
}

@Composable
fun ConfetiImage(modifier: Modifier = Modifier, rotation: Float = 0.0F){
    val confetiImage = painterResource(R.drawable.confeti)
    Image(
        painter = confetiImage,
        contentDescription = null,
        modifier = modifier
            .graphicsLayer {
                this.rotationY = rotation
            }
    )
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val backgroundImage = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = backgroundImage,
            //contentDescription is used for accessibility reasons
            //in this case the decorative image is not meant to be described
            //if described, it could make TalkBack less efficient
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize()
        ) {
            GreetingText(
                message = message,
                from = from,
                modifier = Modifier
                    .padding(8.dp)
            )
//            GiftImages(
//                gift = R.drawable.gift,
//                modifier = modifier.align(alignment = Alignment.CenterHorizontally)
//            )
            GiftImages(
                gift = R.drawable.cat,
                modifier = modifier.align(alignment = Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview(
    showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_text),
            from = stringResource(R.string.signature_text)
        )
    }
}