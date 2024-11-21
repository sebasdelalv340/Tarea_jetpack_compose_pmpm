package com.example.tarea_jetpack_compose_pmpm.layout.contacto

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tarea_jetpack_compose_pmpm.R
import com.example.tarea_jetpack_compose_pmpm.layout.main.DivisorHorizontal
import com.example.tarea_jetpack_compose_pmpm.layout.main.MyFooter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyContactLayout(modifier: Modifier, navController: NavController, texto: String?) {
    // Misma operación que en los contactos.
    val conversacion = cargarConversacion(LocalContext.current)
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF191C1A))
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()){
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

            DivisorHorizontal(3)

            MyConversacion(conversacion)

        }

        MyFooter(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
        )
    }
}

@SuppressLint("DiscouragedApi")
fun cargarConversacion(context: Context): MutableList<Int> {
    val listaConversacion = mutableListOf<Int>()
    val resources = context.resources
    val packageName = context.packageName

    // Obtener todos los recursos 'string' que empiezan con "conversacion_"
    var index = 1
    while (true) {
        val resourceName = "conversacion_$index"
        val resourceId = resources.getIdentifier(resourceName, "string", packageName)

        // Si el recurso no existe, salimos del bucle
        if (resourceId == 0) break

        listaConversacion.add(resourceId)
        index++
    }

    return listaConversacion
}