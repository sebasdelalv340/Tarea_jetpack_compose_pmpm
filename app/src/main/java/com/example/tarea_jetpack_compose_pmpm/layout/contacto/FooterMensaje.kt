package com.example.tarea_jetpack_compose_pmpm.layout.contacto


import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarea_jetpack_compose_pmpm.R
import com.example.tarea_jetpack_compose_pmpm.layout.main.MyIcono
import com.example.tarea_jetpack_compose_pmpm.layout.main.MyImage

@Composable
fun MyFooterMensaje() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color(0xFF191C1A)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.padding(5.dp))
        MyIcono(Icons.Default.Face, "emojis")
        MyMensaje(Modifier.weight(1f))
        MyIcono(Icons.Default.Add, "adjuntar")
        MyImage(painterResource(id = R.drawable.camara_white), "camara", 30.dp)
        MyImage(painterResource(id = R.drawable.microfono), "micro", 60.dp)
        Spacer(modifier = Modifier.padding(5.dp))
    }
}

@Composable
fun MyMensaje(modifier: Modifier) {
    val textState = remember { mutableStateOf("") }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = {
            Text(
                text = "Mensaje",
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 1, // Evita que el texto se desborde
            )
        },
        modifier = modifier
            .padding(start = 10.dp, end = 10.dp)
    )
}

