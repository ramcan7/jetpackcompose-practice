package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
                Article(
                    title = R.string.Main_Article_Title,
                    description = R.string.Jetpack_Compose_Description,
                    body = R.string.tutorial_body
                )
            }
        }
    }
}

//reusable for other titles, could also add for it to be bold
@Composable
fun Title(
    @StringRes title: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(title),
        modifier = modifier,
        fontSize = 24.sp,
    )
}

//would be used for anything that is longer than a line
@Composable
fun LargeText(
    @StringRes body: Int,
    modifier: Modifier = Modifier
)
{
    Text(
        text = stringResource(body),
        textAlign = TextAlign.Justify,
        modifier = modifier
    )
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
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = headerImage,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
        Title(
            title = title,
            modifier = modifier.padding(16.dp)
        )
        LargeText(
            body = description,
            modifier = modifier.padding(start = 16.dp, end = 16.dp)
        )
        LargeText(
            body = body,
            modifier = modifier.padding(16.dp)
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