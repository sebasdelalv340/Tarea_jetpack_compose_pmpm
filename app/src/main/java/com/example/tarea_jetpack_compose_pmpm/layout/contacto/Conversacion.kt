package com.example.tarea_jetpack_compose_pmpm.layout.contacto

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Conversacion(nameResource: Int, alignment: Alignment.Horizontal) {
    val currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
    val conversacion = stringResource(id=nameResource)

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 5.dp)
        .padding(start = 10.dp, end = 10.dp),
        horizontalArrangement = if (alignment == Alignment.Start) Arrangement.Start else Arrangement.End
    )
    {
        Box(modifier = Modifier
            .background(color = if (alignment == Alignment.Start) Color.DarkGray else Color( 0xFF2D7C3F), shape = RoundedCornerShape(10.dp))
            .padding(horizontal = 10.dp, vertical = 2.dp)

        ) {
            Row {
                Text(
                    text = conversacion,
                    color =  Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = currentTime,
                    fontSize = 12.sp,
                    color = Color.LightGray,
                )
            }
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyConversacion(modifier: Modifier, conversacion: MutableList<Int>) {
    LazyColumn(modifier = modifier)
    {
        itemsIndexed(conversacion) { index, id ->
            val alignment = if (index % 2 == 0) Alignment.Start else Alignment.End
            Conversacion(nameResource = id, alignment)
        }
    }
}