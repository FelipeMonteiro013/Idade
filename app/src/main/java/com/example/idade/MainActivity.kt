package com.example.idade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.idade.ui.theme.IdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IdadeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme

                Surface(

                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    CounterScreen()
                }
            }
        }
    }
}

fun verifyAge(idade: Int) : String {
    return if (idade >= 18) {
        "Você é MAIOR de idade!"
    } else {
        "Você é MENOR de idade!"
    }
}

@Composable
fun CounterScreen() {

    val idade = remember {
        mutableIntStateOf(0)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Qual a sua idade",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE91E63)
        )

        Text(
            text = "Aperte os botões para informar sua idade.",
            color = Color(0xFF5F5F5F),
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "${idade.intValue}", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(30.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(
                onClick = {
                    if (idade.intValue > 0) {
                        idade.intValue--
                    }
                },
                modifier = Modifier.size(80.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE91E63)
                )
            ) {
                Text(text = "-", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    idade.intValue++
                },
                modifier = Modifier.size(80.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE91E63)
                )
            ) {
                Text(text = "+", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            }

        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = verifyAge(idade.intValue),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFE91E63)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CounterScreenPreview() {
    CounterScreen()
}
