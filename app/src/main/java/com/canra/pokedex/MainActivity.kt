package com.canra.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.canra.pokedex.ui.theme.PokeDexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokeDexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainLayout(){
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.LightGray)
            .padding(10.dp)
    ) {
        val (texttitle,backButton,hamBurgermenu,listmenu) = createRefs()
        val list = (1..10).map { it.toString() }
        IconButton(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(backButton){
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            }
        ) {
            Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "vhvhvhhv" )
        }
        IconButton(onClick = { /*TODO*/ },
        modifier = Modifier.constrainAs(hamBurgermenu){
            end.linkTo(parent.end)
            top.linkTo(parent.top)
        }
        ) {
            Icon(imageVector = Icons.Outlined.Menu, contentDescription = "")
        }
        Text(
            text = "Pokedex",
        modifier = Modifier.constrainAs(texttitle){
            start.linkTo(parent.start,margin=10.dp)
            top.linkTo(backButton.bottom, margin = 20.dp)
        },
            style = MaterialTheme.typography.titleLarge
            )
        LazyVerticalGrid(
            cells = GridCells.Adaptive(128.dp),
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 16.dp,
                end = 12.dp,
                bottom = 16.dp
            ),
            modifier = Modifier.constrainAs(listmenu){
                                 top.linkTo(texttitle.bottom, margin = 20.dp)
            },
            content = {
                items(list.size) { index ->
                        Text(
                            text = list[index],
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = Color(0xFFFFFFFF),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
            }
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokeDexTheme {
        MainLayout()
    }
}