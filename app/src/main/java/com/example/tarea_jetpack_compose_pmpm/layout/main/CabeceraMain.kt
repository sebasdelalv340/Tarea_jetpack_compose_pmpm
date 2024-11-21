package com.example.tarea_jetpack_compose_pmpm.layout.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tarea_jetpack_compose_pmpm.R

@Composable
fun MyCabecera() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.whatsApp),
            modifier = Modifier
                .weight(1f)
                .padding(start = 10.dp),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Image(
            painter = painterResource(id = R.drawable.camara_white),
            contentDescription = "camara",
            modifier = Modifier
                .weight(0.15f)
                .padding(end = 10.dp)
        )
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Buscar",
            modifier = Modifier.weight(0.2f),
            tint = Color.White
        )
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Menu",
            modifier = Modifier.weight(0.2f),
            tint = Color.White
        )
    }
}