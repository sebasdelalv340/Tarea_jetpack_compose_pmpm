package com.example.tarea_jetpack_compose_pmpm.layout.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp

@Composable
fun MyImage(painter: Painter, descripcion: String, dp: Dp) {
    Image(
        painter = painter,
        contentDescription = descripcion,
        modifier = Modifier
            .size(dp)
            .clip(CircleShape)
    )
}
