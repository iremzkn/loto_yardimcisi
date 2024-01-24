package com.example.loto_onerisi



import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font


import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loto_onerisi.ui.theme.Loto_onerisiTheme
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Loto_onerisiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(22, 26, 48)
                ) {
                    Greeting()

                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {

    var kolonSayisi by remember { mutableStateOf("") }
    var sansliSayi by remember { mutableStateOf("") }
    var sansliSayi2 by remember { mutableStateOf("") }

    var tiklandi by remember { mutableStateOf(false)}


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(240, 236, 229)),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(color = Color(22, 26, 48)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ){
            Text(
                text = "Şanslı Uygulama",
                color = Color(182, 187, 196),
                modifier = Modifier.padding(20.dp),
                fontSize = 28.sp,
                style = TextStyle(
                    fontFamily = FontFamily.Serif
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp, 50.dp, 50.dp, 30.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = kolonSayisi,
                onValueChange = {
                    if(it.isBlank()) kolonSayisi = it
                    else if(it.toIntOrNull() != null && it.toInt() <= 10)
                        kolonSayisi= it
                                },
                label= {Text("Kolon sayısı giriniz:")},
                modifier = Modifier
                    .width(310.dp)
                    .height(60.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(182, 187, 196),
                    focusedBorderColor = Color(49, 48, 77),
                    focusedLabelColor = Color(49, 48, 77),
                    unfocusedLabelColor = Color(49, 48, 77)
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp, 10.dp, 5.dp, 0.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text= "Varsa şanslı sayınızı giriniz:", color = Color(49, 48, 77))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = sansliSayi,
                onValueChange = {sansliSayi= it},
                label= {Text("Şanslı sayınız:")},
                modifier = Modifier
                    .width(150.dp)
                    .height(60.dp)
                    .padding(0.dp, 0.dp, 5.dp, 0.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(182, 187, 196),
                    focusedBorderColor = Color(49, 48, 77),
                    focusedLabelColor = Color(49, 48, 77),
                    unfocusedLabelColor = Color(49, 48, 77)
                )
            )

            OutlinedTextField(
                value = sansliSayi2,
                onValueChange = {sansliSayi2= it},
                label= {Text("Şanslı sayınız:")},
                modifier = Modifier
                    .width(150.dp)
                    .height(60.dp)
                    .padding(5.dp, 0.dp, 0.dp, 0.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(182, 187, 196),
                    focusedBorderColor = Color(49, 48, 77),
                    focusedLabelColor = Color(49, 48, 77),
                    unfocusedLabelColor = Color(49, 48, 77)
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(35.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            Button(
                onClick = { tiklandi = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(49, 48, 77),
                    contentColor = Color(240, 236, 229)
                ),
                modifier = Modifier
                    .width(150.dp)
                    .height(70.dp)
            ) {
                Text(text = "Öneriyi Gör", fontSize = 17.sp)
            }
        }

        if (tiklandi== true){

            var sayi= 0
            if(kolonSayisi != ""){
                sayi = kolonSayisi.toInt()
            }

            if(sayi != 0){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                        .height(150.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    var i= 0
                    var j= 0
                    var sonuc= mutableListOf<String>()
                    val a= Random.nextInt(0,sayi)
                    val b= Random.nextInt(0,sayi)


                    while (i< sayi){
                        sonuc.add(generateLotoNumbers())
                        i+=1
                    }

                    if (sansliSayi!=""){
                        sonuc[a]= sansliSayi
                    }

                    if (sansliSayi2!=""){
                        if (b!=a)
                            sonuc[b]= sansliSayi2
                        else if (b==a) {
                            val b = Random.nextInt(0, sayi)
                            if (b!=a)
                                sonuc[b]= sansliSayi2
                        }
                    }

                    while (j< sayi){
                        Column(
                            modifier = Modifier
                                .background(color = Color(182, 187, 196))
                                .padding(8.dp)
                        ) {
                            Text(text = sonuc[j],color = Color(49, 48, 77) )
                            j++;
                        }
                        Column (
                            modifier = Modifier
                                .width(1.dp)
                                .background(color = Color(240, 236, 229))
                        ){

                        }
                    }

                }
            }
        }

        }
    }



fun generateLotoNumbers(): String {
    val randomNumber = Random.nextInt(0, 50).toString()

    return randomNumber;
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Loto_onerisiTheme {
        Greeting()
    }
}