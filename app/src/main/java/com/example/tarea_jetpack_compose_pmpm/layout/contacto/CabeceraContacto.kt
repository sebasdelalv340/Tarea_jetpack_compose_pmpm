package com.example.tarea_jetpack_compose_pmpm.layout.contacto

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tarea_jetpack_compose_pmpm.R

@Composable
fun MyCabeceraContacto(navController: NavController, texto: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Buscar",
            modifier = Modifier.weight(0.2f)
                .clickable {navController.popBackStack()},
            tint = Color.White
        )
        texto?.let {
            Text(
                text = it,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

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