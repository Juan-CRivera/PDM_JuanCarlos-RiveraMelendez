package com.example.laboratorio2

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun JCRMCUATRO(modifier: Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        val lista = remember { mutableStateListOf<String>("") }
        var nombre by remember { mutableStateOf("") }

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Ingrese su nombre") },
            placeholder = { Text("Nombre") }
        )

        Button(onClick = { lista.add(nombre) }) {
            Text(text = "Guardar")
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Listado de nombres y posicion en la lista")
            Button(onClick = { lista.clear() }) {
                Text(text = "Limpiar")
            }
        }
        Column(
            modifier = Modifier
                .height(200.dp)
                .padding(10.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.White)
                    .border(
                        width = 8.dp,
                        color = Color.Blue,
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                itemsIndexed(lista) { index, item -> Column(
                        modifier = Modifier
                            .fillMaxWidth()
                        ){
                        Text(text = item)
                        Text(text = (index + 1).toString())
                }
            }
        }
    }
}
}
