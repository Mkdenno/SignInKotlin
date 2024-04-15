package com.example.signindemo.presentation.characterDetailScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CharacterDetailScreen(
    viewModel: CharacterDetailViewModel,
    characterId: String
) {
    val state by viewModel.state.collectAsState()
    val context= LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.getCharacterDetail(characterId)

    }

    Box(modifier = Modifier.fillMaxSize()){
        if (state.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

        if (state.errorMessage.isNotEmpty()){
            Toast.makeText(
                context,
                state.errorMessage,
                Toast.LENGTH_LONG
            ).show()
        }
        Column {
        state.data?.let{dat->
            Box (modifier = Modifier.fillMaxWidth()){
                dat.attributes.image?.let {
                    
                    AsyncImage(
                        model =it ,
                        contentDescription =null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape)
                            .align(Alignment.Center)

                    )
                }

            }
            Spacer(modifier = Modifier.height(12.dp))

            Text(text = "Nationality - ${dat.attributes.nationality}" )
            Text(text = "Born - ${dat.attributes.born}" )
            Text(text = "House - ${dat.attributes.house}" )
            Text(text = "Weight - ${dat.attributes.weight}" )
            Text(text = "Job - ${dat.attributes.jobs.joinToString(",")}" )
            Text(text = "Titles - ${dat.attributes.titles.joinToString(",")}" )

        }

    }}


}