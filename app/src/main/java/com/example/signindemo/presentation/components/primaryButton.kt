package com.example.signindemo.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(

    modifier: Modifier =Modifier,
    label:String,
    onClick:()-> Unit
) {
    Button(onClick = onClick,
    modifier=Modifier
        .fillMaxWidth(),
        shape= RoundedCornerShape(8.dp)

    ) {
      Text(text = label)
    }

}