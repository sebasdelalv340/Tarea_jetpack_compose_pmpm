package com.example.tarea_jetpack_compose_pmpm.layout.main

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tarea_jetpack_compose_pmpm.R

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyWhatsApp(modifier: Modifier, navController: NavController) {
    // Le pasamos el contexto de nuestra app local para que pueda acceder al archivo
    val listaContacto = cargarContactos(LocalContext.current)

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
                Text(
                    text = stringResource(R.string.whatsApp),
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 10.dp),
                    fontSize = 20.sp,
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
            DivisorHorizontal(3)
            MyContactos(listaContacto, navController)

        }

        MyFooter(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter)
        )
    }
}


@SuppressLint("DiscouragedApi")
fun cargarContactos(context: Context): MutableList<Int> {
    val listaContactos = mutableListOf<Int>()
    val resources = context.resources
    val packageName = context.packageName

    // Obtener todos los recursos 'string' que empiezan con "contacto_"
    // Bucle para recorrer nuestro recursos que tienen asignado un nombre.
    var index = 1
    while (true) {
        val resourceName = "contacto_$index"  // Nombre de recurso esperado: contacto_1, contacto_2, etc.
        val resourceId = resources.getIdentifier(resourceName, "string", packageName) // ID del recurso

        // Si el recurso no existe, salimos del bucle
        if (resourceId == 0) break

        listaContactos.add(resourceId)
        index++
    }

    return listaContactos
}


@Composable
fun DivisorHorizontal(grosor: Int) {
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = grosor.dp,
        color = Color.Gray
    )
}