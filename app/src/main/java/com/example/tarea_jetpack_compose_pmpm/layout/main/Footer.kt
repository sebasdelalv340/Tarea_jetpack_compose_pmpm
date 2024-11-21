package com.example.tarea_jetpack_compose_pmpm.layout.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyFooter(modifier: Modifier) {
    Column(modifier = modifier) {
        DivisorHorizontal(3)
        Row(modifier = Modifier.fillMaxWidth()
            .height(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            MyIcono(Icons.Default.Email, "chats")
            MyIcono(Icons.Default.Info, "novedades")
            MyIcono(Icons.Default.Face, "comunidades")
            MyIcono(Icons.Default.Call, "llamadas")
        }
    }
}