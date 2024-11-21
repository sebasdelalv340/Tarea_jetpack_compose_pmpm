package com.example.tarea_jetpack_compose_pmpm.layout.contacto

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.tarea_jetpack_compose_pmpm.layout.main.DivisorHorizontal

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyContactLayout(modifier: Modifier = Modifier, navController: NavController, texto: String?) {
    // Misma operación que en los contactos.
    val conversacion = cargarConversacion(LocalContext.current)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF191C1A))
    ){
        MyCabeceraContacto(navController, texto)

        DivisorHorizontal(3)

        MyConversacion(modifier = Modifier.weight(1f), conversacion)

        MyFooterMensaje()
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