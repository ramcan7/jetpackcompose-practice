package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Article(
                        title = R.string.Main_Article_Title,
                        description = R.string.Jetpack_Compose_Description,
                        body = R.string.tutorial_body,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Article(
    @StringRes title: Int,
    @StringRes description: Int,
    @StringRes body: Int,
    modifier: Modifier = Modifier
) {
    val headerImage = painterResource(R.drawable.bg_compose_background)

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier.padding(16.dp)
    ) {
        Image(
            painter = headerImage,
            contentDescription = null,
            modifier = modifier
        )
        Text(
            text = stringResource(title),
            fontSize = 24.sp
        )
        Text(
            text = stringResource(description),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(body),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    ComposeArticleTheme {
        Article(
            title = R.string.Main_Article_Title,
            description = R.string.Jetpack_Compose_Description,
            body = R.string.tutorial_body
        )
    }
}