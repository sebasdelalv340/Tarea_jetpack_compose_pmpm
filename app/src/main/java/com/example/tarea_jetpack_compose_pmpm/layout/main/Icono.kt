package com.example.tarea_jetpack_compose_pmpm.layout.main

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun MyIcono(icono: ImageVector, descripcion: String) {
    Icon(imageVector = icono,
        contentDescription = descripcion,
        modifier = Modifier.size(25.dp),
        tint = Color.White
    )
}