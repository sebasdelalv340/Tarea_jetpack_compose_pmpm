package com.example.tarea_jetpack_compose_pmpm.layout.main

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyWhatsApp(modifier: Modifier, navController: NavController) {
    // Le pasamos el contexto de nuestra app local para que pueda acceder al archivo
    val listaContacto = cargarContactos(LocalContext.current)

    Column(
        modifier = modifier
        .fillMaxSize()
        .background(color = Color(0xFF191C1A))
    ){
        MyCabecera()
        DivisorHorizontal(3)
        MyContactos(Modifier.weight(1f),listaContacto, navController)
        MyFooter(modifier = Modifier
            .fillMaxWidth()
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
