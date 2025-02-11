package com.example.composearticle

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ComposeQuadrant(modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.weight(0.5F, true)
        ) {
            Quadrant(
                R.string.text_composable_title,
                R.string.text_composable_desc,
                Color(0xFFEADDFF),
                modifier = modifier.weight(0.5F, true)
            )
            Quadrant(
                R.string.image_composable_title,
                R.string.image_composable_desc,
                Color(0xFFD0BCFF),
                modifier = modifier.weight(0.5F, true)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.weight(0.5F, true)
        ) {
            Quadrant(
                R.string.row_composable_title,
                R.string.row_composable_desc,
                Color(0xFFB69DF8),
                modifier = modifier.weight(0.5F, true)
            )
            Quadrant(
                R.string.column_composable_title,
                R.string.column_composable_desc,
                Color(0xFFF6EDFF),
                modifier = modifier.weight(0.5F, true)
            )
        }
    }
}

@Composable
fun Quadrant(
    @StringRes quadrantTitle: Int,
    @StringRes quadrantDesc: Int,
    color: Color,
    modifier: Modifier = Modifier){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp)
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ){
            Text(
                text = stringResource(quadrantTitle),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(quadrantDesc),
                textAlign = TextAlign.Justify
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview(){
    ComposeQuadrant()
}