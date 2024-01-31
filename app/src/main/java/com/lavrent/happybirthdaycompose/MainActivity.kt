package com.lavrent.happybirthdaycompose

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lavrent.happybirthdaycompose.ui.theme.HappyBirthdayComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = "Happy Birthday Andrey!",
                        from = "From Pavel"
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText( // составная функция
    message: String, // сообщение пощдравление
    from: String, // от кого поздравление
    modifier: Modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
) {
    Column( // столбец
        modifier = modifier, // отступы вокруг столбца
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = message, // текст
            fontSize = 100.sp, // размер шрифта
            lineHeight = 116.sp, // высота строки
            textAlign = TextAlign.Center // выравнивание текста по центру
        )
        Text(
            text = from, // текст
            fontSize = 36.sp, // размер шрифта
            modifier = Modifier // модификатор в Compose
                .padding(16.dp) // отступ подписи
                .align(alignment = Alignment.End) // выравнивание по правому краю текста "от кого"
        )
    }
}

@Composable
fun GreetingImage(
    message: String,
    from: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(id = R.drawable.androidparty) // painterResource ф-ия загружает ресурс с возможностью рисования изображений и принимает идентификатор ресурса в качестве аргумента
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp))
    }
}

@Preview( // аннотация пердназначена только для предварительного просмотра ан панеле Design
    showBackground = true, // добавление фона
    //showSystemUi = true // показывает интерфейс смартфона
)
@Composable // обозначение составной функци в Compose, эта функция предназначена для преобразования данных в пользовательский интерфейс
fun BirthdayCardPreview() {
    HappyBirthdayComposeTheme {
        GreetingImage(
            message = "Happy Birthday Andrey!", // сообщение поздравление
            from = "From Pavel" // от кого поздравление
        )
    }
}