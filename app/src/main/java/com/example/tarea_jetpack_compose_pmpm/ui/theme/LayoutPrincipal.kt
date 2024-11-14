package com.example.tarea_jetpack_compose_pmpm.ui.theme

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
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
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
import com.example.tarea_jetpack_compose_pmpm.R
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyWhatsApp(modifier: Modifier) {
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
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color.Gray
            )
            MyLazyColumn(listaContacto)

        }

        MyFooter(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .align(Alignment.BottomCenter)
        )
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Contacto(nameResource: Int) {
    val currentTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = Icons.Default.Person,
            tint = Color.White,
            contentDescription = "Contacto",
            modifier = Modifier.weight(0.2f))
        Spacer(modifier = Modifier.weight(0.1f))
        Text(text = stringResource(id=nameResource),
            modifier = Modifier.weight(1f),
            color =  Color.White,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(0.1f))
        Text(
            text = currentTime,
            fontSize = 12.sp,
            modifier = Modifier.padding(end = 20.dp),
            color = Color.Gray,
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyLazyColumn(contactos: MutableList<Int>) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 40.dp)) {
        items(contactos) { id ->
            Contacto(nameResource = id)
        }
    }
}

@Composable
fun MyFooter(modifier: Modifier) {
    Column(modifier = modifier.height(30.dp)) {
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = Color.Gray
        )
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Icon(imageVector = Icons.Default.Email,
                contentDescription = "chats",
                modifier = Modifier.weight(0.2f),
                tint = Color.White
            )
            Icon(imageVector = Icons.Default.Info,
                contentDescription = "novedades",
                modifier = Modifier.weight(0.2f),
                tint = Color.White
            )
            Icon(imageVector = Icons.Default.Face,
                contentDescription = "comunidades",
                modifier = Modifier.weight(0.2f),
                tint = Color.White
            )
            Icon(imageVector = Icons.Default.Call,
                contentDescription = "comunidades",
                modifier = Modifier.weight(0.2f),
                tint = Color.White
            )
        }
    }
}

@SuppressLint("DiscouragedApi")
fun cargarContactos(context: Context): MutableList<Int> {
    val listaContactos = mutableListOf<Int>()
    val resources = context.resources
    val packageName = context.packageName

    // Obtener todos los recursos 'string' que empiezan con "contacto_"
    // No hay una forma directa de obtener todos los recursos sin conocer su nombre, así que probamos un rango.
    var index = 1
    while (true) {
        val resourceName = "contacto_$index"  // Nombre de recurso esperado: contacto_1, contacto_2, etc.
        val resourceId = resources.getIdentifier(resourceName, "string", packageName)

        // Si el recurso no existe, salimos del bucle
        if (resourceId == 0) break

        listaContactos.add(resourceId)
        index++
    }

    return listaContactos
}