package com.example.signindemo.presentation.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.signindemo.data.models.Attributes

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel
) {
    val state by homeViewModel.state.collectAsState()
    
    Box(modifier = Modifier
        .fillMaxSize(),


    ){
        if (state.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
            
        }
        if (state.errorMessage.isNotEmpty()){
            Text(
                text = state.errorMessage,
                modifier = Modifier.align(Alignment.Center),
                color=MaterialTheme.colorScheme.error
            )
        }
        
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
            items(state.data){ character->
                CharacterItem(attributes = character.attributes) {

                }
            }


        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterItem(
    modifier: Modifier =Modifier,
    attributes: Attributes,
    
    onClick:()->Unit
) {
    Card (
        onClick=onClick,
        modifier = Modifier
            .fillMaxWidth()
    ){
      Row {
          attributes.image?.let {
              AsyncImage(
                  model =it ,
                  contentDescription =attributes.name,
                  contentScale = ContentScale.Crop,
                  modifier = Modifier.size(200.dp)

              )
          }

          
          Spacer(modifier = Modifier.width(8.dp))
          
          Column {
              attributes.name?.let {
                  Text(text = it , fontSize = 22.sp)


              }
              Spacer(modifier = Modifier.width(8.dp))

              attributes.gender?.let {
                  Text(text = attributes.gender)
              }


          }
          
          

      }

    }


}

