package com.example.myapplicationconstraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myapplicationconstraintlayout.ui.theme.MyApplicationConstraintLayoutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationConstraintLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   MyBoxes()
                }
            }
        }
    }
}

@Composable
fun MyBoxes(){
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(Color.Yellow)
    ) {
        val (box1,box2) = createRefs()
        //first box
        Box(modifier = Modifier
            .height(200.dp)
            .width(200.dp)
            .background(Color.Red)
            .constrainAs(box1) {
                top.linkTo(parent.top)
            },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "ali")
        }
        //sec box
        Box(modifier = Modifier
            .height(200.dp)
            .width(200.dp)
            .background(Color.Blue)
            .constrainAs(box2) {
                top.linkTo(box1.bottom)
            },
            contentAlignment = Alignment.Center
        ) {
            Text(text = "taha")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationConstraintLayoutTheme {
        MyBoxes()
    }
}