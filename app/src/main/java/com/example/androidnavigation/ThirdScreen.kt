package com.example.androidnavigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ThirdScreen(navigationToFirstScreen : () -> Unit) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "This is the third screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Welcome to the Third Screen", fontSize = 24.sp)

        Button(onClick = {
            navigationToFirstScreen()
        }) {
            Text(text = "First Screen")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ThirdScreenPreview() {
    ThirdScreen({})
}